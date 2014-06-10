package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.ContactoCliente;

import java.util.List;

public interface ContactoDAO extends GenericDAO<ContactoCliente, Long> {

        ContactoCliente findOrCreate(ContactoCliente contactoCliente);

}
