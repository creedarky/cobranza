package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.DmCliente;


public interface DMClienteDAO extends GenericDAO<DmCliente, Long> {


    DmCliente findOrCreate(DmCliente dmCliente);
}
