package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.AsignacionClienteUsuario;


public interface AsignacionClienteDAO extends GenericDAO<AsignacionClienteUsuario, Long> {


    void disableAllAsignacionCLienteByIdCliente(Long idCliente);
}
