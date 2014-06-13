package cl.acaya.cobranza.business.daoEjb.dao;

import cl.acaya.cobranza.business.daoEjb.entities.Documento;
import cl.acaya.cobranza.business.daoEjb.entities.Usuario;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {

    T create(T t);

    void delete(T t);

    T find(PK id);

    T findReference(PK id);

    T update(T t);

}
