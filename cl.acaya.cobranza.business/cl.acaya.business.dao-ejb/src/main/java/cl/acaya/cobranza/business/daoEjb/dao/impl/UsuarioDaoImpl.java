package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.SociedadDAO;
import cl.acaya.cobranza.business.daoEjb.dao.UsuarioDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;
import cl.acaya.cobranza.business.daoEjb.entities.Sociedad;
import cl.acaya.cobranza.business.daoEjb.entities.Usuario;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(UsuarioDAO.class)
@Stateless
public class UsuarioDaoImpl extends  GenericDAOImpl<Usuario,Long> implements UsuarioDAO {

    public List<Usuario> findAll() {
        List<Usuario> usuarioList = em.createNamedQuery("Usuario.findAll").getResultList();
        return usuarioList;
    }


    public Usuario getUsuarioByIdCliente(Long idCliente) {
        List<Usuario> usuarioList = em.createQuery("select a.usuario from AsignacionClienteUsuario a where a.cliente.systemId = :idCliente and a.estadoDisabled = 0")
                .setParameter("idCliente", idCliente).setMaxResults(1).getResultList();
        if(usuarioList != null && !usuarioList.isEmpty()) {
            return usuarioList.get(0);
        }
        return null;
    }
}
