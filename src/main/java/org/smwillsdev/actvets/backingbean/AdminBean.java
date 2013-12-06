package org.smwillsdev.actvets.backingbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.domain.EventLocation;
import org.smwillsdev.actvets.domain.EventSeason;
import org.smwillsdev.actvets.domain.EventType;
import org.smwillsdev.actvets.domain.SysVars;
import org.smwillsdev.actvets.service.AdminService;

@Named
@SessionScoped
public class AdminBean implements Serializable {

	private static final String TYPE_SECTION = "typeSection";

	private static final String SEASON_SECTION = "seasonSection";

	private static final String LOCATION_SECTION = "locationSection";

	private static final String DESC_SECTION = "descSection";

	private static final String EVENT_SECTION = "eventSection";

	private static final long serialVersionUID = 1L;

	@EJB
	AdminService service;

	private SysVars sysVars;

	private EventDesc desc;

	private EventType eventType;

	private EventSeason season;

	private EventLocation location;

	private String email;

	private String fullName;

	private String password;

	private String passwordConfirm;

	private boolean eventShown;

	private boolean descShown;

	private boolean locationShown;

	private boolean seasonShown;

	private boolean typeShown;

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

	public void doShow(String blockId) {
		if (EVENT_SECTION.equals(blockId)) {
			eventShown = true;
		} else if (DESC_SECTION.equals(blockId)) {
			descShown = true;
		} else if (TYPE_SECTION.equals(blockId)) {
			typeShown = true;
		} else if (SEASON_SECTION.equals(blockId)) {
			seasonShown = true;
		} else if (LOCATION_SECTION.equals(blockId)) {
			locationShown = true;
		}
	}

	public void doHide(String blockId) {
		if (EVENT_SECTION.equals(blockId)) {
			eventShown = false;
		} else if (DESC_SECTION.equals(blockId)) {
			descShown = false;
		} else if (TYPE_SECTION.equals(blockId)) {
			typeShown = false;
		} else if (SEASON_SECTION.equals(blockId)) {
			seasonShown = false;
		} else if (LOCATION_SECTION.equals(blockId)) {
			locationShown = false;
		}
	}

	public boolean showHide(String blockId) {
		if (EVENT_SECTION.equals(blockId)) {
			return eventShown;
		} else if (DESC_SECTION.equals(blockId)) {
			return descShown;
		} else if (TYPE_SECTION.equals(blockId)) {
			return typeShown;
		} else if (SEASON_SECTION.equals(blockId)) {
			return seasonShown;
		} else if (LOCATION_SECTION.equals(blockId)) {
			return locationShown;
		} else {
			return false;
		}
	}

	public boolean showShow(String blockId) {
		if (EVENT_SECTION.equals(blockId)) {
			return !eventShown;
		} else if (DESC_SECTION.equals(blockId)) {
			return !descShown;
		} else if (TYPE_SECTION.equals(blockId)) {
			return !typeShown;
		} else if (SEASON_SECTION.equals(blockId)) {
			return !seasonShown;
		} else if (LOCATION_SECTION.equals(blockId)) {
			return !locationShown;
		} else {
			return false;
		}
	}

	public SysVars getSysVars() {
		if (sysVars == null) {
			sysVars = new SysVars();
		}
		return sysVars;
	}

	public void setSysVars(SysVars sysVars) {
		this.sysVars = sysVars;
	}

	public EventDesc getDesc() {
		if (desc == null) {
			desc = new EventDesc();
		}
		return desc;
	}

	public void setDesc(EventDesc desc) {
		this.desc = desc;
	}

	public EventType getEventType() {
		if (eventType == null) {
			eventType = new EventType();
		}
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public EventSeason getSeason() {
		if (season == null) {
			season = new EventSeason();
		}
		return season;
	}

	public void setSeason(EventSeason season) {
		this.season = season;
	}

	public EventLocation getLocation() {
		if (location == null) {
			location = new EventLocation();
		}
		return location;
	}

	public void setLocation(EventLocation location) {
		this.location = location;
	}

	public String saveSection(String blockId) {
		if (EVENT_SECTION.equals(blockId)) {
			saveEvent();
		} else if (DESC_SECTION.equals(blockId)) {
			saveDesc();
		} else if (TYPE_SECTION.equals(blockId)) {
			saveType();
		} else if (SEASON_SECTION.equals(blockId)) {
			saveSeason();
		} else if (LOCATION_SECTION.equals(blockId)) {
			saveLocation();
		}
		return "";
	}

	private void saveEvent() {
		// TODO Auto-generated method stub

	}

	private void saveDesc() {
		desc = service.saveDesc(desc);
	}

	private void saveType() {
		// TODO Auto-generated method stub

	}

	private void saveSeason() {
		// TODO Auto-generated method stub

	}

	private void saveLocation() {
		// TODO Auto-generated method stub

	}
}
