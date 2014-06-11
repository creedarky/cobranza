package cl.acaya.api.service;

import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;

/**
 * Created by mcastro on 21-05-14.
 */
public interface ClienteServiceRemote {

    Response getDatosGestionCliente(Request request);
}
