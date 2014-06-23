package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Sucursal;


public interface SucursalDAO extends GenericDAO<Sucursal, Long> {


    Sucursal findOrCreate(Sucursal sucursal);
}
