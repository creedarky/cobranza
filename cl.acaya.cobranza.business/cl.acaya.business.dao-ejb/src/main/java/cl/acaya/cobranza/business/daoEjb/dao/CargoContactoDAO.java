package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.CargoContacto;

public interface CargoContactoDAO extends GenericDAO<CargoContacto, Long> {

    CargoContacto findOrCreate(CargoContacto cargoContacto);
}
