package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.CargoContactoDAO;
import cl.acaya.cobranza.business.daoEjb.dao.CargoUsuarioDAO;
import cl.acaya.cobranza.business.daoEjb.entities.CargoContacto;
import cl.acaya.cobranza.business.daoEjb.entities.CargoUsuario;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(CargoContactoDAO.class)
@Stateless
public class CargoContactoDAOImpl extends  GenericDAOImpl<CargoContacto,Long> implements CargoContactoDAO {

    public CargoContactoDAOImpl() {
        super(CargoContacto.class);
    }

    public CargoContacto findOrCreate(CargoContacto cargoContacto) {
        List<CargoContacto> cargoContactoList = em.createNamedQuery("CargoContacto.findByIdSAP")
                .setParameter("idSAP", cargoContacto.getPafkt())
                .setMaxResults(1)
                .getResultList();
        if(cargoContactoList == null || cargoContactoList.isEmpty())
            cargoContacto = create(cargoContacto);
        else
            cargoContacto = cargoContactoList.get(0);
        return cargoContacto;
    }


}
