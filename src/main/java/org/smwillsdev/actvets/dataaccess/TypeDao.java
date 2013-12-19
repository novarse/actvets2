package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.domain.EventType;

@Stateless
@Local
public class TypeDao extends BaseDao<EventType> {

	@Override
	public EventType save(EventType ent) {
		return super.save(ent);
	}

	public EventType find(Long id) {
		return super.find(EventType.class, id);
	}

}
