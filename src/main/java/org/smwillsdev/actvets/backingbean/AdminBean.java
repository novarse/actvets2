package org.smwillsdev.actvets.backingbean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.domain.Event;
import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.domain.EventLocation;
import org.smwillsdev.actvets.domain.EventSeason;
import org.smwillsdev.actvets.domain.EventType;
import org.smwillsdev.actvets.domain.Member;
import org.smwillsdev.actvets.domain.SysVars;
import org.smwillsdev.actvets.service.AdminService;

@Named
@SessionScoped
public class AdminBean implements Serializable {

	private static final String MEMBER_SECTION = "memberSection";

	private static final String TYPE_SECTION = "typeSection";

	private static final String SEASON_SECTION = "seasonSection";

	private static final String LOCATION_SECTION = "locationSection";

	private static final String DESC_SECTION = "descSection";

	private static final String EVENT_SECTION = "eventSection";

	private static final long serialVersionUID = 1L;

	@EJB
	AdminService service;

	private SysVars sysVars;

	private Event event;

	private EventDesc desc;

	private EventType eventType;

	private EventSeason season;

	private EventLocation location;

	private Member member;

	private Member director;

	private String email;

	private String fullName;

	private String password;

	private String passwordConfirm;

	private boolean eventShown;

	private boolean descShown;

	private boolean locationShown;

	private boolean seasonShown;

	private boolean typeShown;

	private boolean memberShown;

	private List<EventDesc> descList;

	private List<EventType> typeList;

	private List<EventLocation> locationList;

	private List<EventSeason> seasonList;

	private List<Member> memberList;

	private List<Member> directorList;

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
		} else if (MEMBER_SECTION.equals(blockId)) {
			memberShown = true;
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
		} else if (MEMBER_SECTION.equals(blockId)) {
			memberShown = false;
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
		} else if (MEMBER_SECTION.equals(blockId)) {
			return memberShown;
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
		} else if (MEMBER_SECTION.equals(blockId)) {
			return !memberShown;
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

	public Event getEvent() {
		if (event == null) {
			event = new Event();
		}
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
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

	public Member getMember() {
		if (member == null) {
			member = new Member();
		}
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getDirector() {
		if (director == null) {
			director = new Member();
		}
		return director;
	}

	public void setDirector(Member director) {
		this.director = director;
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
		} else if (MEMBER_SECTION.equals(blockId)) {
			saveMember();
		}
		return "";
	}

	private void saveEvent() {
		service.saveEvent(event);
		event = null;
	}

	private void saveDesc() {
		service.saveDesc(desc);
		desc = null;
		descList = null;
	}

	private void saveType() {
		service.saveType(eventType);
		eventType = null;
		typeList = null;
	}

	private void saveLocation() {
		service.saveLocation(location);
		location = null;
		locationList = null;
	}

	private void saveSeason() {
		service.saveSeason(season);
		season = null;
		seasonList = null;
	}

	private void saveMember() {
		service.saveMember(member);
		member = null;
		memberList = null;
		directorList = null;
	}

	public List<Integer> getSeasonOrder() {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 19, 20);
	}

	public List<EventDesc> getDescList() {
		descList = service.getDescList(descList);
		return descList;
	}

	public List<EventType> getTypeList() {
		typeList = service.getTypeList(typeList);
		return typeList;
	}

	public List<EventLocation> getLocationList() {
		locationList = service.getLocationList(locationList);
		return locationList;
	}

	public List<EventSeason> getSeasonList() {
		seasonList = service.getSeasonList(seasonList);
		return seasonList;
	}

	public List<Member> getDirectorList() {
		directorList = service.getDirectorList(directorList);
		return directorList;
	}

	public List<Member> getMemberList() {
		memberList = service.getMemberList(memberList);
		return memberList;
	}

}
