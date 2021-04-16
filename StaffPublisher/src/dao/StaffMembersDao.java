package dao;

import java.util.List;

import model.StaffMembers;

public interface StaffMembersDao {

	public int save(StaffMembers staff);

	public int update(StaffMembers staff);

	public int delete(int id);

	public List<StaffMembers> getAllStaffMembers();

	public StaffMembers getStaffMemberByID(int id);
	
}
