package org.smwillsdev.actvets.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.dataaccess.AdminDao;
import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.domain.EventDesc;

@Stateless
public class AdminService {

	@EJB
	private AdminDao dao;

	public Admin saveAdmin(Admin admin) {
		return dao.save(admin);
	}

	public EventDesc saveDesc(EventDesc desc) {
		return dao.save(desc);
	}

}
