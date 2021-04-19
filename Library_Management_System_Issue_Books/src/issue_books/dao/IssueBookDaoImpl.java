/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dbpublisher.DBServiceImpl;
import issue_books.IssueBookActivator;
import issue_books.model.issueBook;

public class IssueBookDaoImpl implements IssueBookDao {

	public Connection getConnectionFromDBService() {
		Connection connection = null;
		if(IssueBookActivator.dbServiceChecker()) {
			try {
				connection = new DBServiceImpl().getConnection();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to connect");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Please start DB service", "Not FOund", JOptionPane.OK_OPTION);
		}
		return connection;
		
	}

	@Override
	public int save(issueBook book) {
		int status = 0;
		try {
			Connection connection = getConnectionFromDBService();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO IssueBooks(bookId, userId, period) VALUES (?,?,?)");
			ps.setInt(1, book.getBookId());
			ps.setInt(2, book.getUserId());
			ps.setInt(3, book.getPeriod());
			//ps.setString(4, book.getIssueDate());
			status = ps.executeUpdate();
			connection.close();	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed!");
		}
		return status;
	}
	
	
	@Override
	public int returnBook(issueBook book) {
		int status = 0;
		try {
			Connection connection = getConnectionFromDBService();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO ReturnBooks(bookId, userId, returnDate) VALUES (?,?,?)");
			ps.setInt(1, book.getBookId());
			ps.setInt(2, book.getUserId());
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			ps.setDate(3, sqlDate);
			status = ps.executeUpdate();
			connection.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<issueBook> getIssueBooks() {
		List<issueBook> books = new ArrayList<>();
		try {
			Connection connection = getConnectionFromDBService();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM IssueBooks");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				issueBook book = new issueBook();
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setPeriod(rs.getInt(3));
				book.setIssueDate(rs.getString(4));
				books.add(book);
			}
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<issueBook> getReturnBooks() {
		List<issueBook> books = new ArrayList<>();
		try {
			Connection connection = getConnectionFromDBService();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM ReturnBooks");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				issueBook book = new issueBook();
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setIssueDate(rs.getString(4));
				books.add(book);
			}
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	/**@Override
	public int getDate() {
		int status = 0;
		try {
			Connection connection = getConnectionFromDBService();
			PreparedStatement ps = connection.prepareStatement("SELECT issueDate FROM IssueBooks");
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps1 = connection.prepareStatement("SELECT returnDate FROM ReturnBooks");
			ResultSet rs1 = ps1.executeQuery();
			PreparedStatement ps2 = connection.prepareStatement("select DATEDIFF(rs1, rs) * 24*60*60");
			ResultSet rs2 = ps2.executeQuery();
			status = 
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	
	}**/



}
