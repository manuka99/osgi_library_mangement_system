package bookspublisher.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bookspublisher.BooksActivator;
import bookspublisher.dao.BooksDao;
import bookspublisher.model.Book;
import bookspublisher.service.BooksService;
import bookspublisher.service.BooksServiceImpl;
import dbpublisher.DBServiceImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Manuka yasas
 *
 */

public class BooksForm extends JFrame {

	private static BooksForm frame;
	private BooksService booksService;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtAuthor;
	private JTextField txtDate;
	private JTextField txtSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BooksForm();
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
	public BooksForm() {

//		check database service active
		if (BooksActivator.dbServiceChecker()) {
			try {
				booksService = new BooksServiceImpl(new DBServiceImpl().getConnection());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please Start Database manager Service",
					"DBPublisher Service Not Found", JOptionPane.OK_OPTION);
			return;
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 520);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Add New Book");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewBook = new JLabel("Add New Book");
		lblAddNewBook.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddNewBook.setForeground(Color.GRAY);
		lblAddNewBook.setBounds(80, 20, 200, 40);
		contentPane.add(lblAddNewBook);

		JLabel lblBookID = new JLabel("Book ID:");
		lblBookID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookID.setForeground(Color.GRAY);
		lblBookID.setBounds(80, 80, 200, 60);
		contentPane.add(lblBookID);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setForeground(Color.GRAY);
		lblName.setBounds(80, 140, 200, 60);
		contentPane.add(lblName);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAuthor.setForeground(Color.GRAY);
		lblAuthor.setBounds(80, 200, 200, 60);
		contentPane.add(lblAuthor);

		JLabel lblPublishedDate = new JLabel("Published Date:");
		lblPublishedDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPublishedDate.setForeground(Color.GRAY);
		lblPublishedDate.setBounds(80, 260, 200, 60);
		contentPane.add(lblPublishedDate);

		JLabel lblSubject = new JLabel("Book Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject.setForeground(Color.GRAY);
		lblSubject.setBounds(80, 320, 200, 60);
		contentPane.add(lblSubject);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(300, 90, 300, 40);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtID);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(300, 150, 300, 40);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtName);

		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(300, 210, 300, 40);
		txtAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtAuthor);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(300, 270, 300, 40);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDate);

		txtSubject = new JTextField();
		txtSubject.setColumns(10);
		txtSubject.setBounds(300, 330, 300, 40);
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtSubject);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(80, 420, 200, 40);
		btnAddBook.setFocusable(true);
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnAddBook);
		btnAddBook.addActionListener(new ActionListener() {
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

				if (!txtName.getText().isEmpty() && !txtAuthor.getText().isEmpty() && !txtDate.getText().isEmpty()
						&& !txtSubject.getText().isEmpty()) {
					Book book = new Book();
					book.setBookID(Integer.parseInt(txtID.getText()));
					book.setName(txtName.getText());
					book.setAuthor(txtAuthor.getText());
					book.setPublishDate(txtDate.getText());
					book.setSubject(txtSubject.getText());

					int i = booksService.storeBook(book);
					if (i > 0) {
						JOptionPane.showMessageDialog(BooksForm.this, "Books added successfully!");
						frame.dispose();

					} else {
						JOptionPane.showMessageDialog(BooksForm.this, "Sorry, unable to save!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter all the book details", "Invalid Book Details",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}