package bookspublisher.service;

import java.sql.Connection;
import java.util.List;

import bookspublisher.dao.BooksDao;
import bookspublisher.model.Book;

/**
 * @author Manuka yasas
 *
 */
public class BooksServiceImpl implements BooksService {

	private BooksDao booksDao;

	public BooksServiceImpl(Connection con) {
		booksDao = new BooksDao(con);
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
