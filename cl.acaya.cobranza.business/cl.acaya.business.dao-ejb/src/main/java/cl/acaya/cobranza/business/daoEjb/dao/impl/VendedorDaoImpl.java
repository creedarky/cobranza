package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.UsuarioDAO;
import cl.acaya.cobranza.business.daoEjb.dao.VendedorDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Usuario;
import cl.acaya.cobranza.business.daoEjb.entities.Vendedor;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(VendedorDAO.class)
@Stateless
public class VendedorDaoImpl extends  GenericDAOImpl<Vendedor,Long> implements VendedorDAO {

    public Vendedor findOrCreate(Vendedor vendedor) {
        List<Vendedor> vendedorList = em.createNamedQuery("Vendedor.findByCodigo")
                .setParameter("codigoVendedor", vendedor.getCodigoVendedor())
                .setMaxResults(1)
                .getResultList();
        if(vendedorList == null || vendedorList.isEmpty())
            vendedor = create(vendedor);
        else
            vendedor = vendedorList.get(0);
        return vendedor;
    }

}
