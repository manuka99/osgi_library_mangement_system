package bookspublisher.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import bookspublisher.model.Book;
import bookspublisher.service.BooksService;
import bookspublisher.service.BooksServiceImpl;
/**
 * @author Manuka yasas
 *
 */
public class SearchBooks extends JFrame {

	private static SearchBooks frame;
	private JPanel contentPane;
	private BooksService booksService;
	private JTextField txtID;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SearchBooks();
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
	public SearchBooks() {

		booksService = new BooksServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 340);
		setResizable(false);
		setTitle("Search Books");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Data to be displayed in the JTable
		String[][] data = getListBooksToStringArray();

		// Column Names to be displayed in the JTable
		String[] columnNames = { "BookID", "Name", "Author", "Published Date", "Subject" };

		TableModel tableModel = new DefaultTableModel(data, columnNames) {
			public Class getColumnClass(int column) {
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};

		final JTable table = new JTable(tableModel);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
		table.setRowSorter(sorter);
		JScrollPane pane = new JScrollPane(table);
		contentPane.add(pane, BorderLayout.CENTER);

		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Filter");
		panel.add(label, BorderLayout.WEST);
		final JTextField filterText = new JTextField("");
		panel.add(filterText, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.NORTH);
		JButton button = new JButton("Filter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = filterText.getText();
				if (text.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}
			}
		});
		contentPane.add(button, BorderLayout.SOUTH);

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