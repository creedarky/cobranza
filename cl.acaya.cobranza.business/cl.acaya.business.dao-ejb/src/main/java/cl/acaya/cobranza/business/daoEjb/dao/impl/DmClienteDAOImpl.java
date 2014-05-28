package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.DmClienteDAO;
import cl.acaya.cobranza.business.daoEjb.entities.DmCliente;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(DmClienteDAO.class)
@Stateless
public class DmClienteDAOImpl extends  GenericDAOImpl<DmCliente,Long> implements DmClienteDAO {

}
