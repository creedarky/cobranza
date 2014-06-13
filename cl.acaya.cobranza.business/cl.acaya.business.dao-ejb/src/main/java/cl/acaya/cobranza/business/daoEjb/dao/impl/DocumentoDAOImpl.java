package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.api.vo.CarteraVO;
import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.dao.DocumentoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;
import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.util.TypesAdaptor;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(DocumentoDAO.class)
@Stateless
@SuppressWarnings({"unchecked"})
public class DocumentoDAOImpl extends  GenericDAOImpl<Documento,Long> implements DocumentoDAO {


    private Documento documento;

    public List<Object[]> getCarteraClientes() {
        return em.createNativeQuery(
                "select cast(c.nom_cliente as varchar) as nom_cliente, c.system_id,cast(c.rut as varchar) as rut" +
                ",cast(vw.tramo as varchar) as tramo ,min(vw.dias) as dias, sum(vw.monto) as monto, vw.link_dm " +
                "FROM cobranza.dbo.vw_docs_tramos vw " +
                "inner join cobranza.dbo.tbl_dm_cliente dm on dm.system_id = vw.link_dm " +
                "inner join cobranza.dbo.tbl_cliente c on dm.link_cliente = c.system_id "  +
                "inner join cobranza.dbo.tbl_tipo_documento td on td.system_id = vw.link_tipo_doc " +
                "inner join cobranza.dbo.tbl_vendedor v on v.system_id = vw.link_vendedor " +
                "group by c.system_id,c.rut,vw.link_dm,c.nom_cliente, tramo order by c.nom_cliente, min(dias) asc")
                .setMaxResults(10)
                .getResultList();
    }

    public List<Object[]> getTotalCarteraClientesByIdCliente(Long idCliente) {
        return em.createNativeQuery(
                "select cast(c.nom_cliente as varchar) as nom_cliente, c.system_id,cast(c.rut as varchar) as rut" +
                        ",cast(vw.tramo as varchar) as tramo ,min(vw.dias) as dias, sum(vw.monto) as monto, vw.link_dm " +
                        "FROM cobranza.dbo.vw_docs_tramos vw " +
                        "inner join cobranza.dbo.tbl_dm_cliente dm on dm.system_id = vw.link_dm " +
                        "inner join cobranza.dbo.tbl_cliente c on dm.link_cliente = c.system_id "  +
                        "inner join cobranza.dbo.tbl_tipo_documento td on td.system_id = vw.link_tipo_doc " +
                        "inner join cobranza.dbo.tbl_vendedor v on v.system_id = vw.link_vendedor " +
                        "where c.system_id = :idCliente " +
                        "group by c.system_id,c.rut,vw.link_dm,c.nom_cliente, tramo order by c.nom_cliente, min(dias) asc")
                .setParameter("idCliente", idCliente)
                .getResultList();
    }


    public List<Object[]> getCarteraClienteByIdCliente(Long idCliente) {
        return em.createNativeQuery(
                "select cast(c.nom_cliente as varchar) as nom_cliente,cast(c.rut as varchar) as rut," +
                "cast(vw.tramo as varchar) as tramo ,vw.dias as dias, vw.monto as monto, " +
                "cast(vw.num_doc as varchar) as num_doc, cast(v.cod_vendedor as varchar) as vendedor, " +
                "cast(td.cod_tipo as varchar) as codTipo, vw.fecha_emision, vw.fecha_vencimiento, vw.system_id " +
                "FROM cobranza.dbo.vw_docs_tramos vw " +
                "inner join cobranza.dbo.tbl_dm_cliente dm on dm.system_id = vw.link_dm " +
                "inner join cobranza.dbo.tbl_cliente c on dm.link_cliente = c.system_id "  +
                "inner join cobranza.dbo.tbl_tipo_documento td on td.system_id = vw.link_tipo_doc " +
                "inner join cobranza.dbo.tbl_vendedor v on v.system_id = vw.link_vendedor " +
                "where c.system_id = :idCliente " +
                "order by vw.fecha_emision ")
                .setParameter("idCliente", idCliente)
                .getResultList();
    }



    public Documento findOrCreate(Documento documento) {
        List<Documento> documentoList = em.createNamedQuery("Documento.findByNumeroFactura")
                .setParameter("numeroFactura", documento.getNumeroFactura())
                .setMaxResults(1)
                .getResultList();

        if(documentoList == null || documentoList.isEmpty())
            documento = create(documento);
        else {
            Documento aux = documentoList.get(0);
            aux = TypesAdaptor.actualizar(aux, documento);
            update(aux);
            documento = aux;
        }
        return documento;
    }

    public List<Documento> getDocumentosByDMCliente(Long idDMCliente) {
        return em.createQuery("from Documento dm where dm.dmCliente.systemId = :idDmcliente")
                .setParameter("idDmcliente", idDMCliente)
                .getResultList();
    }

    public List<Documento> getDocumentosByIdDocumentos(List<Long> idDocumentosList) {
        return em.createQuery("from Documento  dm where dm.systemId in (:idDocumentos)")
                .setParameter("idDocumentos", idDocumentosList)
                .getResultList();
    }
}
