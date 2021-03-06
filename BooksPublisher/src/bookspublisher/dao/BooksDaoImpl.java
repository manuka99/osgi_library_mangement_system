package bookspublisher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bookspublisher.BooksActivator;
import bookspublisher.model.Book;
import dbpublisher.DBServiceImpl;

/**
 * @author Manuka yasas
 *
 */

public class BooksDaoImpl implements BooksDao {

	public Connection getConnectionFromDBService() {
		Connection con = null;
		if (BooksActivator.dbServiceChecker()) {
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

	public int save(Book book) {
		int status = 0;
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con
					.prepareStatement("insert into books(id,name,author,publishDate,subject) values(?,?,?,?,?)");
			ps.setInt(1, book.getBookID());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublishDate());
			ps.setString(5, book.getSubject());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int update(Book book) {
		int status = 0;
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con.prepareStatement(
					"update books set name = ?, author = ?, publishDate = ?, subject = ? where id = ?");
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublishDate());
			ps.setString(4, book.getSubject());
			ps.setInt(5, book.getBookID());
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
			PreparedStatement ps = con.prepareStatement("delete from books where id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con.prepareStatement("select * from books");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookID(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublishDate(rs.getString(4));
				book.setSubject(rs.getString(5));
				books.add(book);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public Book getBookByID(int id) {
		Book book = new Book();
		try {
			Connection con = getConnectionFromDBService();
			PreparedStatement ps = con.prepareStatement("select * from books where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book.setBookID(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublishDate(rs.getString(4));
				book.setSubject(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}
