/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import issue_books.model.issueBook;
import issue_books.service.IssueBooksService;
import issue_books.service.IssueBooksServiceImpl;

public class List_Return_Books {

		 private JFrame frame;
		 private JTable table;
		 
		    /**
		     * Launch the application.
		     */
		 public static void main(String[] args) {
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                try {
		                	List_Return_Books window = new List_Return_Books();
		                    window.frame.setVisible(true);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		    }
		 

	   /**
	    * Create the application.
	    */
	   public List_Return_Books() {
	       initialize();
	   }

	   /**
	    * Initialize the contents of the frame.
	    */
	   private void initialize() {
	   	
	   	
	       frame = new JFrame("View Return Book List");
	       frame.setBounds(100, 100, 500, 300);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.getContentPane().setLayout(null);


	    	String[][] data = getListBooksToStringArray();

			String[] col = { "BookID", "UserID", "Returned Date"};

			table = new JTable(data, col);
			JScrollPane sp = new JScrollPane(table);
			frame.getContentPane().add(sp, BorderLayout.CENTER);
		}

		public String[][] getListBooksToStringArray() {
			IssueBooksService service = new IssueBooksServiceImpl();
			List<issueBook> books = service.listReturnBooks();
			String[][] booksStringArray = new String[books.size()][];

			for (int i = 0; i < books.size(); i++) {
				issueBook book = books.get(i);
				booksStringArray[i] = new String[] { String.valueOf(book.getBookId()),String.valueOf(book.getUserId()),book.getReturnDate() };
			}

			return booksStringArray;
		}

	}

