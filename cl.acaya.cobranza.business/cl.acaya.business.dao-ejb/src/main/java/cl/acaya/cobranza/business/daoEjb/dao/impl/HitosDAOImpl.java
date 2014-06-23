package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.api.enums.EtapasDocumentoType;
import cl.acaya.cobranza.business.daoEjb.dao.CargoUsuarioDAO;
import cl.acaya.cobranza.business.daoEjb.dao.HitosDAO;
import cl.acaya.cobranza.business.daoEjb.entities.*;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.Date;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(HitosDAO.class)
@Stateless
public class HitosDAOImpl extends  GenericDAOImpl<Hitos,Integer> implements HitosDAO {
    public HitosDAOImpl() {
        super(Hitos.class);
    }

    public void crearHito(Usuario usuario, Documento documento, ContactoCliente contactoCliente,Cliente cliente, EtapasDocumentoType etapasDocumentoType) {
        Hitos h = new Hitos();
        h.setCliente(cliente);
        h.setDocumento(documento);
        h.setFechaHito(new Date());
        h.setContacto(contactoCliente);
        h.setEtapa(etapasDocumentoType);
        // TODO falta usuario
        this.create(h);
    }

    public Hitos getUltimoHitoDocumento(Long idDocumento) {

        try {
            return  (Hitos) em.createQuery("from Hitos h where h.documento.systemId = :idDocumento order by h.systemId desc")
                    .setParameter("idDocumento",idDocumento).setMaxResults(1).getSingleResult();
        } catch (NoResultException nre) {
            //nre.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
