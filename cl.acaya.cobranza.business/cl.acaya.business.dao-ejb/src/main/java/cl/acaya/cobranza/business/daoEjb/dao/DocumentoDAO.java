package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Documento;

import java.util.List;


public interface DocumentoDAO extends GenericDAO<Documento, Long> {


    List<Object[]> getCarteraClientes();

    Documento findOrCreate(Documento documento);

    List<Documento> getDocumentosByDMCliente(Long idDMCliente);

    List<Object[]> getCarteraClienteByIdCliente(Long idDMCliente);

    List<Object[]> getTotalCarteraClientesByIdCliente(Long idCliente);

    List<Documento> getDocumentosByIdDocumentos(List<Long> idDocumentosList);
}
