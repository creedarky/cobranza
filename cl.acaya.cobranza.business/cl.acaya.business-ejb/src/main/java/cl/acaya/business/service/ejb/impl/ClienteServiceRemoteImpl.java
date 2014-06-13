package cl.acaya.business.service.ejb.impl;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.sap.Connect;
import cl.acaya.api.service.ClienteServiceRemote;
import cl.acaya.business.service.ejb.CobranzaServiceLocal;
import cl.acaya.api.util.SapConnectionFactory;
import cl.acaya.api.vo.*;
import cl.acaya.api.vo.enums.TipoCuentasKupferType;
import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.dao.ContingenciaDAO;
import cl.acaya.cobranza.business.daoEjb.dao.DocumentoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.*;
import cl.acaya.cobranza.business.daoEjb.util.TypesAdaptor;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

import javax.ejb.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maximiliano on 11/06/2014.
 */
@Stateless(name = "ClienteServiceRemote", mappedName = "ejb/ClienteServiceRemote")
@Remote(ClienteServiceRemote.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClienteServiceRemoteImpl implements  ClienteServiceRemote{


    @EJB
    ClienteDAO clienteDAO;

    @EJB
    ContingenciaDAO contingenciaDAO;

    @EJB
    DocumentoDAO documentoDAO;

    @EJB
    CobranzaServiceLocal cobranzaServiceLocal;


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response getDatosGestionCliente(Request request) {
        Response response = new Response();
        Long idCliente = request.getParam(Parametros.ID_CLIENTE, Long.class);
        Cliente cliente = clienteDAO.find(idCliente);
        request.addParam(BusinessParameter.RUT_CLIENTE, cliente.getRutCliente());
        request.addParam(BusinessParameter.SOCIEDAD, "1000");
        request.addParam(Parametros.CLIENTE, cliente);
        response = cobranzaServiceLocal.obtenerDocumentosSAP(request);
        List<Object[]> resultList = documentoDAO.getCarteraClienteByIdCliente(idCliente);
        List<DocumentoClienteVO> documentoClienteVOList = new ArrayList<DocumentoClienteVO>(resultList.size());
        System.out.println(resultList.size());
        for(Object[] result: resultList) {
            String razonSocial = (String) result[0];
            //Long res = ((BigDecimal) result[1]).longValue();
            String rutCliente = (String) result[1];
            String tramo = (String) result[2];
            Integer diasVencidos = (Integer) result[3];
            BigDecimal monto = (BigDecimal) result[4];
            String numDoc = (String) result[5];
            String vendedor = (String) result[6];
            String codigoTipo = (String) result[7];
            Date fechaEmision = (Date) result[8];
            Date fechaVencimiento = (Date) result[9];
            Long idDocumento = ((BigDecimal) result[10]).longValue();
            DocumentoClienteVO documentoClienteVO = new DocumentoClienteVO();
            documentoClienteVO.setNumDoc(numDoc);
            documentoClienteVO.setTramo(tramo);
            documentoClienteVO.setCodigoTipo(codigoTipo);
            documentoClienteVO.setMonto(monto);
            documentoClienteVO.setRazonSocial(razonSocial);
            documentoClienteVO.setRut(rutCliente);
            documentoClienteVO.setDiasVencidos(diasVencidos);
            documentoClienteVO.setVendedor(vendedor);
            documentoClienteVO.setFechaVencimiento(fechaVencimiento);
            documentoClienteVO.setFechaEmision(fechaEmision);
            documentoClienteVO.setIdDocumento(idDocumento);
            documentoClienteVOList.add(documentoClienteVO);
        }
        System.out.println("Size " + documentoClienteVOList.size());
        if(documentoClienteVOList.size() > 0 ) {
            List<Object[]> resultadoCartera = documentoDAO.getTotalCarteraClientesByIdCliente(idCliente);
            ResumenInicialVO resumenInicialVO = cobranzaServiceLocal.getCarteraPorTramos(resultadoCartera);
            if(resumenInicialVO != null && resumenInicialVO.getTramoVOList() != null && !resumenInicialVO.getTramoVOList().isEmpty()) {
                List<TramoVO> tramoVOList = resumenInicialVO.getTramoVOList();
                response.addResp(Parametros.TRAMOS, tramoVOList);
                response.addResp(Parametros.CARTERA_CLIENTE, resumenInicialVO.getCarteraVOList().get(0) );

            }
        }

        List<Contingencia> contingenciaList =  contingenciaDAO.findAll();
        List<ContingenciaVO> contingenciaVOList = new ArrayList<ContingenciaVO>();
        for(Contingencia contingencia : contingenciaList) {
            ContingenciaVO contingenciaVO = new ContingenciaVO();
            contingenciaVO.setContingencia(contingencia.getContingencia());
            contingenciaVO.setTipo(contingencia.getTipo());
            contingenciaVOList.add(contingenciaVO);
        }
        response.addResp(Parametros.CONTINGENCIAS, contingenciaVOList);

        response.addResp(Parametros.DOCUMENTOS_CLIENTE, documentoClienteVOList);
        Connect connect = SapConnectionFactory.newConecction();
        JCoFunction functionDatosClientes = connect.getFunction("ZSDFN_DATOS_CLIENTE_11"); // Nombre RFC
        functionDatosClientes.getImportParameterList().setValue("RUTCLIENTE", cliente.getRutCliente().toUpperCase()); // Paso
        connect.execute(functionDatosClientes);
        JCoTable datosCliente = functionDatosClientes.getTableParameterList().getTable("DATOS_CLIE");

        if (datosCliente != null) {
            String swExiste = (String) functionDatosClientes.getExportParameterList().getValue("SW_EXISTE");

            if ("S".equals(swExiste)) {
                cliente.setClasificacionRiesgo(datosCliente.getString("CLSRIESGO"));
                cliente.setVigencia((String) datosCliente.getValue("VIGSEGURO"));
                cliente.setMontoSeguro(((BigDecimal) functionDatosClientes.getExportParameterList().getValue("MTOSEGURO_P")).longValue());
                cliente.setMontoSeguroUF(functionDatosClientes.getExportParameterList().getBigDecimal("MTOSEGURO").doubleValue());
                cliente.setCondicionPago(datosCliente.getString("CONPAGO"));
                cliente.setTipoSeguro(datosCliente.getString("TIPSEGURO"));
                cliente.setLineaCredito(datosCliente.getBigDecimal("LINCREDITO").longValue() * 100);
                cliente.setCanalVenta(TipoCuentasKupferType.getNombreCuentaPorCodigoCanal((String) functionDatosClientes.getExportParameterList().getValue("CANAL")));
                cliente.setLineaCreditoDisponible(functionDatosClientes.getExportParameterList().getBigDecimal("LINDISPONIBLE").longValue());
                cliente.setLineaCreditoUtilizada(cliente.getLineaCredito() - cliente.getLineaCreditoDisponible());
                cliente.setEstadoLinea(functionDatosClientes.getExportParameterList().getString("ESTADO_LC_KH"));
                JCoFunction funcPedidos = connect.getFunction("ZSDFN_FRONT_PEDCOT_R");
                funcPedidos.getImportParameterList().setValue("RUTCLIENTE",cliente.getRutCliente());
                connect.execute(funcPedidos);
                if (funcPedidos.getTableParameterList().getTable("DETALLE").getNumRows() == 0) {
                    funcPedidos.getImportParameterList().setValue("RUTCLIENTE",cliente.getRutCliente().toUpperCase());
                    connect.execute(funcPedidos);
                }
                long flujoPedidoProceso = 0;
                JCoTable pedidosEnProceo = funcPedidos.getTableParameterList().getTable("DETALLE");
                for (int i = 0; i < pedidosEnProceo.getNumRows(); i++) {
                    pedidosEnProceo.setRow(i);
                    String tipo = pedidosEnProceo.getString(0);
                    if (tipo.toLowerCase().equals("p")) {
                        flujoPedidoProceso += pedidosEnProceo.getBigDecimal("MONTO").longValue();
                    }
                }
                cliente.setPedidosEnProceso(flujoPedidoProceso);


                cliente = clienteDAO.update(cliente);

            }
        }

        ClienteVO clienteVO = TypesAdaptor.adaptar(cliente);
        response.addResp(Parametros.CLIENTE, clienteVO);

        return response;

    }






}
