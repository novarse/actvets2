package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BaseDao<T> implements Dao<T> {

	@PersistenceContext
	EntityManager em;

	@Override
	public T save(T entity) {
		entity = em.merge(entity);
		return entity;
	}

}
