package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.smwillsdev.actvets.domain.Admin;

@Stateless
@Local
public class AdminDao {

	@PersistenceContext
	EntityManager em;

	public Admin save(Admin admin) {
		System.out.println("admindao save");
		return em.merge(admin);
	}
}
