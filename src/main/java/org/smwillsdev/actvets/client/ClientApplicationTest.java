package org.smwillsdev.actvets.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.smwillsdev.actvets.domain.Event;
import org.smwillsdev.actvets.service.EventService;

public class ClientApplicationTest {

	public static void main(String[] args) {
		try {
			Context jndi = new InitialContext();

			EventService service = (EventService) jndi
					.lookup("java:global/actvets/EventService");

			Event event = new Event();
			event.setName("Fred");
			service.addEvent(event);

			List<Event> events = service.getAllEvents();

			for (Event e : events) {
				System.out.println("Name = " + e.getName());
			}

		} catch (NamingException e) {
			System.out.println(e);
		}
	}

}
