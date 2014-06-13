package cl.acaya.web.clients;

import cl.acaya.api.service.ClienteServiceRemote;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.ContactoVO;
import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;

import java.util.List;

/**
 * Created by mcastro on 22-05-14.
 */
public class ClienteServiceDelegate extends AbstractServiceDelegate implements ClienteServiceRemote {

    ClienteServiceRemote clienteServiceRemote;

    @Override
    public void setJndiName(String jndiName) {
        clienteServiceRemote = getService(jndiName, ClienteServiceRemote.class);
    }


    @Override
    public Response getDatosGestionCliente(Request request) {
        return clienteServiceRemote.getDatosGestionCliente(request);
    }


    @Override
    public ContactoVO guardarContacto(ContactoVO contactoVO) {
        return clienteServiceRemote.guardarContacto(contactoVO);
    }

    @Override
    public List<ContactoVO> getContactosClientes(Long idCliente) {
        return clienteServiceRemote.getContactosClientes(idCliente);
    }
}


