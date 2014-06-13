package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Agenda;
import cl.acaya.cobranza.business.daoEjb.entities.ContactoCliente;

import java.util.List;

public interface AgendaDAO extends GenericDAO<Agenda, Long> {


    List<Agenda> findAll();

}
