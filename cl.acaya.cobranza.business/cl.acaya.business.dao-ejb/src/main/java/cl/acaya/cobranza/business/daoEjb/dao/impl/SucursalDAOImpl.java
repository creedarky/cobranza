package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.SucursalDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Sucursal;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Maximiliano on 23/06/2014.
 */

@Local(SucursalDAO.class)
@Stateless
public class SucursalDAOImpl extends GenericDAOImpl<Sucursal, Long> implements SucursalDAO {
    public SucursalDAOImpl() {
        super(Sucursal.class);
    }

    @Override
    public Sucursal findOrCreate(Sucursal sucursal) {
        List<Sucursal> sucursalList = em.createNamedQuery("Sucursal.findbyCodigo")
                .setParameter("codigoSucursal", sucursal.getCodigoSucursal())
                .setMaxResults(1)
                .getResultList();
        if(sucursalList == null || sucursalList.isEmpty())
            sucursal = create(sucursal);
        else
            sucursal = sucursalList.get(0);
        return sucursal;
    }
}
