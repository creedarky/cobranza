package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.BancoDAO;
import cl.acaya.cobranza.business.daoEjb.dao.FormaPagoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Banco;
import cl.acaya.cobranza.business.daoEjb.entities.FormaPago;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(FormaPagoDAO.class)
@Stateless
public class FormaPagoDAOImpl extends  GenericDAOImpl<FormaPago,Integer> implements FormaPagoDAO {



    public FormaPagoDAOImpl() {
        super(FormaPago.class);
    }

    public List<FormaPago> findAll() {
        return em.createQuery("from FormaPago").getResultList();
    }



}
