package cl.acaya.business.service.ejb.impl;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.sap.Connect;
import cl.acaya.api.sap.SapSystem;
import cl.acaya.api.vo.*;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.cobranza.business.daoEjb.dao.*;
import cl.acaya.cobranza.business.daoEjb.entities.*;
import cl.acaya.cobranza.business.daoEjb.util.TypesAdaptor;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

import javax.ejb.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Response obtenerDocumentosSAP(Request request) {
        try {
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
            List<DocumentoVO> documentosList = new ArrayList<DocumentoVO>(table.getNumRows());
            for (int i = 0; i < table.getNumRows(); i++) {
                table.setRow(i);
                DocumentoVO documentoVO = new DocumentoVO();
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
                    cliente = clienteDAO.create(cliente);
                    dmCliente.setCliente(cliente);
                    dmCliente.setDmCliente(documentoVO.getCodigoCliente());
                    dmCliente = dmClienteDAO.create(dmCliente);

                }
                d.setDmCliente(dmCliente);
                documentoDAO.create(d);
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
        List<TramoVO> tramoVOList = new ArrayList<TramoVO>();
        List<CarteraVO> carteraVOList = new ArrayList<CarteraVO>();
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

        TramoVO tramoVO = new TramoVO();
        tramoVO.setDiaInicial(1);
        tramoVO.setDiaFinal(30);
        tramoVO.setTramo("Tramo 1");
        tramoVOList.add(tramoVO);
        tramoVO = new TramoVO();
        tramoVO.setDiaInicial(31);
        tramoVO.setDiaFinal(60);
        tramoVO.setTramo("Tramo 2");
        tramoVOList.add(tramoVO);
        tramoVO = new TramoVO();
        tramoVO.setDiaInicial(61);
        tramoVO.setDiaFinal(90);
        tramoVO.setTramo("Tramo 3");
        tramoVOList.add(tramoVO);
        tramoVO = new TramoVO();
        tramoVO.setDiaInicial(91);
        tramoVO.setTramo("Tramo 4");
        tramoVOList.add(tramoVO);
        CarteraVO carteraVO = new CarteraVO();
        carteraVO.setCliente(clienteVO);
        carteraVO.setId(1l);
        carteraVO.setAlDia("1323300");
        String[] tramos = {"1000000", "1250000", "750000","676700"};
        carteraVO.setTramosList(Arrays.asList(tramos));
        carteraVO.setTotal("5000000");
        carteraVOList.add(carteraVO);
        ResumenInicialVO resumenInicialVO = new ResumenInicialVO();
        resumenInicialVO.setAgendaVOList(agendaVOList);
        resumenInicialVO.setCampanhaVOList(campanhaVOList);
        resumenInicialVO.setCarteraVOList(carteraVOList);
        resumenInicialVO.setTramoVOList(tramoVOList);
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

        Usuario usuario = usuarioDAO.find(idUsuario);
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

}
