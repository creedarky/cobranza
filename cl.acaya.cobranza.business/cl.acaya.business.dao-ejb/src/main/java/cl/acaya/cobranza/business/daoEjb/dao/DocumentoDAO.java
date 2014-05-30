package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Documento;

import java.util.List;


public interface DocumentoDAO extends GenericDAO<Documento, Long> {


    List<Object[]> getCarteraClientes();
}
