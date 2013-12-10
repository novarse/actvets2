package org.smwillsdev.actvets.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "Id_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Id_Gen", initialValue = 10000, allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Id_Gen")
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne
	private EventDesc eventDesc;

	@ManyToOne
	private EventType eventType;

	@ManyToOne
	private EventLocation eventLocation;

	@ManyToOne
	private EventSeason eventSeason;

	@ManyToOne
	private Member director;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EventDesc getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(EventDesc eventDesc) {
		this.eventDesc = eventDesc;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public EventLocation getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(EventLocation eventLocation) {
		this.eventLocation = eventLocation;
	}

	public EventSeason getEventSeason() {
		return eventSeason;
	}

	public void setEventSeason(EventSeason eventSeason) {
		this.eventSeason = eventSeason;
	}

	public Member getDirector() {
		return director;
	}

	public void setDirector(Member director) {
		this.director = director;
	}

}
