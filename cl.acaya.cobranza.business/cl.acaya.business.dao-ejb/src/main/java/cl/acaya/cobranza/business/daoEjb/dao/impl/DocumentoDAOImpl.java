package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.api.vo.CarteraVO;
import cl.acaya.cobranza.business.daoEjb.dao.ClienteDAO;
import cl.acaya.cobranza.business.daoEjb.dao.DocumentoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Cliente;
import cl.acaya.cobranza.business.daoEjb.entities.Documento;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by mcastro on 23-05-14.
 */
@Local(DocumentoDAO.class)
@Stateless
public class DocumentoDAOImpl extends  GenericDAOImpl<Documento,Long> implements DocumentoDAO {


    private Documento documento;

    public List<Object[]> getCarteraClientes() {
        return em.createNativeQuery(
                "select cast(c.nom_cliente as varchar) as nom_cliente, c.system_id,cast(c.rut as varchar) as rut" +
                ",cast(vw.tramo as varchar) as tramo ,min(vw.dias) as dias, sum(vw.monto) as monto " +
                "FROM cobranza.dbo.vw_docs_tramos vw " +
                "inner join cobranza.dbo.tbl_dm_cliente dm on dm.system_id = vw.link_dm " +
                "inner join cobranza.dbo.tbl_cliente c on dm.link_cliente = c.system_id "  +
                "group by c.system_id,c.rut,vw.link_dm,c.nom_cliente, tramo order by c.nom_cliente, min(dias) asc")
                .getResultList();
    }

    public Documento findOrCreate(Documento documento) {
        List<Documento> documentoList = em.createNamedQuery("Documento.findByNumeroFactura")
                .setParameter("numeroFactura", documento.getNumeroFactura())
                .setMaxResults(1)
                .getResultList();

        if(documentoList == null || documentoList.isEmpty())
            documento = create(documento);
        else
            documento = documentoList.get(0);
        return documento;
    }
}
