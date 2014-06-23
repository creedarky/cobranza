package cl.acaya.cobranza.business.daoEjb.dao;


import cl.acaya.cobranza.business.daoEjb.entities.IntegracionAcepta;

import java.util.Date;

public interface IntegracionAceptaDAO extends GenericDAO<IntegracionAcepta, Long> {


    boolean crearIntegracionAcepta(String numeroFactura,String duennoEvento,String estadoEvento,Date fechaHora,
                                          String observacion,String urlFactura);
}
