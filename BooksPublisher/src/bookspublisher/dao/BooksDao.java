package bookspublisher.dao;

import java.util.List;

import bookspublisher.model.Book;
/**
 * @author Manuka yasas
 *
 */
public interface BooksDao {
	public int save(Book book);

	public int update(Book book);

	public int delete(int id);

	public List<Book> getAllBooks();

	public Book getBookByID(int id);
}
