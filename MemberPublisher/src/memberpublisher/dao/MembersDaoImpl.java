 /**
 * 
 */
package memberpublisher.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import memberpublisher.Activator;
import memberpublisher.Model.Member;
import dbpublisher.DBServiceImpl;

/**
 * @author Harini
 *
 */
public class MembersDaoImpl {
	
	public class MemberDaoImpl implements MembersDao {

		public Connection getConnectionFromDBService() {
			Connection con = null;
			if (MemberActivator.dbServiceChecker()) {
				try {
					con = new DBServiceImpl().getConnection();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please Start Database manager Service",
						"DBPublisher Service Not Found", JOptionPane.OK_OPTION);
			}
			return con;
		}

		public int save(Member member) {
			int status = 0;
			try {
				Connection con = getConnectionFromDBService();
				PreparedStatement ps = con
						.prepareStatement("insert into members(id,name,tel, regDate,city) values(?,?,?,?,?)");
				ps.setInt(1, member.getMemID());
				ps.setString(2, member.getName());
				ps.setString(3, member.getTel());
				ps.setString(4, member.getRegDate());
				ps.setString(5, member.getCity());
				status = ps.executeUpdate();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

		public int update(Member member) {
			int status = 0;
			try {
				Connection con = getConnectionFromDBService();
				PreparedStatement ps = con.prepareStatement(
						"update members set name = ?, tel = ?, RegDate = ?, city= ? where id = ?");
				ps.setString(1, member.getName());
				ps.setString(2, member.getTel());
				ps.setString(3, member.getRegDate());
				ps.setString(4, member.getCity());
				ps.setInt(5, member.getMemID());
				status = ps.executeUpdate();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

		public int delete(int id) {
			int status = 0;
			try {
				Connection con = getConnectionFromDBService();
				PreparedStatement ps = con.prepareStatement("delete from members where id = ?");
				ps.setInt(1, id);
				status = ps.executeUpdate();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

		public List<Member> getAllMembers() {
			List<Member> members = new ArrayList<>();
			try {
				Connection con = getConnectionFromDBService();
				PreparedStatement ps = con.prepareStatement("select * from members");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Member member = new Member();
					member.setMemID(rs.getInt(1));
					member.setName(rs.getString(2));
					member.setTel(rs.getString(3));
					member.setRegDate(rs.getString(4));
					member.setCity(rs.getString(5));
					members.add(member);
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return members;
		}

		public Member getMemberByID(int id) {
			Member member = new Member();
			try {
				Connection con = getConnectionFromDBService();
				PreparedStatement ps = con.prepareStatement("select * from members where id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					member.setMemID(rs.getInt(1));
					member.setName(rs.getString(2));
					member.setTel(rs.getString(3));
					member.setRegDate(rs.getString(4));
					member.setCity(rs.getString(5));
				}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return member;
		}


}
