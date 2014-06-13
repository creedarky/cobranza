package cl.acaya.api.service;

import cl.acaya.api.vo.ContactoVO;
import cl.acaya.api.vo.GuardarAgendaVO;
import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;

import java.util.List;

/**
 * Created by mcastro on 21-05-14.
 */
public interface ClienteServiceRemote {

    Response getDatosGestionCliente(Request request);

    ContactoVO guardarContacto(ContactoVO contactoVO);

    List<ContactoVO> getContactosClientes(Long idCliente);

    Response guardarAgenda(GuardarAgendaVO guardarAgendaVO);
}
