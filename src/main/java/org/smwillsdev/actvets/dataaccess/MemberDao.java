package org.smwillsdev.actvets.dataaccess;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.smwillsdev.actvets.domain.Member;

@Stateless
@Local
public class MemberDao extends BaseDao<Member> {

	@Override
	public Member save(Member ent) {
		return super.save(ent);
	}

	public Member find(Long id) {
		return super.find(Member.class, id);
	}

}
