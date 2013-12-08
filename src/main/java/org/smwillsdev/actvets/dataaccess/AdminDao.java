package org.smwillsdev.actvets.dataaccess;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.smwillsdev.actvets.domain.EventDesc;
import org.smwillsdev.actvets.domain.EventLocation;
import org.smwillsdev.actvets.domain.EventSeason;
import org.smwillsdev.actvets.domain.EventType;
import org.smwillsdev.actvets.domain.Member;

@Stateless
@Local
public class AdminDao {

	private static final String GET_ALL_DIRECTORS = "getAllDirectors";
	private static final String GET_ALL_MEMBERS = "getAllMembers";
	private static final String GET_ALL_SEASONS = "getAllSeasons";
	private static final String GET_ALL_LOCATIONS = "getAllLocations";
	private static final String GET_ALL_EVENT_TYPES = "getAllEventTypes";
	private static final String GET_ALL_DESCRIPTIONS = "getAllDescriptions";
	@PersistenceContext
	EntityManager em;

	public <T extends Object> T save(T obj, Class<T> type) {
		return type.cast(em.merge(obj));
	}

	public List<EventDesc> getDescList() {
		return em.createNamedQuery(GET_ALL_DESCRIPTIONS, EventDesc.class)
				.getResultList();
	}

	public List<EventType> getTypeList() {
		return em.createNamedQuery(GET_ALL_EVENT_TYPES, EventType.class)
				.getResultList();
	}

	public List<EventLocation> getLocationList() {
		return em.createNamedQuery(GET_ALL_LOCATIONS, EventLocation.class)
				.getResultList();
	}

	public List<EventSeason> getSeasonList() {
		return em.createNamedQuery(GET_ALL_SEASONS, EventSeason.class)
				.getResultList();
	}

	public List<Member> getMemberList() {
		return em.createNamedQuery(GET_ALL_DIRECTORS, Member.class)
				.getResultList();
	}

}
