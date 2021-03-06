/**
 * 
 */
package memberpublisher.Service;

import java.sql.Connection;
import java.util.List;

import memberpublisher.dao.MemberDaoImpl;
import memberpublisher.Model.Member;

/**
 * @author Harini
 *
 */
public class MemberServiceImpl implements MembersService {

	private MemberDaoImpl membersDao;

	public MemberServiceImpl() {
		membersDao = new MemberDaoImpl();
	}

	@Override
	public int addMember(Member member) {
		return membersDao.save(member);
	}

	@Override
	public int updateMember(Member member) {

		return membersDao.update(member);
	}

	@Override
	public int deleteMember(int id) {
		return membersDao.delete(id);
	}

	@Override
	public List<Member> listMembers() {

		return membersDao.getAllMembers();
	}

	@Override
	public Member getMember(int id) {

		return membersDao.getMemberByID(id);
	}

}
