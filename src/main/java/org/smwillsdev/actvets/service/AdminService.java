package org.smwillsdev.actvets.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.dataaccess.AdminDao;
import org.smwillsdev.actvets.domain.Admin;
import org.smwillsdev.actvets.domain.Event;
import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.domain.EventLocation;
import org.smwillsdev.actvets.domain.EventSeason;
import org.smwillsdev.actvets.domain.EventType;
import org.smwillsdev.actvets.domain.Member;

@Stateless
public class AdminService {

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

}
