package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Contingencia;

import java.util.List;


public interface ContingenciaDAO extends GenericDAO<Contingencia, Long> {

    List<Contingencia> findAll();
}
