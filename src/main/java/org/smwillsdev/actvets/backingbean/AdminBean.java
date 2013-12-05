package org.smwillsdev.actvets.backingbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.service.AdminService;

@Named
@SessionScoped
public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	AdminService service;

	private String email;

	private String fullName;

	private String password;

	private String passwordConfirm;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String register() {
		System.out.println("register");
		Admin admin = new Admin();

		admin.setEmail(email);
		admin.setPassword(password);

		admin = service.saveAdmin(admin);

		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
