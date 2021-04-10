package bookspublisher.service;

import java.sql.Connection;
import java.util.List;

import bookspublisher.dao.BooksDaoImpl;
import bookspublisher.model.Book;

/**
 * @author Manuka yasas
 *
 */
public class BooksServiceImpl implements BooksService {

	private BooksDaoImpl booksDao;

	public BooksServiceImpl() {
		booksDao = new BooksDaoImpl();
	}

	@Override
	public int storeBook(Book book) {
		return booksDao.save(book);
	}

	@Override
	public int updateBook(Book book) {
		return booksDao.update(book);
	}

	@Override
	public int deleteBook(int id) {
		return booksDao.delete(id);
	}

	@Override
	public List<Book> listBooks() {
		return booksDao.getAllBooks();
	}

	@Override
	public Book getBook(int id) {
		return booksDao.getBookByID(id);
	}

}
