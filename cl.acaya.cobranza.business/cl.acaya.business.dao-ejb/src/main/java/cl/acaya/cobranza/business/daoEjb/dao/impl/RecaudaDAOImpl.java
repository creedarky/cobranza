package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.CargoUsuarioDAO;
import cl.acaya.cobranza.business.daoEjb.dao.RecaudaDAO;
import cl.acaya.cobranza.business.daoEjb.entities.CargoUsuario;
import cl.acaya.cobranza.business.daoEjb.entities.Recauda;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(RecaudaDAO.class)
@Stateless
public class RecaudaDAOImpl extends  GenericDAOImpl<Recauda,Long> implements RecaudaDAO {

    public RecaudaDAOImpl() {
        super(Recauda.class);
    }
}
