package org.smwillsdev.actvets.dataaccess;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.domain.Event;

@Stateless
@Local
public class EventDao extends BaseDao<Event> {

	@Override
	public Event save(Event event) {
		System.out.println(event);
		return super.save(event);
	}

	public List<Event> findAll() {
		return em.createNamedQuery("getAllEvents", Event.class).getResultList();
	}

	public List<Event> getFutureEvents() {
		Date date = new Date();
		return em.createNamedQuery("getFutureEvents", Event.class)
				.setParameter("date", date).getResultList();
	}

	public List<Event> getHistoricEvents() {
		Date date = new Date();
		return em.createNamedQuery("getHistoricEvents", Event.class)
				.setParameter("date", date).getResultList();
	}

	public Event getEvent(long id) {
		return em.find(Event.class, id);
	}

}
