package org.smwillsdev.actvets.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.smwillsdev.actvets.service.EventService;

public class ClientApplicationTest {

	public static void main(String[] args) {
		try {
			Context jndi = new InitialContext();

			EventService service = (EventService) jndi
					.lookup("java:global/actvets/EventService");

		} catch (NamingException e) {
			System.out.println(e);
		}
	}

}
