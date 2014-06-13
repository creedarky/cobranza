package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.dao.ContactoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;
import cl.acaya.cobranza.business.daoEjb.entities.ContactoCliente;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by darkmoorx on 09-06-14.
 */
@Local(ContactoDAO.class)
@Stateless
public class ContactoDAOimpl extends  GenericDAOImpl<ContactoCliente,Long> implements ContactoDAO {

    public ContactoDAOimpl(Class<ContactoCliente> type) {
        super(ContactoCliente.class);
    }

    public ContactoDAOimpl() {
        super(ContactoCliente.class);
    }

    public ContactoCliente findOrCreate(ContactoCliente contactoCliente) {
        return create(contactoCliente);
    }

    public List<ContactoCliente> getContactosByIdCliente(Long idCliente) {
        return em.createQuery("from ContactoCliente cc inner join fetch cc.cargo where cc.cliente.systemId = :idCliente")
                .setParameter("idCliente", idCliente)
                .getResultList();
    }

}


