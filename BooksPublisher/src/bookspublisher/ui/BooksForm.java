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

public class BooksForm extends JFrame {
	static BooksForm frame;

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

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblAddBooks = new JLabel("Add Books");
		lblAddBooks.setForeground(Color.GRAY);
		lblAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblBookID = new JLabel("Book ID:");

		JLabel lblName = new JLabel("Name:");

		JLabel lblAuthor = new JLabel("Author:");

		JLabel lblPublishedDate = new JLabel("Published Date:");

		JLabel lblSubject = new JLabel("Book Subject");

		txtID = new JTextField();
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);

		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);

		txtDate = new JTextField();
		txtDate.setColumns(10);

		txtSubject = new JTextField();
		txtSubject.setColumns(10);

		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
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
				}else {
					JOptionPane.showMessageDialog(null, "Please enter all the book details", "Invalid Book Details",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnBack = new JButton("Back");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(150).addComponent(lblAddBooks))
								.addGroup(gl_contentPane
										.createSequentialGroup().addGap(
												18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 37,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblBookID)
												.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 37,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPublishedDate, GroupLayout.DEFAULT_SIZE, 67,
														Short.MAX_VALUE)
												.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 55,
														GroupLayout.PREFERRED_SIZE))
										.addGap(47)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtSubject, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtAuthor, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 167,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addGap(161)
								.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(359, Short.MAX_VALUE)
						.addComponent(btnBack).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblAddBooks).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblBookID).addComponent(
						txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(
						txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblAuthor).addComponent(
						txtAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblPublishedDate).addComponent(txtDate,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblSubject).addComponent(
						txtSubject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30).addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBack)
				.addContainerGap(53, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}