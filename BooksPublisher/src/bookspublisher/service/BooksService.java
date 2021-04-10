package bookspublisher.service;

import java.util.List;

import bookspublisher.model.Book;

/**
 * @author Manuka yasas
 *
 */
public interface BooksService {
	public int storeBook(Book book);

	public int updateBook(Book book);

	public int deleteBook(int id);

	public List<Book> listBooks();

	public Book getBook(int id);
}
