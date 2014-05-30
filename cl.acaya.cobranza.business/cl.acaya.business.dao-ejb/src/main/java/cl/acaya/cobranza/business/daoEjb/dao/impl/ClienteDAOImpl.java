package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(ClienteDAO.class)
@Stateless
public class ClienteDAOImpl extends  GenericDAOImpl<Cliente,Long> implements ClienteDAO {


    public List<Cliente> findAll() {
        List<Cliente> clienteList = em.createNamedQuery("Cliente.findAll").getResultList();
        return clienteList;
    }

    public List<Cliente> findAllByIds(List<Long> idClienteList) {
        List<Cliente> clienteList = em.createQuery("from Cliente  where systemId in (:idClienteList)")
                .setParameter("idClienteList", idClienteList).getResultList();
        return clienteList;
    }

}
