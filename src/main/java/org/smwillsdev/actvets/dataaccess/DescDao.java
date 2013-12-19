package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.domain.EventDesc;

@Stateless
@Local
public class DescDao extends BaseDao<EventDesc> {

	@Override
	public EventDesc save(EventDesc ent) {
		return super.save(ent);
	}

	public EventDesc find(Long id) {
		return super.find(EventDesc.class, id);
	}

}
