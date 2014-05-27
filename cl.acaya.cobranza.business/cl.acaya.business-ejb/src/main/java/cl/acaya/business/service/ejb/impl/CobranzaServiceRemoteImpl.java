package cl.acaya.business.service.ejb.impl;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.sap.Connect;
import cl.acaya.api.sap.SapSystem;
import cl.acaya.api.vo.DocumentoVO;
import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.dao.DocumentoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.util.TypesAdaptor;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

import javax.ejb.*;
import java.util.ArrayList;
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
                Documento d = TypesAdaptor.adaptar(documentoVO);
                documentoDAO.create(d);
                documentosList.add(documentoVO);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new Response();
    }


}
