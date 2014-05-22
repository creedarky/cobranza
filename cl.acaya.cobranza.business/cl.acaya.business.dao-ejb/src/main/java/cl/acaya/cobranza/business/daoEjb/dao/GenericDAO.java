package cl.acaya.cobranza.business.daoEjb.dao;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {

    T create(T t);

    void delete(T t);

    T find(PK id);

    T update(T t);

}
