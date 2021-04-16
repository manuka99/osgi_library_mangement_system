package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

import DB.DBServiceImpl;
import model.StaffMembers;
import staffmemberspublisher.StaffMemberActivator;

public class StaffMembersDaoImpl implements StaffMembersDao{

	public Connection getConnectionFromDBService() {
		Connection con = null;
		if (StaffMemberActivator.dbServiceChecker()) {
			System.out.println("error1");
			try {
				con = new DBServiceImpl().getConnection();
				System.out.println("error2");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please Start Database manager Service",
					"DBPublisher Service Not Found", JOptionPane.OK_OPTION);
		}
		try {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	         } catch (Exception e) {
	            System.out.println(e);
	      }
	      con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdb", "root", " ");
	      System.out.println("Connection is created successfully:");}
	      catch (Exception excep) {
	          excep.printStackTrace();
	       } 
	      return con;
		
}
	
	@Override
	public int save(StaffMembers staff) {
		int status = 0;
		try {
			Connection con = getConnectionFromDBService();
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testingdb", "root", " ");
			status = 1;
			PreparedStatement ps = con
					.prepareStatement("insert into staffMembers(id,name,designation,deaprtment) values(?,?,?,?)");
			ps.setInt(1, staff.getMemberID());
			ps.setString(2, staff.getName());
			ps.setString(3, staff.getDesignation());
			ps.setString(4, staff.getDepartment());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
		}

	
	@Override
	public int update(StaffMembers staff) {
		int status = 0;
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con.prepareStatement(
					"update staffMembers set name = ?, designation = ?, department = ? where id = ?");
			ps.setString(1, staff.getName());
			ps.setString(2, staff.getDesignation());
			ps.setString(3, staff.getDepartment());
			ps.setInt(4, staff.getMemberID());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int delete(int id) {
		int status = 0;
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con.prepareStatement("delete from staffMembers where id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<StaffMembers> getAllStaffMembers() {
		List<StaffMembers> staffs = new ArrayList<>();
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con.prepareStatement("select * from staffMembers");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StaffMembers staff = new StaffMembers();
				staff.setMemberID(rs.getInt(1));
				staff.setName(rs.getString(2));
				staff.setDesignation(rs.getString(3));
				staff.setDepartment(rs.getString(4));
				staffs.add(staff);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffs;	}

	@Override
	public StaffMembers getStaffMemberByID(int id) {
		StaffMembers staff = new StaffMembers();
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con.prepareStatement("select * from staffMembers where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				staff.setMemberID(rs.getInt(1));
				staff.setName(rs.getString(2));
				staff.setDesignation(rs.getString(3));
				staff.setDepartment(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staff;
	}
	
	
}
