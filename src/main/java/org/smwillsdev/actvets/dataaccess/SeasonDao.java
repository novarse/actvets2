package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.domain.EventSeason;

@Stateless
@Local
public class SeasonDao extends BaseDao<EventSeason> {

	@Override
	public EventSeason save(EventSeason ent) {
		return super.save(ent);
	}

	public EventSeason find(Long id) {
		return super.find(EventSeason.class, id);
	}

}
