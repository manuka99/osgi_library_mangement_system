/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.service;

import java.util.List;

import issue_books.model.issueBook;

public interface IssueBooksService {

	public int issueBooks(issueBook book);
	
	public int returnBook(issueBook book);
	
	public List<issueBook> listIssueBooks();
	
	public List<issueBook> listReturnBooks();
}
