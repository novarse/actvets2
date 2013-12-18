package org.smwillsdev.actvets.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.primefaces.event.FileUploadEvent;
import org.smwillsdev.actvets.dataaccess.AdminDao;
import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.domain.Event;
import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.domain.EventLocation;
import org.smwillsdev.actvets.domain.EventSeason;
import org.smwillsdev.actvets.domain.EventType;
import org.smwillsdev.actvets.domain.Member;
import org.smwillsdev.actvets.type.AuState;
import org.smwillsdev.actvets.util.Constants;
import org.smwillsdev.actvets.util.Utils;
import org.smwillsdev.actvets.view.util.FacesUtils;

@Stateless
public class AdminService {

	private static final String MEMBER = "member";

	static Logger log = Logger.getLogger(AdminService.class.getName());

	private static final String LOCATION = "location";
	private static final int DESC_TITLE_COPY_LENGTH = 40;
	private static final String DESCRIPTION = "description";
	private static final String SEASON = "season";
	private static final String TYPE = "type";
	@EJB
	private AdminDao dao;

	public Admin saveAdmin(Admin admin) {
		return dao.save(admin, Admin.class);
	}

	public Event saveEvent(Event event) {
		return dao.save(event, Event.class);
	}

	public EventDesc saveDesc(EventDesc desc) {
		return dao.save(desc, EventDesc.class);
	}

	public EventType saveType(EventType eventType) {
		return dao.save(eventType, EventType.class);
	}

	public EventLocation saveLocation(EventLocation location) {
		return dao.save(location, EventLocation.class);
	}

	public EventSeason saveSeason(EventSeason season) {
		return dao.save(season, EventSeason.class);
	}

	public Member saveMember(Member member) {
		return dao.save(member, Member.class);
	}

	public List<EventDesc> getDescList(List<EventDesc> descList) {
		if (descList == null) {
			descList = dao.getDescList();
		}
		return descList;
	}

	public List<EventType> getTypeList(List<EventType> typeList) {
		if (typeList == null) {
			typeList = dao.getTypeList();
		}
		return typeList;
	}

	public List<EventLocation> getLocationList(List<EventLocation> locationList) {
		if (locationList == null) {
			locationList = dao.getLocationList();
		}
		return locationList;
	}

	public List<EventSeason> getSeasonList(List<EventSeason> seasonList) {
		if (seasonList == null) {
			seasonList = dao.getSeasonList();
		}
		return seasonList;
	}

	public List<Member> getMemberList(List<Member> memberList) {
		if (memberList == null) {
			memberList = dao.getMemberList();
		}
		return memberList;
	}

	public List<Member> getDirectorList(List<Member> directorList) {
		if (directorList == null) {
			directorList = dao.getMemberList();
		}
		return directorList;
	}

	public void processDataLoad(FileUploadEvent event, String dataType) {
		FacesUtils.displayMessage(Constants.UPLOAD_MESSAGE, "Successful", event
				.getFile().getFileName() + " is uploaded.");

		try (InputStream is = event.getFile().getInputstream()) {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));

			if (Constants.EVENT_TYPE.equals(dataType)) {
				processEventType(reader);
			} else if (Constants.EVENT_SEASON.equals(dataType)) {
				processEventSeason(reader);
			} else if (Constants.EVENT_DESC.equals(dataType)) {
				processEventDesc(reader);
			} else if (Constants.EVENT_LOCATION.equals(dataType)) {
				processEventLocation(reader);
			} else if (Constants.MEMBER.equals(dataType)) {
				processMember(reader);
			}

			FacesUtils.displayMessage(Constants.UPLOAD_MESSAGE, "Successful",
					event.getFile().getFileName() + " is processed.");

		} catch (FileNotFoundException ex) {
			System.err.println("Missing file " + event.getFile().getFileName());
			FacesUtils.displayError(Constants.UPLOAD_MESSAGE,
					"Processing Failed", "Missing file "
							+ event.getFile().getFileName());
		} catch (IOException e) {
			FacesUtils.displayError(Constants.UPLOAD_MESSAGE,
					"Processing Failed",
					"An error occurred processing the file");
			e.printStackTrace();
		} catch (Exception e) {
			FacesUtils.displayError(Constants.UPLOAD_MESSAGE,
					"Processing Failed",
					"An error occurred processing the file: " + e.getMessage());
			e.printStackTrace();
		}

	}

	private void processMember(BufferedReader reader) throws Exception {
		String line = null;
		String[] parts;
		line = reader.readLine();
		if (!MEMBER.equals(line.trim())) {
			throw new Exception(
					"The first part of this file must begin with the word 'member'");
		}
		while ((line = reader.readLine()) != null) {
			parts = line.split("\t");
			Member ent = new Member();
			ent.setId(Long.parseLong(parts[0]));
			ent.setFirstName(parts[1]);
			ent.setActive(Utils.getBooleanFromStr(parts[2]));
			ent.getAddress().setStreet(parts[3]);
			ent.getAddress().setSuburb(parts[4]);
			ent.getAddress().setState(Utils.getStateFromStr(parts[5]));
			ent.getAddress().setPostcode(Utils.getIntegerFromStr(parts[6]));
			ent.setPhoneHome(parts[7]);
			ent.setPhoneWorkOrMobile(parts[8]);
			ent.setDateOfBirth(Utils.getDDMMYYYYDateFromStr(parts[9]));
			ent.setGender(Utils.getGenderFromStr(parts[10]));
			ent.setEmail(parts[11]);
			ent.setFirstAid(Utils.getBooleanFromStr(parts[12]));
			ent.setEmergencyContact(parts[13]);
			ent.setPhoneEmergencyContact(parts[14]);
			ent.setPhoneEmergencyContact2(parts[15]);
			ent.setRaceNumber(Utils.getIntegerFromStr(parts[16]));
			ent.setGrade(parts[17]);
			ent.setSubGrade(Utils.getIntegerFromStr(parts[18]));
			ent.setCriteriumGrade(parts[19]);
			ent.setRaceDirector(Utils.getBooleanFromStr(parts[20]));
			ent.setLastName(parts[22]);
			saveMember(ent);
		}
	}

	// return getId() + TAB + getFirstName() + TAB + isActive() + TAB
	// + getStreet() + TAB + getSuburb() + TAB + getState() + TAB
	// + getPostcode() + TAB + getPhoneHome() + TAB
	// + getPhoneWorkOrMobile() + TAB
	// + Utils.formatDateForExport(getDob()) + TAB + getGender() + TAB
	// + getEmail() + TAB + isFirstAid() + TAB + getEmergencyContact()
	// + TAB + getPhoneEmergencyContact() + TAB
	// + getPhoneEmergencyContact2() + TAB + getNumber() + TAB + grade
	// + TAB + getSubGrade() + TAB + getCriteriumGrade() + TAB
	// + isDirector() + TAB + getAVCCNumber() + TAB + getLastName();

	private void processEventSeason(BufferedReader reader) throws Exception {
		String line = null;
		String[] parts;
		line = reader.readLine();
		if (!SEASON.equals(line.trim())) {
			throw new Exception(
					"The first part of this file must begin with the word 'season'");
		}
		while ((line = reader.readLine()) != null) {
			parts = line.split("\t");
			EventSeason ent = new EventSeason();
			ent.setId(Long.parseLong(parts[0]));
			ent.setTitle(parts[1]);
			if (parts[2] != null && !parts[2].isEmpty()) {
				try {
					ent.setListOrder(Integer.parseInt(parts[2]));
				} catch (NumberFormatException e) {
					// no need to do anything
				}
			}
			ent.setListOrder(Integer.parseInt(parts[2]));
			saveSeason(ent);
		}
	}

	private void processEventDesc(BufferedReader reader) throws Exception {
		String line = null;
		String[] parts;
		line = reader.readLine();
		if (!DESCRIPTION.equals(line.trim())) {
			throw new Exception(
					"The first part of this file must begin with the word 'description'");
		}
		while ((line = reader.readLine()) != null) {
			parts = line.split("\t");
			EventDesc ent = new EventDesc();
			ent.setId(Long.parseLong(parts[0]));
			ent.setTitle(parts[1].length() > DESC_TITLE_COPY_LENGTH ? parts[1]
					.substring(0, 40) : parts[1]);
			ent.setDescription(parts[1]);
			if (parts[2] != null && !parts[2].isEmpty()) {
				try {
					ent.setDistLong(Float.parseFloat(parts[2]));
				} catch (NumberFormatException e) {
					log.warning("Invalid distance long for description (id = "
							+ ent.getId() + "): " + parts[2]);
				}
			}
			if (parts[3] != null && !parts[3].isEmpty()) {
				try {
					ent.setDistShort(Float.parseFloat(parts[3]));
				} catch (NumberFormatException e) {
					log.warning("Invalid distance short for description (id = "
							+ ent.getId() + "): " + parts[3]);
				}
			}
			ent.setActive(Utils.getBooleanFromStr(parts[4]));
			saveDesc(ent);
		}
	}

	private void processEventType(BufferedReader reader) throws Exception {
		String line = null;
		String[] parts;
		line = reader.readLine();
		if (!TYPE.equals(line.trim())) {
			throw new Exception(
					"The first part of this file must begin with the word 'type'");
		}
		while ((line = reader.readLine()) != null) {
			parts = line.split("\t");
			EventType e = new EventType();
			e.setId(Long.parseLong(parts[0]));
			e.setTitle(parts[1]);
			saveType(e);
		}
	}

	private void processEventLocation(BufferedReader reader) throws Exception {
		String line = null;
		String[] parts;
		line = reader.readLine();
		if (!LOCATION.equals(line.trim())) {
			throw new Exception(
					"The first part of this file must begin with the word 'location'");
		}
		while ((line = reader.readLine()) != null) {
			parts = line.split("\t");
			EventLocation ent = new EventLocation();
			ent.setId(Long.parseLong(parts[0]));
			ent.setTitle(parts[1]);
			ent.setDirections(parts[2]);
			if (parts[3] != null && !parts[3].isEmpty()) {
				try {
					ent.setLatitude(Float.parseFloat(parts[3]));
				} catch (NumberFormatException e) {
					log.warning("Invalid latitude for location (id = "
							+ ent.getId() + "): " + parts[3]);
				}
			}
			if (parts[4] != null && !parts[4].isEmpty()) {
				try {
					ent.setLongitude(Float.parseFloat(parts[4]));
				} catch (NumberFormatException e) {
					log.warning("Invalid longitude for location (id = "
							+ ent.getId() + "): " + parts[4]);
				}
			}
			AuState state = Utils.getStateFromStr(parts[5]);
			if (state == null) {
				log.warning("Invalid state for location (id = " + ent.getId()
						+ "): " + parts[5]);
			} else {
				ent.setState(state);
			}
			saveLocation(ent);
		}
	}

}
