package cl.acaya.business.service.ejb.impl;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.sap.Connect;
import cl.acaya.api.sap.SapSystem;
import cl.acaya.api.vo.DocumentoVO;
import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;
import cl.acaya.api.service.CobranzaServiceRemote;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcastro on 21-05-14.
 */
@Stateless(name = "CobranzaServiceRemote", mappedName = "ejb/CobranzaServiceRemote")
@Remote(CobranzaServiceRemote.class)
public class CobranzaServiceRemoteImpl implements CobranzaServiceRemote {


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
            System.out.println(table);
            List<DocumentoVO> documentosList = new ArrayList<DocumentoVO>(table.getNumRows());
            for (int i = 0; i < table.getNumRows(); i++) {
                table.setRow(i);
                DocumentoVO documento = new DocumentoVO();
                documento.setCodigoSociedad(table.getString("CODS"));
                documento.setCodigoCliente(table.getString("CODDEST"));
                documento.setCodigoOperacion(table.getString("C"));
                documento.setIndicacionOperacion(table.getString("I"));
                documento.setFechaCompensacion(table.getDate("FECCOMP"));
                documento.setNumeroDocumento(table.getString("DOCCOMP"));
                documento.setNumeroAsignacion(table.getString("NUMASIG"));
                documento.setNumeroEjercicio(table.getInt("NUMA"));
                documento.setNumeroContable(table.getString("DOCCONT"));
                documento.setNumeroApunte(table.getInt("NUM"));
                documento.setRutCliente(table.getString("RUTCLIE"));
                documento.setFechaCotizacion(table.getDate("FECCONT"));
                documento.setFechaDocumento(table.getDate("FECDOCU"));
                documento.setClaseDocumento(table.getString("CL"));
                documento.setMontoCobrar(table.getDouble("MTOCOBR"));
                documento.setIndicadorSentencia(table.getString("I"));
                documento.setFechaVencimiento(table.getDate("FECVCTO"));
                documento.setNombreResponsable(table.getString("CODEMIS"));
                documento.setOficinaResponsable(table.getString("SUCR"));
                documento.setNumeroFactura(table.getString("NUMFACT"));
                documento.setFolioSii(table.getString("FOLSII"));
                documento.setClavePago(table.getString("CONP"));
                documento.setCodigoCobrador(table.getInt("CODCOBR"));
                documento.setGrupoMateriales(table.getString("COD"));
                documento.setOrdenCompra(table.getString("ORDCOMP"));
                documento.setCodigoCuenta(table.getString("CODCUEN"));
                documentosList.add(documento);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new Response();
    }


}
