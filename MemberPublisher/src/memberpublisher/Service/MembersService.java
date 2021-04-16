/**
 * 
 */
package memberpublisher.Service;

import java.util.List;

import memberpublisher.Model.Member;

/**
 * @author Harini
 *
 */
public interface MembersService {
	
	public int addMember(Member member);

	public int updateMember(Member member);

	public int deleteMember(int id);

	public List<Member> listMembers();

	public Member getMember(int id);

}
