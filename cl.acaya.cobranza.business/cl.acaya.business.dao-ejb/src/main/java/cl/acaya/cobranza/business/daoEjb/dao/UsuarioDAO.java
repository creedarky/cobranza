package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Usuario;

import java.util.List;


public interface UsuarioDAO extends GenericDAO<Usuario, Long> {

    Usuario getUsuarioByIdCliente(Long idCliente);

    List<Usuario> findAll();

    Usuario findById(Long id);
}
