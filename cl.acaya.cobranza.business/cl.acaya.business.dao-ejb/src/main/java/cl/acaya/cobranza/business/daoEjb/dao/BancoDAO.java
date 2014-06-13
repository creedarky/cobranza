package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Banco;

import java.util.List;

public interface BancoDAO extends GenericDAO<Banco, Integer> {

    List<Banco> findAll();
}
