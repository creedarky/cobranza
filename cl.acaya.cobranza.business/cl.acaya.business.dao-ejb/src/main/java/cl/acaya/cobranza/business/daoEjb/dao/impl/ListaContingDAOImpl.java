package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.ListaContingenciaDAO;
import cl.acaya.cobranza.business.daoEjb.entities.ListaConting;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(ListaContingenciaDAO.class)
@Stateless
public class ListaContingDAOImpl extends  GenericDAOImpl<ListaConting,Long> implements ListaContingenciaDAO {

    public ListaContingDAOImpl() {
        super(ListaConting.class);
    }
}
