package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BaseDao<T> implements Dao<T> {

	@PersistenceContext
	EntityManager em;

	@Override
	public T save(T ent) {
		ent = em.merge(ent);
		return ent;
	}

	@Override
	public T find(Class<T> clazz, Long id) {
		if (id == null) {
			return null;
		} else {
			return em.find(clazz, id);
		}
	}

}
