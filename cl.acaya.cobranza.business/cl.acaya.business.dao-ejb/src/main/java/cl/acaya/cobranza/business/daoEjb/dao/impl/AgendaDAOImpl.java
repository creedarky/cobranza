package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.AgendaDAO;
import cl.acaya.cobranza.business.daoEjb.dao.ContactoDAO;
import cl.acaya.cobranza.business.daoEjb.entities.Agenda;
import cl.acaya.cobranza.business.daoEjb.entities.ContactoCliente;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by darkmoorx on 09-06-14.
 */
@Local(AgendaDAO.class)
@Stateless
public class AgendaDAOImpl extends  GenericDAOImpl<Agenda,Long> implements AgendaDAO {

    public AgendaDAOImpl(Class<ContactoCliente> type) {
        super(Agenda.class);
    }

    public AgendaDAOImpl() {
        super(Agenda.class);
    }

    public List<Agenda> getAgendaUsuario() {
        return em.createQuery("select a.systemId, a.comentario,a.fecAgenda,c.systemId, c.nombreCliente, " +
                "a.fecAgenda,u.systemId, u.nombreUsuario, u.nombreCompleto   from Agenda a inner join a.cliente c " +
                "left join a.usuario u  " +
                "where a.realizada = :noRealizada " +
                "group by c.systemId,a.fecAgenda,a.systemId, a.comentario," +
                "c.systemId, c.nombreCliente, " +
                "a.fecAgenda,u.systemId, u.nombreUsuario, u.nombreCompleto").setParameter("noRealizada",Boolean.FALSE).getResultList();
    }


}


