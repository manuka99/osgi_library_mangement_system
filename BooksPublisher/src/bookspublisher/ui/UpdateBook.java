package bookspublisher.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
public class UpdateBook extends JFrame {

	private static UpdateBook frame;
	private BooksService booksService;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtAuthor;
	private JTextField txtDate;
	private JTextField txtSubject;
	private JLabel lblBookDetails;
	private Book book;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateBook();
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
	public UpdateBook() {

		booksService = new BooksServiceImpl();
		book = new Book();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Update Book");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewBook = new JLabel("Get book details");
		lblAddNewBook.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddNewBook.setForeground(Color.GRAY);
		lblAddNewBook.setBounds(80, 20, 400, 40);
		contentPane.add(lblAddNewBook);

		JLabel lblBookID = new JLabel("Enter Book ID:");
		lblBookID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookID.setForeground(Color.GRAY);
		lblBookID.setBounds(80, 80, 200, 60);
		contentPane.add(lblBookID);

		JButton btnRetrieveBook = new JButton("Retrieve");
		btnRetrieveBook.setBounds(80, 160, 200, 40);
		btnRetrieveBook.setFocusable(true);
		btnRetrieveBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnRetrieveBook);
		btnRetrieveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer.parseInt(txtID.getText());
					if (!(Integer.parseInt(txtID.getText()) > 0)) {
						throw new Exception();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please enter a valid book ID", "Invalid BookID",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				book = booksService.getBook(Integer.parseInt(txtID.getText()));

				lblBookDetails = new JLabel("Update Book details #" + book.getBookID());

				txtName.setText(book.getName());
				txtAuthor.setText(book.getAuthor());
				txtDate.setText(book.getPublishDate());
				txtSubject.setText(book.getSubject());

				if (book.getBookID() == 0)
					JOptionPane.showMessageDialog(null, "Please enter a valid book ID", "No Results",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		lblBookDetails = new JLabel("Update Book details #" + book.getBookID());
		lblBookDetails.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBookDetails.setForeground(Color.GRAY);
		lblBookDetails.setBounds(80, 220, 400, 60);
		contentPane.add(lblBookDetails);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setForeground(Color.GRAY);
		lblName.setBounds(80, 280, 200, 60);
		contentPane.add(lblName);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAuthor.setForeground(Color.GRAY);
		lblAuthor.setBounds(80, 340, 200, 60);
		contentPane.add(lblAuthor);

		JLabel lblPublishedDate = new JLabel("Published Date:");
		lblPublishedDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPublishedDate.setForeground(Color.GRAY);
		lblPublishedDate.setBounds(80, 400, 200, 60);
		contentPane.add(lblPublishedDate);

		JLabel lblSubject = new JLabel("Book Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject.setForeground(Color.GRAY);
		lblSubject.setBounds(80, 460, 200, 60);
		contentPane.add(lblSubject);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(300, 90, 300, 40);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtID);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(300, 290, 300, 40);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtName);

		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(300, 350, 300, 40);
		txtAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtAuthor);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(300, 410, 300, 40);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDate);

		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(300, 470, 300, 40);
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtSubject);

		JButton btnUpdateBook = new JButton("Update");
		btnUpdateBook.setBounds(80, 560, 200, 40);
		btnUpdateBook.setFocusable(true);
		btnUpdateBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnUpdateBook);
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtName.getText().isEmpty() && !txtAuthor.getText().isEmpty() && !txtDate.getText().isEmpty()
						&& !txtSubject.getText().isEmpty()) {
					book.setName(txtName.getText());
					book.setAuthor(txtAuthor.getText());
					book.setPublishDate(txtDate.getText());
					book.setSubject(txtSubject.getText());

					int i = booksService.updateBook(book);
					if (i > 0) {
						JOptionPane.showMessageDialog(UpdateBook.this, "Book was updated successfully!");
					} else {
						JOptionPane.showMessageDialog(UpdateBook.this, "Sorry, unable to save!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter all the book details", "Invalid Book Details",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}