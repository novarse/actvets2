package org.smwillsdev.actvets.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.smwillsdev.actvets.dataaccess.EventDao;
import org.smwillsdev.actvets.domain.Event;

@Stateless
@Remote
public class EventService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EventDao dao;

	public List<Event> getAllEvents() {
		return dao.findAll();
	}

	public void addEvent(Event event) {
		dao.save(event);
	}

	public List<Event> getFutureEvents() {
		return dao.getFutureEvents();
	}

	public List<Event> getHistoricEvents() {
		return dao.getHistoricEvents();
	}

	public Event getEvent(long id) {
		return dao.find(id);
	}
}
