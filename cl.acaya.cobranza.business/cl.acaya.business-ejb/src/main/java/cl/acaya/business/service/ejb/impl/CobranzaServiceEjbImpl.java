package cl.acaya.business.service.ejb.impl;

import cl.acaya.api.sap.Connect;
import cl.acaya.api.sap.SapSystem;
import cl.acaya.api.vo.DocumentoVO;
import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;
import cl.acaya.business.service.ejb.CobranzaServiceEjb;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcastro on 21-05-14.
 */
@Remote
public class CobranzaServiceEjbImpl implements CobranzaServiceEjb {


    public Response obtenerDocumentosSAP(Request request) {
        try {
            SapSystem system = new SapSystem("PRD", "10.1.24.52", "300", "1", "intranet", "informat"); //Conexion a sap
            Connect connect = new Connect(system);
            JCoFunction function = connect.getFunction("ZFIFN_SCKCOB_PARTIDAS"); //Nombre RFC

            JCoParameterList pl = function.getImportParameterList();

            //System.out.println(function);

            function.getImportParameterList().setValue("SOCIEDAD", "1000"); //Paso de parametros
            function.getImportParameterList().setValue("RUTCLIE", "61704000K"); //Paso de parametros

            connect.execute(function);
            JCoTable table = function.getTableParameterList().getTable("TSALIDA"); //Tabla de Salida
            JCoTable table2 = function.getTableParameterList().getTable("TSALIDA1"); //Tabla de Salida
            System.out.println(table);
            System.out.println(table2);
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
