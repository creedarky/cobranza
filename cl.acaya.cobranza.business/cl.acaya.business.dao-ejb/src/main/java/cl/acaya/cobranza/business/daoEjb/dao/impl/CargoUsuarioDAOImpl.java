package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.AsignacionClienteDAO;
import cl.acaya.cobranza.business.daoEjb.dao.CargoUsuarioDAO;
import cl.acaya.cobranza.business.daoEjb.entities.AsignacionClienteUsuario;
import cl.acaya.cobranza.business.daoEjb.entities.CargoUsuario;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(CargoUsuarioDAO.class)
@Stateless
public class CargoUsuarioDAOImpl extends  GenericDAOImpl<CargoUsuario,Long> implements CargoUsuarioDAO {




}
