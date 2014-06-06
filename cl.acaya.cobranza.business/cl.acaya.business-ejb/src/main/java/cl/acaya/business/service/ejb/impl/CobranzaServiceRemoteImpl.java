package cl.acaya.business.service.ejb.impl;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.sap.Connect;
import cl.acaya.api.sap.SapSystem;
import cl.acaya.api.vo.*;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.cobranza.business.daoEjb.dao.*;
import cl.acaya.cobranza.business.daoEjb.entities.*;
import cl.acaya.cobranza.business.daoEjb.util.TypesAdaptor;
import cl.acaya.cobranza.business.daoEjb.util.comparator.TramoVOComparator;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

import javax.ejb.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mcastro on 21-05-14.
 */
@Stateless(name = "CobranzaServiceRemote", mappedName = "ejb/CobranzaServiceRemote")
@Remote(CobranzaServiceRemote.class)
public class CobranzaServiceRemoteImpl implements CobranzaServiceRemote {

    @EJB
    DocumentoDAO documentoDAO;

    @EJB
    ClienteDAO clienteDAO;

    @EJB
    DmClienteDAO dmClienteDAO;

    @EJB
    UsuarioDAO usuarioDAO;

    @EJB
    AsignacionClienteDAO asignacionClienteDAO;

    private final static DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private final static TramoVOComparator TRAMO_VO_COMPARATOR = new TramoVOComparator();

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response obtenerDocumentosSAP(Request request) {
        try {
            pruebasap(request);

            SapSystem system = new SapSystem("PRD", "10.1.24.52", "300", "1", "intranet", "informat"); //Conexion a sap
            Connect connect = new Connect(system);
            JCoFunction function = connect.getFunction("ZFIFN_SCKCOB_PARTIDAS"); //Nombre RFC

            JCoParameterList pl = function.getImportParameterList();

            String rutCliente = request.getParam(BusinessParameter.RUT_CLIENTE, String.class);
            Long sociedad = Long.valueOf(request.getParam(BusinessParameter.SOCIEDAD, String.class));

            function.getImportParameterList().setValue("SOCIEDAD", sociedad); //Paso de parametros
            function.getImportParameterList().setValue("RUTCLIE", rutCliente); //Paso de parametros
            System.out.println(function + "no ejecutada");
            connect.execute(function);
            System.out.println(function + "ejecutada");
            JCoTable table = function.getTableParameterList().getTable("TSALIDA"); //Tabla de Salida
            System.out.println("filas " + table.getNumRows());
            System.out.println(table);
            Cliente cliente = null;
            DmCliente dmCliente = null;
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
                documentoVO.setIndicadorSentencia(table.getString("INDSENT"));
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
                Documento d = TypesAdaptor.adaptar(documentoVO);
                if(cliente == null) {
                    cliente = new Cliente();
                    dmCliente = new DmCliente();
                    cliente.setRutCliente(documentoVO.getRutCliente());
                    cliente.setNombreCliente(documentoVO.getNombreCliente());
                    cliente = clienteDAO.findOrCreate(cliente);
                    dmCliente.setCliente(cliente);
                    dmCliente.setDmCliente(documentoVO.getCodigoCliente());
                    dmCliente = dmClienteDAO.findOrCreate(dmCliente);

                }
                d.setDmCliente(dmCliente);
                documentoDAO.findOrCreate(d);
                documentosList.add(documentoVO);
            }

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
            AgendaVO agendaVO = new AgendaVO();
            agendaVO.setUsuarioVO(usuarioVO);
            agendaVO.setCliente(clienteVO);
            agendaVO.setIdAgenda(1l);
            agendaVO.setFechaAgendada(sdf.parse("10-05-2014"));
            agendaVO.setTipoAgenda("TIPO");
            agendaVOList.add(agendaVO);
            agendaVO = new AgendaVO();
            agendaVO.setUsuarioVO(usuarioVO);
            agendaVO.setCliente(clienteVO);
            agendaVO.setIdAgenda(1l);
            agendaVO.setFechaAgendada(sdf.parse("13-05-2014"));
            agendaVO.setTipoAgenda("TIPO");
            agendaVOList.add(agendaVO);
            agendaVO = new AgendaVO();
            agendaVO.setUsuarioVO(usuarioVO);
            agendaVO.setCliente(clienteVO);
            agendaVO.setIdAgenda(1l);
            agendaVO.setFechaAgendada(sdf.parse("13-04-2014"));
            agendaVO.setTipoAgenda("TIPO");
            agendaVOList.add(agendaVO);
            agendaVO = new AgendaVO();
            agendaVO.setUsuarioVO(usuarioVO);
            agendaVO.setCliente(clienteVO);
            agendaVO.setIdAgenda(1l);
            agendaVO.setFechaAgendada(sdf.parse("02-03-2014"));
            agendaVO.setTipoAgenda("TIPO");
            agendaVOList.add(agendaVO);
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


    private ResumenInicialVO getCarteraPorTramos() {
        List<Object[]> resultList = documentoDAO.getCarteraClientes();
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
                TramoVO clone = tramoVO.clone();
                BigDecimal monto = (BigDecimal) result[5];
                clone.setMonto(monto.toString());
                carteraVO.getTramosList().add(clone);
            }catch (Exception e) {}
        }
        Collections.sort(tramoVOList,TRAMO_VO_COMPARATOR);
        for(CarteraVO carteraVO : carteraVOList) {
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

    private Response pruebasap(Request request) {
        try {
            SapSystem system = new SapSystem("PRD", "10.1.24.52", "300", "1", "intranet", "informat"); //Conexion a sap
            Connect connect = new Connect(system);
            JCoFunction function = connect.getFunction("ZFIFN_SCKCOB_PARTIDAS_T"); //Nombre RFC

            JCoParameterList pl = function.getImportParameterList();

            String rutCliente = request.getParam(BusinessParameter.RUT_CLIENTE, String.class);
            Long sociedad = Long.valueOf(request.getParam(BusinessParameter.SOCIEDAD, String.class));

            function.getImportParameterList().setValue("IND1", "0"); //Paso de parametros
            function.getImportParameterList().setValue("IND2", "5000"); //Paso de parametros
            System.out.println(function + "no ejecutada");
            connect.execute(function);
            System.out.println(function + "ejecutada");
            JCoTable table = function.getTableParameterList().getTable("TSALIDA"); //Tabla de Salida
            System.out.println("filas " + table.getNumRows());
            System.out.println(table);
            table = function.getTableParameterList().getTable("TSALIDA1"); //Tabla de Salida
            System.out.println("filas " + table.getNumRows());
            System.out.println(table);
            Cliente cliente = null;
            DmCliente dmCliente = null;
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
                documentoVO.setIndicadorSentencia(table.getString("INDSENT"));
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
                Documento d = TypesAdaptor.adaptar(documentoVO);
                if(cliente == null) {
                    cliente = new Cliente();
                    dmCliente = new DmCliente();
                    cliente.setRutCliente(documentoVO.getRutCliente());
                    cliente.setNombreCliente(documentoVO.getNombreCliente());
                    cliente = clienteDAO.findOrCreate(cliente);
                    dmCliente.setCliente(cliente);
                    dmCliente.setDmCliente(documentoVO.getCodigoCliente());
                    dmCliente = dmClienteDAO.findOrCreate(dmCliente);

                }
                d.setDmCliente(dmCliente);
                documentoDAO.findOrCreate(d);
                documentosList.add(documentoVO);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new Response();
    }

    public Response getDocumentosByCliente(Request request) {
        Response response = new Response();
        Long idDMCliente = request.getParam("dmCliente", Long.class);
        Long idCliente = request.getParam(Parametros.ID_CLIENTE, Long.class);

        return response;



    }
}
