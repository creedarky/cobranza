package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.dao.DocumentoDAO;
import cl.acaya.cobranza.business.daoEjb.dao.SociedadDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.entities.Sociedad;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(SociedadDAO.class)
@Stateless
public class SociedadDaoImpl extends  GenericDAOImpl<Sociedad,Long> implements SociedadDAO {

}
