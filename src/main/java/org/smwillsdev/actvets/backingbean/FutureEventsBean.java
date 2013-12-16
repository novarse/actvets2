package org.smwillsdev.actvets.backingbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.smwillsdev.actvets.domain.Event;
import org.smwillsdev.actvets.service.EventService;
import org.smwillsdev.actvets.util.Constants;
import org.smwillsdev.actvets.util.Utils;
import org.smwillsdev.actvets.view.util.FacesUtils;

@Named
@SessionScoped
public class FutureEventsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long eventId;

	private Event event;

	@EJB
	EventService service;

	public List<Event> getEvents() {
		return service.getFutureEvents();
	}

	public String eventClicked(Long id) {
		eventId = id;
		if (eventId == null) {
			FacesUtils.displayMessage("No event id given");
			event = null;
		} else {
			if (event == null) {
				event = service.getEvent(eventId);
			} else if (event.getId() != eventId) {
				event = service.getEvent(eventId);
			}
		}
		if (event == null) {
			FacesUtils.displayMessage("Event not found");
		}
		return Constants.FUTURE_EVENT_DETAILS;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getTitle() {
		event.getEventDesc().getDistLong();
		return event == null ? ""
				: event.getEventLocation().getTitle()
						+ " "
						+ event.getEventType().getTitle()
						+ (event.getDirector() != null
								&& event.getDirector().getFullName().length() != 0 ? " ("
								+ event.getDirector().getFullName() + ") "
								: " ") + Utils.getDistStr(event.getEventDesc());
	}

	public String getDate() {
		System.out.println("getDate " + event);
		return event == null ? "" : Constants.getFormatterE_DD_MMM_HH_MM()
				.format(event.getDate());
	}

	public String getDirectorDetails() {
		// Member director = event.getDirector();
		// String dirName = director.getFullName();
		// String result = dirName != null && !dirName.isEmpty() ?
		// "Race Director: "
		// + dirName
		// : "";
		// if (!result.isEmpty()) {
		// result += director.getEmail() != null
		// && !director.getEmail().isEmpty() ? ", "
		// + director.getEmail() : "";
		// result += director.getPhoneHome() != null
		// && !director.getPhoneHome().isEmpty() ? ", "
		// + director.getPhoneHome() : "";
		// }
		return "";// result;
	}

	public MapModel getModel() {
		MapModel model = new DefaultMapModel();
		model.addOverlay(new Marker(new LatLng(event.getEventLocation()
				.getLatitude(), event.getEventLocation().getLongitude()), event
				.getEventLocation().getTitle()));
		return model;
	}

}
