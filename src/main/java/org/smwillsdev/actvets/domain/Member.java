package org.smwillsdev.actvets.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.smwillsdev.actvets.type.Gender;

@Entity
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "Id_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Id_Gen", initialValue = 10000, allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Id_Gen")
	private long id;

	private String firstName;

	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

	private String email;

	private String phoneHome;

	private String phoneWorkOrMobile;

	private int raceNumber;

	private String grade;

	private int subGrade;

	private String criteriumGrade;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private boolean firstAid;

	private String emergencyContact;

	private String phoneEmergencyContact;

	private String phoneEmergencyContact2;

	private boolean raceDirector;

	private boolean isActive;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		if (address == null) {
			address = new Address();
		}
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getPhoneWorkOrMobile() {
		return phoneWorkOrMobile;
	}

	public void setPhoneWorkOrMobile(String phoneWorkOrMobile) {
		this.phoneWorkOrMobile = phoneWorkOrMobile;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getSubGrade() {
		return subGrade;
	}

	public void setSubGrade(int subGrade) {
		this.subGrade = subGrade;
	}

	public String getCriteriumGrade() {
		return criteriumGrade;
	}

	public void setCriteriumGrade(String criteriumGrade) {
		this.criteriumGrade = criteriumGrade;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isFirstAid() {
		return firstAid;
	}

	public void setFirstAid(boolean firstAid) {
		this.firstAid = firstAid;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getPhoneEmergencyContact() {
		return phoneEmergencyContact;
	}

	public void setPhoneEmergencyContact(String phoneEmergencyContact) {
		this.phoneEmergencyContact = phoneEmergencyContact;
	}

	public String getPhoneEmergencyContact2() {
		return phoneEmergencyContact2;
	}

	public void setPhoneEmergencyContact2(String phoneEmergencyContact2) {
		this.phoneEmergencyContact2 = phoneEmergencyContact2;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRaceNumber() {
		return raceNumber;
	}

	public void setRaceNumber(int raceNumber) {
		this.raceNumber = raceNumber;
	}

	public boolean isRaceDirector() {
		return raceDirector;
	}

	public void setRaceDirector(boolean raceDirector) {
		this.raceDirector = raceDirector;
	}

}
