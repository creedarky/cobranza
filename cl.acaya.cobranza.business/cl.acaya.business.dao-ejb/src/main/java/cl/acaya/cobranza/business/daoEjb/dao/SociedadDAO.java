package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.entities.Sociedad;

import java.util.List;


public interface SociedadDAO extends GenericDAO<Sociedad, Long> {


    Sociedad findOrCreate(Sociedad sociedad);

    List<String> findAllCodesByUsername(String username);
}
