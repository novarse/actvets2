package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;

@Local
public interface Dao<T> {
	public T save(T ent);

	public T find(Class<T> clazz, Long id);
}
