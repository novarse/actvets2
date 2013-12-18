package org.smwillsdev.actvets.backingbean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.domain.Event;
import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.domain.EventLocation;
import org.smwillsdev.actvets.domain.EventSeason;
import org.smwillsdev.actvets.domain.EventType;
import org.smwillsdev.actvets.domain.Member;
import org.smwillsdev.actvets.domain.SysVars;
import org.smwillsdev.actvets.service.AdminService;
import org.smwillsdev.actvets.util.Constants;
import org.smwillsdev.actvets.util.Utils;
import org.smwillsdev.actvets.view.util.FacesUtils;

@Named
@SessionScoped
public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	AdminService service;

	private SysVars sysVars;

	private Event event;

	private EventDesc desc;

	private EventDesc descE;

	private EventDesc descEL;

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

	private boolean loadEventShown;

	private boolean loadDescShown;

	private boolean loadLocationShown;

	private boolean loadSeasonShown;

	private boolean loadTypeShown;

	private boolean loadMemberShown;

	private List<EventDesc> descList;

	private List<EventType> typeList;

	private List<EventLocation> locationList;

	private List<EventSeason> seasonList;

	private List<Member> memberList;

	private List<Member> directorList;

	private boolean loadDataShown;

	private UploadedFile file;

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
		if (Constants.EVENT.equals(blockId)) {
			eventShown = true;
		} else if (Constants.EVENT_DESC.equals(blockId)) {
			descShown = true;
		} else if (Constants.EVENT_TYPE.equals(blockId)) {
			typeShown = true;
		} else if (Constants.EVENT_SEASON.equals(blockId)) {
			seasonShown = true;
		} else if (Constants.EVENT_LOCATION.equals(blockId)) {
			locationShown = true;
		} else if (Constants.MEMBER.equals(blockId)) {
			memberShown = true;
		} else if (Constants.LOAD_DATA_SECTION.equals(blockId)) {
			loadDataShown = true;
		} else if (Constants.LOAD_EVENT.equals(blockId)) {
			loadEventShown = true;
		} else if (Constants.LOAD_EVENT_DESC.equals(blockId)) {
			loadDescShown = true;
		} else if (Constants.LOAD_EVENT_TYPE.equals(blockId)) {
			loadTypeShown = true;
		} else if (Constants.LOAD_EVENT_SEASON.equals(blockId)) {
			loadSeasonShown = true;
		} else if (Constants.LOAD_EVENT_LOCATION.equals(blockId)) {
			loadLocationShown = true;
		} else if (Constants.LOAD_MEMBER.equals(blockId)) {
			loadMemberShown = true;
		}
	}

	public void doHide(String blockId) {
		if (Constants.EVENT.equals(blockId)) {
			eventShown = false;
		} else if (Constants.EVENT_DESC.equals(blockId)) {
			descShown = false;
		} else if (Constants.EVENT_TYPE.equals(blockId)) {
			typeShown = false;
		} else if (Constants.EVENT_SEASON.equals(blockId)) {
			seasonShown = false;
		} else if (Constants.EVENT_LOCATION.equals(blockId)) {
			locationShown = false;
		} else if (Constants.MEMBER.equals(blockId)) {
			memberShown = false;
		} else if (Constants.LOAD_DATA_SECTION.equals(blockId)) {
			loadDataShown = false;
		} else if (Constants.LOAD_DATA_SECTION.equals(blockId)) {
			loadDataShown = false;
		} else if (Constants.LOAD_EVENT.equals(blockId)) {
			loadEventShown = false;
		} else if (Constants.LOAD_EVENT_DESC.equals(blockId)) {
			loadDescShown = false;
		} else if (Constants.LOAD_EVENT_TYPE.equals(blockId)) {
			loadTypeShown = false;
		} else if (Constants.LOAD_EVENT_SEASON.equals(blockId)) {
			loadSeasonShown = false;
		} else if (Constants.LOAD_EVENT_LOCATION.equals(blockId)) {
			loadLocationShown = false;
		} else if (Constants.LOAD_MEMBER.equals(blockId)) {
			loadMemberShown = false;
		}
	}

	public boolean showHide(String blockId) {
		if (Constants.EVENT.equals(blockId)) {
			return eventShown;
		} else if (Constants.EVENT_DESC.equals(blockId)) {
			return descShown;
		} else if (Constants.EVENT_TYPE.equals(blockId)) {
			return typeShown;
		} else if (Constants.EVENT_SEASON.equals(blockId)) {
			return seasonShown;
		} else if (Constants.EVENT_LOCATION.equals(blockId)) {
			return locationShown;
		} else if (Constants.MEMBER.equals(blockId)) {
			return memberShown;
		} else if (Constants.LOAD_DATA_SECTION.equals(blockId)) {
			return loadDataShown;
		} else if (Constants.LOAD_EVENT.equals(blockId)) {
			return loadEventShown;
		} else if (Constants.LOAD_EVENT_DESC.equals(blockId)) {
			return loadDescShown;
		} else if (Constants.LOAD_EVENT_TYPE.equals(blockId)) {
			return loadTypeShown;
		} else if (Constants.LOAD_EVENT_SEASON.equals(blockId)) {
			return loadSeasonShown;
		} else if (Constants.LOAD_EVENT_LOCATION.equals(blockId)) {
			return loadLocationShown;
		} else if (Constants.LOAD_MEMBER.equals(blockId)) {
			return loadMemberShown;
		} else {
			return false;
		}
	}

	public boolean showShow(String blockId) {
		if (Constants.EVENT.equals(blockId)) {
			return !eventShown;
		} else if (Constants.EVENT_DESC.equals(blockId)) {
			return !descShown;
		} else if (Constants.EVENT_TYPE.equals(blockId)) {
			return !typeShown;
		} else if (Constants.EVENT_SEASON.equals(blockId)) {
			return !seasonShown;
		} else if (Constants.EVENT_LOCATION.equals(blockId)) {
			return !locationShown;
		} else if (Constants.MEMBER.equals(blockId)) {
			return !memberShown;
		} else if (Constants.LOAD_DATA_SECTION.equals(blockId)) {
			return !loadDataShown;
		} else if (Constants.LOAD_EVENT.equals(blockId)) {
			return !loadEventShown;
		} else if (Constants.LOAD_EVENT_DESC.equals(blockId)) {
			return !loadDescShown;
		} else if (Constants.LOAD_EVENT_TYPE.equals(blockId)) {
			return !loadTypeShown;
		} else if (Constants.LOAD_EVENT_SEASON.equals(blockId)) {
			return !loadSeasonShown;
		} else if (Constants.LOAD_EVENT_LOCATION.equals(blockId)) {
			return !loadLocationShown;
		} else if (Constants.LOAD_MEMBER.equals(blockId)) {
			return !loadMemberShown;
		} else {
			return false;
		}
	}

	public String saveSection(String blockId) {
		if (Constants.EVENT.equals(blockId)) {
			saveEvent();
		} else if (Constants.EVENT_DESC.equals(blockId)) {
			saveDesc();
		} else if (Constants.EVENT_TYPE.equals(blockId)) {
			saveType();
		} else if (Constants.EVENT_SEASON.equals(blockId)) {
			saveSeason();
		} else if (Constants.EVENT_LOCATION.equals(blockId)) {
			saveLocation();
		} else if (Constants.MEMBER.equals(blockId)) {
			saveMember();
		}
		FacesUtils.popupMessage("Saved");
		return "";
	}

	public boolean showSaveButton(String blockId) {
		if (Constants.LOAD_DATA_SECTION.equals(blockId)) {
			return false;
		} else {
			return true;
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

	public void handleDescUpload(FileUploadEvent event) {
		service.processDataLoad(event, Constants.EVENT_DESC);
	}

	public void handleTypeUpload(FileUploadEvent event) {
		service.processDataLoad(event, Constants.EVENT_TYPE);
	}

	public void handleSeasonUpload(FileUploadEvent event) {
		service.processDataLoad(event, Constants.EVENT_SEASON);
	}

	public void handleLocationUpload(FileUploadEvent event) {
		service.processDataLoad(event, Constants.EVENT_LOCATION);
	}

	public void handleMemberUpload(FileUploadEvent event) {
		service.processDataLoad(event, Constants.MEMBER);
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getEventLine(String title, String eventType, String director,
			String distLong, String distShort) {
		return Utils.getEventLine(title, eventType, director, distLong,
				distShort);
	}

	public EventDesc getDescE() {
		return descE;
	}

	public void setDescE(EventDesc descE) {
		System.out.println("setDescE");
		descEL.setTitle("rrrrrrrrrrrrrrr");
		this.descE = descE;
	}

	public EventDesc getDescEL() {
		return descEL;
	}

	public void setDescEL(EventDesc descEL) {
		this.descEL = descEL;
	}
}
