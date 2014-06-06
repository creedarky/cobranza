package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Usuario;
import cl.acaya.cobranza.business.daoEjb.entities.Vendedor;

import java.util.List;


public interface VendedorDAO extends GenericDAO<Vendedor, Long> {


    Vendedor findOrCreate(Vendedor vendedor);
}
