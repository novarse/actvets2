package org.smwillsdev.actvets.domain.lookup;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.smwillsdev.actvets.domain.EventDesc;

@Named
@SessionScoped
public class DescriptionList implements Serializable {

	private static final String GET_ACTIVE_DESCRIPTIONS = "getActiveDescriptions";

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private static EntityManager em;

	private static List<EventDesc> descriptions;

	public static List<EventDesc> getDescriptions() {
		System.out.println("descriptions = " + descriptions);
		if (descriptions == null) {
			System.out.println("em = " + em);
			descriptions = em.createNamedQuery(GET_ACTIVE_DESCRIPTIONS,
					EventDesc.class).getResultList();
		}
		return descriptions;
	}

	public static void setDescriptions(List<EventDesc> descriptions) {
		DescriptionList.descriptions = descriptions;
	}

}
