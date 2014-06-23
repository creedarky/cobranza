package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.IntegracionAceptaDAO;
import cl.acaya.cobranza.business.daoEjb.entities.IntegracionAcepta;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Maximiliano on 23/06/2014.
 */
@Local(IntegracionAceptaDAO.class)
@Stateless
public class IntegracionAceptaDAOImpl extends GenericDAOImpl<IntegracionAcepta, Long> implements IntegracionAceptaDAO {

    public IntegracionAceptaDAOImpl() {
        super(IntegracionAcepta.class);
    }

    public boolean crearIntegracionAcepta(String numeroFactura,String duennoEvento,String estadoEvento,Date fechaHora,
                                          String observacion,String urlFactura) {

        try {
            IntegracionAcepta integracionAcepta = new IntegracionAcepta();
            integracionAcepta.setDuennoEvento(duennoEvento);
            integracionAcepta.setEstadoEvento(estadoEvento);
            integracionAcepta.setFechaHora(fechaHora);
            integracionAcepta.setObservacion(observacion);
            integracionAcepta.setNumeroFactura(numeroFactura);
            integracionAcepta.setUrlFactura(urlFactura);
            integracionAcepta.setFechaSys(new Date());
            this.create(integracionAcepta);
        }catch (Exception e) {
            return false;
        }
        return true;
    }



}
