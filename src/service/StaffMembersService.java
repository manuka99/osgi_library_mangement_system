package service;

import java.util.List;

import model.StaffMembers;

public interface StaffMembersService {

	public int storeStaffMembers(StaffMembers staff);

	public int updateStaffMembers(StaffMembers staff);

	public int deleteStaffMembers(int id);

	public List<StaffMembers> listStaffMembers();

	public StaffMembers getStaffMembers(int id);
}
