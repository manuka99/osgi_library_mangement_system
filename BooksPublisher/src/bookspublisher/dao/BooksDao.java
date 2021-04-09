package bookspublisher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bookspublisher.model.Book;
import dbpublisher.DBService;

/**
 * @author Manuka yasas
 *
 */

public class BooksDao {
	
	private Connection con;
	
	public BooksDao(Connection con) {
		this.con = con;
	}
	
	public int save(Book book) {
		int status = 0;
		try {
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

}
