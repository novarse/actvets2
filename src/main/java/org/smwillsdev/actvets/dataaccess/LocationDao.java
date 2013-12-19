package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.domain.EventLocation;

@Stateless
@Local
public class LocationDao extends BaseDao<EventLocation> {

	@Override
	public EventLocation save(EventLocation ent) {
		return super.save(ent);
	}

	public EventLocation find(Long id) {
		return super.find(EventLocation.class, id);
	}

}
