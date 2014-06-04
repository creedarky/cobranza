package cl.acaya.cobranza.business.daoEjb.dao.impl;

import cl.acaya.cobranza.business.daoEjb.dao.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: maguirre
 * Date: 8/2/13
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */

public abstract class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

    @PersistenceContext(unitName = "cobranza")
    protected EntityManager em;

    protected Class<T> type;

    public GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    public GenericDAOImpl() {
    }

    @Override
    public T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @Override
    public void delete(T t) {
        t = this.em.merge(t);
        this.em.remove(t);
    }

    @Override
    public T find(PK id) {
        return this.em.find(type, id);
    }

    @Override
    public T update(T t) {
        this.em.merge(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }


}
