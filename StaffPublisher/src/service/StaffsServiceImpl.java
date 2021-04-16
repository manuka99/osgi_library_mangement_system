package service;

import java.util.List;

import dao.StaffMembersDaoImpl;
import model.StaffMembers;

public class StaffsServiceImpl implements StaffMembersService {

	private StaffMembersDaoImpl staffDao;
	
	
	public StaffsServiceImpl() {
		staffDao = new StaffMembersDaoImpl();
	}

	@Override
	public int storeStaffMembers(StaffMembers staff) {
		return staffDao.save(staff);
	}

	@Override
	public int updateStaffMembers(StaffMembers staff) {
		return staffDao.update(staff);
	}

	@Override
	public int deleteStaffMembers(int id) {
		return staffDao.delete(id);	}

	@Override
	public List<StaffMembers> listStaffMembers() {
		return staffDao.getAllStaffMembers();	}

	@Override
	public StaffMembers getStaffMembers(int id) {
		return staffDao.getStaffMemberByID(id);
	}

}
