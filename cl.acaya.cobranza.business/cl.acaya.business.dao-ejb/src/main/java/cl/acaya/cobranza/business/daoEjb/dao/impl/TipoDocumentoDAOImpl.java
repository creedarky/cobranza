package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.DocumentoDAO;
import cl.acaya.cobranza.business.daoEjb.dao.TipoDocumentoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.entities.TipoDocumento;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(TipoDocumentoDAO.class)
@Stateless
public class TipoDocumentoDAOImpl extends  GenericDAOImpl<TipoDocumento,Long> implements TipoDocumentoDAO {


    @Override
    public TipoDocumento findOrCreate(TipoDocumento tipoDocumento) {
        List<TipoDocumento> tipoDocumentoList = em.createNamedQuery("TipoDocumento.findByCodigo")
                .setParameter("codigoTipo", tipoDocumento.getCodigoTipo())
                .setMaxResults(1)
                .getResultList();

        if(tipoDocumentoList == null || tipoDocumentoList.isEmpty())
            tipoDocumento = create(tipoDocumento);
        else
            tipoDocumento = tipoDocumentoList.get(0);
        return tipoDocumento;
    }
}
