package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.DmClienteDAO;
import cl.acaya.cobranza.business.daoEjb.entities.DmCliente;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(DmClienteDAO.class)
@Stateless
public class DmClienteDAOImpl extends  GenericDAOImpl<DmCliente,Long> implements DmClienteDAO {

    public DmCliente findOrCreate(DmCliente dmCliente) {
        List<DmCliente> dmClienteList = em.createNamedQuery("DmCliente.findByDmCliente")
                .setParameter("dmCliente", dmCliente.getDmCliente())
                .setMaxResults(1)
                .getResultList();

        if(dmClienteList == null || dmClienteList.isEmpty())
            dmCliente = create(dmCliente);
        else
            dmCliente = dmClienteList.get(0);
        return dmCliente;
    }
}
