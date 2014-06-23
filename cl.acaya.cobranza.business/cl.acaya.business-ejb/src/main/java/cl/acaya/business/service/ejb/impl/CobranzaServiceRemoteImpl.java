package cl.acaya.business.service.ejb.impl;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.business.sap.Connect;
import cl.acaya.business.service.ejb.CobranzaServiceLocal;
import cl.acaya.business.sap.SapConnectionFactory;
import cl.acaya.api.vo.*;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.enums.TipoCuentasKupferType;
import cl.acaya.cobranza.business.daoEjb.dao.*;
import cl.acaya.cobranza.business.daoEjb.entities.*;
import cl.acaya.cobranza.business.daoEjb.util.TypesAdaptor;
import cl.acaya.cobranza.business.daoEjb.util.comparator.TramoVOComparator;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.transaction.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by mcastro on 21-05-14.
 */
@Stateless(name = "CobranzaServiceRemote", mappedName = "ejb/CobranzaServiceRemote")
@Remote(CobranzaServiceRemote.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class CobranzaServiceRemoteImpl implements CobranzaServiceRemote, CobranzaServiceLocal {

    @EJB
    DocumentoDAO documentoDAO;

    @EJB
    ClienteDAO clienteDAO;

    @EJB
    DMClienteDAO dmClienteDAO;

    @EJB
    UsuarioDAO usuarioDAO;

    @EJB
    TipoDocumentoDAO tipoDocumentoDAO;

    @EJB
    SociedadDAO sociedadDAO;

    @EJB
    SucursalDAO sucursalDAO;

    @EJB
    AsignacionClienteDAO asignacionClienteDAO;

    @EJB
    VendedorDAO vendedorDAO;

    @EJB
    AgendaDAO agendaDAO;

    @EJB
    CargoContactoDAO cargoContactoDAO;

    @Resource
    private UserTransaction userTransaction;


    private final static DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private final static TramoVOComparator TRAMO_VO_COMPARATOR = new TramoVOComparator();

    //@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response obtenerDocumentosSAP(Request request) {
        try {
            //pruebasap(request);
            //if(true)
                //return null;

            Connect connect = SapConnectionFactory.newConecction();
            JCoFunction function = connect.getFunction("ZFIFN_SCKCOB_PARTIDAS"); //Nombre RFC

            JCoParameterList pl = function.getImportParameterList();

            String rutCliente = request.getParam(BusinessParameter.RUT_CLIENTE, String.class);
            Long codigoSociedad = Long.valueOf(request.getParam(BusinessParameter.SOCIEDAD, String.class));

            function.getImportParameterList().setValue("SOCIEDAD", codigoSociedad); //Paso de parametros
            function.getImportParameterList().setValue("RUTCLIE", rutCliente); //Paso de parametros
            System.out.println(function + "no ejecutada");
            connect.execute(function);
            System.out.println(function + "ejecutada");
            JCoTable table = function.getTableParameterList().getTable("TSALIDA"); //Tabla de Salida
            System.out.println("filas " + table.getNumRows());
            //System.out.println(table);
            Cliente cliente = request.getParam(Parametros.CLIENTE, Cliente.class);
            DmCliente dmCliente = null;
            List<PartidasSAPVO> documentosList = new ArrayList<PartidasSAPVO>(table.getNumRows());

            Date lastUpdate = new Date();
            try {
                    userTransaction.begin();
                    for (int i = 0; i < table.getNumRows(); i++) {
                        table.setRow(i);
                        PartidasSAPVO documentoVO = new PartidasSAPVO();
                        documentoVO.setCodigoSociedad(table.getString("CODSOCI"));
                        documentoVO.setCodigoCliente(table.getString("CODDEST"));
                        documentoVO.setCodigoOperacion(table.getString("CLAOPER"));
                        documentoVO.setIndicacionOperacion(table.getString("INDCME"));
                        documentoVO.setFechaCompensacion(table.getDate("FECCOMP"));
                        documentoVO.setNumeroDocumentoCompensacion(table.getString("DOCCOMP"));
                        documentoVO.setNumeroAsignacion(table.getString("NUMASIG"));
                        documentoVO.setNumeroEjercicio(table.getInt("NUMAGNO"));
                        documentoVO.setNumeroContable(table.getString("DOCCONT"));
                        documentoVO.setNumeroApunte(table.getInt("NUMCORR"));
                        documentoVO.setRutCliente(table.getString("RUTCLIE"));
                        documentoVO.setFechaContable(table.getDate("FECCONT"));
                        documentoVO.setFechaDocumento(table.getDate("FECDOCU"));
                        documentoVO.setClaseDocumento(table.getString("CLADOCU"));
                        Double monto = table.getDouble("MTOCOBR");
                        documentoVO.setMontoCobrar(monto.intValue());
                        documentoVO.setIndicadorSentido(table.getString("INDSENT"));
                        documentoVO.setFechaVencimiento(table.getDate("FECVCTO"));
                        documentoVO.setNombreResponsable(table.getString("CODEMIS"));
                        documentoVO.setOficinaResponsable(table.getString("SUCRESP"));
                        documentoVO.setNumeroFactura(table.getString("NUMFACT"));
                        documentoVO.setFolioSii(table.getString("FOLSII"));
                        documentoVO.setClavePago(table.getString("CONPAGO"));
                        documentoVO.setCodigoCobrador(table.getInt("CODCOBR"));
                        documentoVO.setGrupoMateriales(table.getString("CODCANAL"));
                        documentoVO.setOrdenCompra(table.getString("ORDCOMP"));
                        documentoVO.setCodigoCuenta(table.getString("CODCUEN"));
                        documentoVO.setNombreCliente(table.getString("NOMCLIE"));
                        documentoVO.setFacturaRelacionada(table.getString("FACTNCR"));
                        Documento d = TypesAdaptor.adaptar(documentoVO);
                        d.setLastUpdate(lastUpdate);
                        cliente = new Cliente();
                        dmCliente = new DmCliente();
                        dmCliente.setCliente(cliente);
                        dmCliente.setDmCliente(documentoVO.getCodigoCliente());
                        dmCliente = dmClienteDAO.findOrCreate(dmCliente);
                        TipoDocumento tipoDocumento = new TipoDocumento();
                        tipoDocumento.setCodigoTipo(documentoVO.getClaseDocumento());
                        tipoDocumento.setIndicadorSentido(documentoVO.getIndicadorSentido());
                        tipoDocumento = tipoDocumentoDAO.findOrCreate(tipoDocumento);
                        d.setTipoDocumento(tipoDocumento);
                        Sociedad sociedad = new Sociedad();
                        sociedad.setCodigoSociedad(documentoVO.getCodigoSociedad());
                        sociedad = sociedadDAO.findOrCreate(sociedad);
                        Vendedor vendedor = new Vendedor();
                        vendedor.setCodigoVendedor(documentoVO.getNombreResponsable());
                        vendedor = vendedorDAO.findOrCreate(vendedor);
                        Sucursal sucursal = new Sucursal();
                        sucursal.setCodigoSucursal(documentoVO.getOficinaResponsable());
                        sucursal = sucursalDAO.findOrCreate(sucursal);
                        d.setSucursal(sucursal);
                        d.setVendedor(vendedor);
                        d.setDmCliente(dmCliente);
                        d.setSociedad(sociedad);

                        documentoDAO.findOrCreate(d);
                        documentosList.add(documentoVO);
                        if(i%50 == 0 || table.getNumRows() - i == 1) {
                            userTransaction.commit();
                            userTransaction.begin();;
                        }
                    }


            }catch (Exception e) {
                userTransaction.rollback();
            }


        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            if(userTransaction.getStatus() == Status.STATUS_ACTIVE)
                userTransaction.commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return new Response();
    }




    public Response ejecutarCargaMasiva() {
        try {
            Connect connect = SapConnectionFactory.newConecction();
            JCoFunction function = connect.getFunction("ZFIFN_SCKCOB_PARTIDAS_T"); //Nombre RFC

            JCoParameterList pl = function.getImportParameterList();

            Integer inicio = 0;
            Integer fin = 500;

            function.getImportParameterList().setValue("IND1", inicio.toString()); //Paso de parametros
            function.getImportParameterList().setValue("IND2", fin.toString()); //Paso de parametros
            System.out.println(function + "no ejecutada");
            connect.execute(function);
            System.out.println(function + "ejecutada");
            JCoTable table = function.getTableParameterList().getTable("TSALIDA"); //Tabla de Salida
            Cliente cliente = null;
            DmCliente dmCliente = null;
            Date lastUpdate = new Date();
            do {
                try {
                    userTransaction.begin();
                    List<PartidasSAPVO> documentosList = new ArrayList<PartidasSAPVO>(table.getNumRows());
                    for (int i = 0; i < table.getNumRows(); i++) {
                        table.setRow(i);
                        PartidasSAPVO documentoVO = new PartidasSAPVO();
                        documentoVO.setCodigoSociedad(table.getString("CODSOCI"));
                        documentoVO.setCodigoCliente(table.getString("CODDEST"));
                        documentoVO.setCodigoOperacion(table.getString("CLAOPER"));
                        documentoVO.setIndicacionOperacion(table.getString("INDCME"));
                        documentoVO.setFechaCompensacion(table.getDate("FECCOMP"));
                        documentoVO.setNumeroDocumentoCompensacion(table.getString("DOCCOMP"));
                        documentoVO.setNumeroAsignacion(table.getString("NUMASIG"));
                        documentoVO.setNumeroEjercicio(table.getInt("NUMAGNO"));
                        documentoVO.setNumeroContable(table.getString("DOCCONT"));
                        documentoVO.setNumeroApunte(table.getInt("NUMCORR"));
                        documentoVO.setRutCliente(table.getString("RUTCLIE"));
                        documentoVO.setFechaContable(table.getDate("FECCONT"));
                        documentoVO.setFechaDocumento(table.getDate("FECDOCU"));
                        documentoVO.setClaseDocumento(table.getString("CLADOCU"));
                        Double monto = table.getDouble("MTOCOBR");
                        documentoVO.setMontoCobrar(monto.intValue());
                        documentoVO.setIndicadorSentido(table.getString("INDSENT"));
                        documentoVO.setFechaVencimiento(table.getDate("FECVCTO"));
                        documentoVO.setNombreResponsable(table.getString("CODEMIS"));
                        documentoVO.setOficinaResponsable(table.getString("SUCRESP"));
                        documentoVO.setNumeroFactura(table.getString("NUMFACT"));
                        documentoVO.setFolioSii(table.getString("FOLSII"));
                        documentoVO.setClavePago(table.getString("CONPAGO"));
                        documentoVO.setCodigoCobrador(table.getInt("CODCOBR"));
                        documentoVO.setGrupoMateriales(table.getString("CODCANAL"));
                        documentoVO.setOrdenCompra(table.getString("ORDCOMP"));
                        documentoVO.setCodigoCuenta(table.getString("CODCUEN"));
                        documentoVO.setNombreCliente(table.getString("NOMCLIE"));
                        documentoVO.setFacturaRelacionada(table.getString("FACTNCR"));
                        Documento d = TypesAdaptor.adaptar(documentoVO);
                        d.setLastUpdate(lastUpdate);
                        cliente = new Cliente();
                        dmCliente = new DmCliente();
                        cliente.setRutCliente(documentoVO.getRutCliente());
                        cliente.setNombreCliente(documentoVO.getNombreCliente());
                        cliente = clienteDAO.findOrCreate(cliente);
                        dmCliente.setCliente(cliente);
                        dmCliente.setDmCliente(documentoVO.getCodigoCliente());
                        dmCliente = dmClienteDAO.findOrCreate(dmCliente);
                        TipoDocumento tipoDocumento = new TipoDocumento();
                        tipoDocumento.setCodigoTipo(documentoVO.getClaseDocumento());
                        tipoDocumento.setIndicadorSentido(documentoVO.getIndicadorSentido());
                        tipoDocumento = tipoDocumentoDAO.findOrCreate(tipoDocumento);
                        d.setTipoDocumento(tipoDocumento);
                        Sociedad sociedad = new Sociedad();
                        sociedad.setCodigoSociedad(documentoVO.getCodigoSociedad());
                        sociedad = sociedadDAO.findOrCreate(sociedad);
                        Vendedor vendedor = new Vendedor();
                        vendedor.setCodigoVendedor(documentoVO.getNombreResponsable());
                        vendedor = vendedorDAO.findOrCreate(vendedor);
                        Sucursal sucursal = new Sucursal();
                        sucursal.setCodigoSucursal(documentoVO.getOficinaResponsable());
                        sucursal = sucursalDAO.findOrCreate(sucursal);
                        d.setSucursal(sucursal);
                        d.setVendedor(vendedor);
                        d.setDmCliente(dmCliente);
                        d.setSociedad(sociedad);
                        documentoDAO.findOrCreate(d);
                        documentosList.add(documentoVO);
                        if(i%50 == 0 || table.getNumRows() - i == 1) {
                            userTransaction.commit();
                            userTransaction.begin();;
                        }
                    }
                    if(userTransaction.getStatus() == Status.STATUS_ACTIVE) {
                        userTransaction.commit();
                    }
                }catch (Exception e) {
                    userTransaction.rollback();
                }
                inicio = inicio + 501;
                fin = fin + 500 ;

                function.getImportParameterList().setValue("IND1", inicio.toString()); //Paso de parametros
                function.getImportParameterList().setValue("IND2", fin.toString()); //Paso de parametros
                System.out.println(function + "no ejecutada");
                connect.execute(function);
                System.out.println(function + "ejecutada");
                table = function.getTableParameterList().getTable("TSALIDA"); //Tabla de Salida

            }while (table != null && table.getNumRows() > 0);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new Response();
    }

    public Response getDatosPantallaInicial(Request request) {
        Response response = new Response();
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setIdCliente(1l);
        clienteVO.setNombreCliente("Cliente Prueba");
        clienteVO.setRutCliente("1-9");
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setCorreoUsuario("correo@gmail.com");
        usuarioVO.setNombreUsuario("Usuario");
        usuarioVO.setRutUsuario("2-7");
        usuarioVO.setIdUsuario(1l);
        List<AgendaVO> agendaVOList = new ArrayList<AgendaVO>();
        List<CampanhaVO> campanhaVOList = new ArrayList<CampanhaVO>();
        try {
            List<Agenda> agendaList = agendaDAO.getAgendaUsuario();

            for(Agenda agenda : agendaList) {
                AgendaVO agendaVO = TypesAdaptor.adaptar(agenda);
                ClienteVO cliente = TypesAdaptor.adaptar(agenda.getCliente());
                agendaVO.setCliente(cliente);
                agendaVOList.add(agendaVO);
            }
            CampanhaVO campanhaVO = new CampanhaVO();
            campanhaVO.setFechaInicio(sdf.parse("02-03-2014"));
            campanhaVO.setFechaTermino(sdf.parse("06-06-2014"));
            campanhaVO.setNombre("Campanha 1");
            campanhaVO.setId(1l);
            campanhaVOList.add(campanhaVO);
            campanhaVO = new CampanhaVO();
            campanhaVO.setFechaInicio(sdf.parse("15-04-2014"));
            campanhaVO.setFechaTermino(sdf.parse("15-07-2014"));
            campanhaVO.setNombre("Campanha 2");
            campanhaVO.setId(1l);
            campanhaVOList.add(campanhaVO);
            campanhaVO = new CampanhaVO();
            campanhaVO.setFechaInicio(sdf.parse("07-05-2014"));
            campanhaVO.setFechaTermino(sdf.parse("07-06-2014"));
            campanhaVO.setNombre("Campanha 3");
            campanhaVO.setId(1l);
            campanhaVOList.add(campanhaVO);
        }catch (Exception e) {}

        ResumenInicialVO resumenInicialVO = getCarteraPorTramos();
        resumenInicialVO.setAgendaVOList(agendaVOList);
        resumenInicialVO.setCampanhaVOList(campanhaVOList);
        response.success();
        response.addResp(Parametros.PANTALLA_INICIAL,resumenInicialVO );
        return  response;
    }

    public Response getDatosAsignacion(Request request) {
        List<Usuario> usuarioList = usuarioDAO.findAll();
        List<Cliente> clienteList = clienteDAO.findAll();
        List<UsuarioVO> usuarioVOList = new ArrayList<UsuarioVO>();
        List<ClienteVO> clienteVOList = new ArrayList<ClienteVO>();
        for(Usuario usuario: usuarioList) {
            usuarioVOList.add(TypesAdaptor.adaptar(usuario));
        }

        for(Cliente cliente : clienteList) {
            ClienteVO clienteVO = TypesAdaptor.adaptar(cliente);
            Usuario usuario = usuarioDAO.getUsuarioByIdCliente(clienteVO.getIdCliente());
            if(usuario != null)
                clienteVO.setUsuarioAsignado(TypesAdaptor.adaptar(usuario));
            clienteVOList.add(clienteVO);
        }

        Response response = new Response();
        response.addResp(Parametros.USUARIOS, usuarioVOList);
        response.addResp(Parametros.CLIENTES, clienteVOList);

        return response;
    }

    private ResumenInicialVO getCarteraPorTramos() {
        List<Object[]> resultList = documentoDAO.getCarteraClientes();
        return getCarteraPorTramos(resultList);
    }

    public Response guardarDatosAsignacion(Request request) {
        List<Long> idClienteList = request.getParam(Parametros.CLIENTES, List.class);
        Long idUsuario = request.getParam(Parametros.USUARIO, Long.class);
        System.out.println(idUsuario);
        for(Long id: idClienteList) {
            System.out.println(id);
        }
        Usuario usuario = usuarioDAO.findById(idUsuario);
        List<Cliente> clienteList = clienteDAO.findAllByIds(idClienteList);
        for(Cliente cliente: clienteList) {
            asignacionClienteDAO.disableAllAsignacionCLienteByIdCliente(cliente.getSystemId());
            AsignacionClienteUsuario asignacionClienteUsuario = new AsignacionClienteUsuario();
            asignacionClienteUsuario.setCliente(cliente);
            asignacionClienteUsuario.setUsuario(usuario);
            asignacionClienteDAO.create(asignacionClienteUsuario);
        }
        Response response = new Response();
        response.success();
        return response;
    }


    public Response getDatosGestionCliente(Request request) {
        Response response = new Response();
        Long idCliente = request.getParam(Parametros.ID_CLIENTE, Long.class);
        Cliente cliente = clienteDAO.find(idCliente);
        request.addParam(BusinessParameter.RUT_CLIENTE, cliente.getRutCliente());
        request.addParam(BusinessParameter.SOCIEDAD, "1000");
        //response = obtenerDocumentosSAP(request);
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
            ResumenInicialVO resumenInicialVO = getCarteraPorTramos(resultadoCartera);
            if(resumenInicialVO != null && resumenInicialVO.getTramoVOList() != null && !resumenInicialVO.getTramoVOList().isEmpty()) {
                List<TramoVO> tramoVOList = resumenInicialVO.getTramoVOList();
                response.addResp(Parametros.TRAMOS, tramoVOList);
                response.addResp(Parametros.CARTERA_CLIENTE, resumenInicialVO.getCarteraVOList().get(0) );

            }
        }

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

        try {
            if(userTransaction.getStatus() ==  Status.STATUS_ACTIVE)
                userTransaction.commit();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }
        ClienteVO clienteVO = TypesAdaptor.adaptar(cliente);
        response.addResp(Parametros.CLIENTE, clienteVO);

        return response;

    }

    public ResumenInicialVO getCarteraPorTramos(List<Object[]> resultList) {
        List<TramoVO> tramoVOList = new ArrayList<TramoVO>();
        List<CarteraVO> carteraVOList = new ArrayList<CarteraVO>();
        for(Object[] result: resultList) {
            System.out.println("0 " + result[0] + " 1" + result [1] + " 2" + result[2] + " 3 " + result[3]
                    + " 4 " + result[4] + " 5 " + result[5]);
            ClienteVO clienteVO = new ClienteVO();
            clienteVO.setIdCliente(((BigDecimal) result[1]).longValue());
            CarteraVO carteraVO = new CarteraVO();
            carteraVO.setCliente(clienteVO);
            if(carteraVOList.contains(carteraVO)) {
                carteraVO = carteraVOList.get(carteraVOList.indexOf(carteraVO));
            }else {
                carteraVO.getCliente().setNombreCliente((String) result[0]);
                carteraVO.getCliente().setRutCliente((String) result[2]);
                carteraVO.getCliente().setIdDmCliente(((BigDecimal) result[6]).longValue());
                carteraVOList.add(carteraVO);
            }
            TramoVO tramoVO = new TramoVO();
            tramoVO.setTramo((String) result[3]);
            if(tramoVOList.contains(tramoVO)) {
                tramoVO = tramoVOList.get(tramoVOList.indexOf(tramoVO));
            }else {
                tramoVO.setDiaMenor((Integer) result[4]);
                tramoVOList.add(tramoVO);
            }
            try {
                if(!carteraVO.getTramosList().contains(tramoVO)) {
                    TramoVO clone = tramoVO.clone();
                    BigDecimal monto = (BigDecimal) result[5];
                    clone.setMonto(monto.toString());
                    carteraVO.getTramosList().add(clone);
                }else {
                    TramoVO tramo = carteraVO.getTramosList().get(carteraVO.getTramosList().indexOf(tramoVO));
                    BigDecimal montoTramo = new BigDecimal(tramo.getMonto());
                    BigDecimal monto = ((BigDecimal) result[5]).add(montoTramo);
                    tramo.setMonto(monto.toString());
                }
            }catch (Exception e) {}
        }


        Collections.sort(tramoVOList,TRAMO_VO_COMPARATOR);


        for(CarteraVO carteraVO : carteraVOList) {
            for(TramoVO tramoVO: tramoVOList) {
                if(!carteraVO.getTramosList().contains(tramoVO)) {
                    try {
                        TramoVO clone = tramoVO.clone();
                        clone.setMonto("0");
                        carteraVO.getTramosList().add(clone);
                    }catch (Exception e) {}
                }
            }
            Collections.sort(carteraVO.getTramosList(), TRAMO_VO_COMPARATOR);
            Long monto = 0l;
            for(TramoVO tramoVO: carteraVO.getTramosList()) {
                monto += Long.valueOf(tramoVO.getMonto());
            }
            carteraVO.setTotal(monto.toString());
        }
        ResumenInicialVO resumenInicialVO = new ResumenInicialVO();
        resumenInicialVO.setTramoVOList(tramoVOList);
        resumenInicialVO.setCarteraVOList(carteraVOList);

        return resumenInicialVO;

    }


    public Response getCargosSAP(Request request) {
        Response response = new Response();
        Connect connect = SapConnectionFactory.newConecction();
        JCoFunction function = connect.getFunction(BusinessParameter.RFC_CARGOS_SAP); // Nombre RFC
        connect.execute(function);
        JCoTable table = function.getTableParameterList().getTable("T_FUNCION"); //Tabla de Salida
        List<CargoContactoVO> cargoContactoVOList = new ArrayList<CargoContactoVO>(table.getNumRows());
        System.out.println(table);
        try {
            userTransaction.begin();
            for (int i = 0; i < table.getNumRows(); i++) {
                table.setRow(i);
                CargoContacto cargoContacto = new CargoContacto();
                cargoContacto.setCargoContacto(table.getString("VTEXT"));
                cargoContacto.setPafkt(table.getString("PAFKT"));
                cargoContacto.setSpras(table.getString("SPRAS"));
                cargoContacto.setMandato(table.getString("MANDT"));
                cargoContacto = cargoContactoDAO.findOrCreate(cargoContacto);
                CargoContactoVO cargoContactoVO = TypesAdaptor.adaptar(cargoContacto);
                cargoContactoVOList.add(cargoContactoVO);
            }
            userTransaction.commit();
            response.addResp(Parametros.CARGOS_CONTACTO, cargoContactoVOList);
            response.success();
        }catch (Exception e){
            e.printStackTrace();
            response.fail();
        }
        return response;
    }


}
