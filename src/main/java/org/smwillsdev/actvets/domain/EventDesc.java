package org.smwillsdev.actvets.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.TableGenerator;

@Entity
public class EventDesc implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "Id_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Id_Gen", initialValue = 10000, allocationSize = 10)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Id_Gen")
	private long id;

	private String title;
	@Lob
	private String description;

	private Float distShort;

	private Float distLong;

	// used to display in drop down lists
	private boolean active;

	public EventDesc() {
		active = true;
	}

	public Float getDistShort() {
		return distShort;
	}

	public void setDistShort(Float distShort) {
		this.distShort = distShort;
	}

	public Float getDistLong() {
		return distLong;
	}

	public void setDistLong(Float distLong) {
		this.distLong = distLong;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
