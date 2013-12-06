package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.domain.EventDesc;

@Stateless
@Local
public class AdminDao {

	@PersistenceContext
	EntityManager em;

	public Admin save(Admin admin) {
		return em.merge(admin);
	}

	public EventDesc save(EventDesc desc) {
		return em.merge(desc);
	}
}
