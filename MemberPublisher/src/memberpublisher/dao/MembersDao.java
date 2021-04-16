package memberpublisher.dao;

import java.util.List;

import memberpublisher.Model.Member;

public interface MembersDao {
	public int save(Member member);

	public int update(Member member);

	public int delete(int id);

	public List<Member> getAllMembers();

	public Member getMemberByID(int id);

	
}
