package bookspublisher.service;

import java.util.List;

import bookspublisher.model.Book;

public interface BooksService {
	public int storeBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(String id);
	public List<Book> listBooks();
	public Book getBook(String id);
}
