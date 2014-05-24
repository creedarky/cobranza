package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(ClienteDAO.class)
@Stateless
public class ClienteDAOImpl extends  GenericDAOImpl<Cliente,Long> implements ClienteDAO {

}
