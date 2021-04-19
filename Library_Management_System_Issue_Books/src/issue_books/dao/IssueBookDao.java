/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.dao;

import java.util.List;

import issue_books.model.issueBook;

public interface IssueBookDao {

	public int save(issueBook book);
	
	public int returnBook(issueBook book);
	
	//public int delete(int id);
	
	public List<issueBook> getIssueBooks();
	
	public List<issueBook> getReturnBooks();

	//public int getDate();
}
