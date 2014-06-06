package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.entities.TipoDocumento;

import java.util.List;


public interface TipoDocumentoDAO extends GenericDAO<TipoDocumento, Long> {

    TipoDocumento findOrCreate(TipoDocumento tipoDocumentoDAO);

}
