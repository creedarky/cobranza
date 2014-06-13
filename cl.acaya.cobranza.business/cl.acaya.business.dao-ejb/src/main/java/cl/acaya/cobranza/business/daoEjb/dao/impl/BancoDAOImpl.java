package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.BancoDAO;
import cl.acaya.cobranza.business.daoEjb.dao.CargoUsuarioDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Banco;
import cl.acaya.cobranza.business.daoEjb.entities.CargoUsuario;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(BancoDAO.class)
@Stateless
public class BancoDAOImpl extends  GenericDAOImpl<Banco,Integer> implements BancoDAO {

    public BancoDAOImpl() {
        super(Banco.class);
    }

    public List<Banco> findAll() {
        return em.createNamedQuery("Banco.findAll").getResultList();
    }



}
