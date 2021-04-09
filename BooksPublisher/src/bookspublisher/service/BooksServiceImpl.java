package bookspublisher.service;

import java.sql.Connection;
import java.util.List;

import bookspublisher.dao.BooksDao;
import bookspublisher.model.Book;

public class BooksServiceImpl implements BooksService{

	private BooksDao booksDao;
	
	public BooksServiceImpl(Connection con) {
		booksDao = new BooksDao(con);
	}
	
	@Override
	public int storeBook(Book book) {
		return booksDao.save(book);		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
