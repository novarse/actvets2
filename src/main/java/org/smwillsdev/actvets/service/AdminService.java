package org.smwillsdev.actvets.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.dataaccess.AdminDao;
import org.smwillsdev.actvets.domain.Admin;

@Stateless
public class AdminService {

	@EJB
	private AdminDao dao;

	public Admin saveAdmin(Admin admin) {
		System.out.println("saveAdmin");
		return dao.save(admin);
	}

}
