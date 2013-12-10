package org.smwillsdev.actvets.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.TableGenerator;

import org.smwillsdev.actvets.type.AuState;

@Entity
public class EventLocation implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "Id_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Id_Gen", initialValue = 10000, allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Id_Gen")
	private long id;

	private String title;

	private AuState state;

	@Lob
	private String directions;

	private Float latitude;

	private Float longitude;

	// used to display in drop down lists
	private boolean active;

	public EventLocation() {
		active = true;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof EventLocation && title != null
				&& title.equals(((EventLocation) obj).title);
	}

	@Override
	public int hashCode() {
		return title.hashCode();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AuState getState() {
		return state;
	}

	public void setState(AuState state) {
		this.state = state;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
