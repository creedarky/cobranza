package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.AsignacionClienteDAO;
import cl.acaya.cobranza.business.daoEjb.entities.AsignacionClienteUsuario;
import cl.acaya.cobranza.business.daoEjb.entities.Usuario;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(AsignacionClienteDAO.class)
@Stateless
public class AsignacionClienteDaoImpl extends  GenericDAOImpl<AsignacionClienteUsuario,Long> implements AsignacionClienteDAO {


    public void disableAllAsignacionCLienteByIdCliente(Long idCliente) {
        em.createQuery("update AsignacionClienteUsuario set estadoDisabled = 1 " +
                "where cliente.systemId = :idCliente")
                .setParameter("idCliente", idCliente)
                .executeUpdate();
    }

}
