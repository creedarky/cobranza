package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.ContingenciaDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Contingencia;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(ContingenciaDAO.class)
@Stateless
public class ContingenciaDAOimpl extends GenericDAOImpl<Contingencia,Integer> implements ContingenciaDAO {

    public ContingenciaDAOimpl() {
        super(Contingencia.class);
    }


    public List<Contingencia> findAll() {
        List<Contingencia> contingenciaList = em.createNamedQuery("Contingencia.findAll").getResultList();
        return contingenciaList;
    }

}
