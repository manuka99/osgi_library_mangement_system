/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.service;

import java.util.List;

import issue_books.dao.IssueBookDaoImpl;
import issue_books.model.issueBook;

public class IssueBooksServiceImpl implements IssueBooksService {
	
	private IssueBookDaoImpl issueBooksDao;
	
	public IssueBooksServiceImpl() {
		issueBooksDao = new IssueBookDaoImpl();
	}

	@Override
	public int issueBooks(issueBook book) {
		return issueBooksDao.save(book);
	}

	@Override
	public List<issueBook> listIssueBooks() {
		return issueBooksDao.getIssueBooks();
	}

	@Override
	public int returnBook(issueBook book) {
		return issueBooksDao.returnBook(book);
	}

	@Override
	public List<issueBook> listReturnBooks() {
		return issueBooksDao.getReturnBooks();
	}

}
