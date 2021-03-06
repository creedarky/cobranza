package cl.acaya.api.service;

import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;

/**
 * Created by mcastro on 21-05-14.
 */
public interface CobranzaServiceRemote {

    Response obtenerDocumentosSAP(Request request);

    Response getDatosPantallaInicial(Request request);

    Response getDatosAsignacion(Request request);

    Response guardarDatosAsignacion(Request request);

    Response getDatosGestionCliente(Request request);

    Response ejecutarCargaMasiva();
}
