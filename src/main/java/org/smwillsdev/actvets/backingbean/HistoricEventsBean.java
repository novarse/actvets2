package org.smwillsdev.actvets.backingbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.smwillsdev.actvets.domain.Event;
import org.smwillsdev.actvets.service.EventService;

@Named
@SessionScoped
public class HistoricEventsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	EventService service;

	public List<Event> getEvents() {
		return service.getHistoricEvents();
	}
}
