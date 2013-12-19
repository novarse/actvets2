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
	public Event save(Event ent) {
		return super.save(ent);
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

	public Event find(Long id) {
		return super.find(Event.class, id);
	}

}
