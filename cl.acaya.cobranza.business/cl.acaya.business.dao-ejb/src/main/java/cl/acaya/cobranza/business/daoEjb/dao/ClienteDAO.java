package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Cliente;

import java.util.List;


public interface ClienteDAO extends GenericDAO<Cliente, Long> {


    List<Cliente> findAll();

    List<Cliente> findAllByIds(List<Long> idClienteList);

    Cliente findOrCreate(Cliente cliente);
}
