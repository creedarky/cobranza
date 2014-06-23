package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.api.enums.EtapasDocumentoType;
import cl.acaya.cobranza.business.daoEjb.entities.*;


public interface HitosDAO extends GenericDAO<Hitos, Integer> {

    void crearHito(Usuario usuario, Documento documento, ContactoCliente contactoCliente,Cliente cliente, EtapasDocumentoType etapasDocumentoType);

    Hitos getUltimoHitoDocumento(Long idDocumento);
}
