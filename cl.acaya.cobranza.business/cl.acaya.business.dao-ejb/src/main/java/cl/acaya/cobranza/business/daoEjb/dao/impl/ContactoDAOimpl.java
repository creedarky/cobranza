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


    public ContactoDAOimpl() {
        super(ContactoCliente.class);
    }

    public ContactoCliente findOrCreate(ContactoCliente contactoCliente) {
        return create(contactoCliente);
    }

}


