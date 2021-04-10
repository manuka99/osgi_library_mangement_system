package bookspublisher.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import bookspublisher.BooksActivator;
import bookspublisher.model.Book;
import bookspublisher.service.BooksService;
import bookspublisher.service.BooksServiceImpl;
import dbpublisher.DBServiceImpl;

/**
 * @author Manuka yasas
 *
 */
public class ListBooks extends JFrame {

	private static ListBooks frame;
	private JPanel contentPane;
	private JTable table;
	private BooksService booksService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ListBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListBooks() {

		booksService = new BooksServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 340);
		setResizable(false);
		setTitle("List all Books");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Data to be displayed in the JTable
		String[][] data = getListBooksToStringArray();

		// Column Names to be displayed in the JTable
		String[] columnNames = { "BookID", "Name", "Author", "Published Date", "Subject" };

		table = new JTable(data, columnNames);
		JScrollPane sp = new JScrollPane(table);
		contentPane.add(sp, BorderLayout.CENTER);
	}

	public String[][] getListBooksToStringArray() {
		List<Book> books = booksService.listBooks();
		String[][] booksStringArray = new String[books.size()][];

		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			booksStringArray[i] = new String[] { String.valueOf(book.getBookID()), book.getName(), book.getAuthor(),
					book.getPublishDate(), book.getSubject() };
		}

		return booksStringArray;
	}

}
