package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Banco;
import cl.acaya.cobranza.business.daoEjb.entities.FormaPago;

import java.util.List;

public interface FormaPagoDAO extends GenericDAO<FormaPago, Integer> {

    List<FormaPago> findAll();
}
