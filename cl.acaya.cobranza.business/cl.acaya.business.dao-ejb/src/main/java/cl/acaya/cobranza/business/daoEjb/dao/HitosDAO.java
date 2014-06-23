package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.api.enums.EtapasDocumentoType;
import cl.acaya.cobranza.business.daoEjb.entities.*;

import java.util.List;


public interface HitosDAO extends GenericDAO<Hitos, Integer> {

    void crearHito(Usuario usuario, Documento documento, ContactoCliente contactoCliente,Cliente cliente, EtapasDocumentoType etapasDocumentoType);

    Hitos getUltimoHitoDocumento(Long idDocumento);

    List<Hitos> getHitosByIdCliente(Long idCliente);

    List<Hitos> getHitosByIdDocumentos(List<Long> idDocumentos);
}
