package cl.acaya.api.service;

import cl.acaya.api.vo.*;

import java.util.List;

/**
 * Created by mcastro on 21-05-14.
 */
public interface ClienteServiceRemote {

    Response getDatosGestionCliente(Request request);

    ContactoVO guardarContacto(ContactoVO contactoVO);

    Response getContactosClientes(Request request);

    Response guardarAgenda(GuardarAgendaVO guardarAgendaVO);

     Response getBancosYFormasdePago();

    Response guardarGestion(GestionVO gestionVO);

    Response getHitosCliente(Request request);
}
