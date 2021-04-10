package bookspublisher.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bookspublisher.BooksActivator;
import bookspublisher.service.BooksService;
import bookspublisher.service.BooksServiceImpl;
import dbpublisher.DBServiceImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * @author Manuka yasas
 *
 */
public class DeleteBook extends JFrame {

	private static DeleteBook frame;
	private JPanel contentPane;
	private BooksService booksService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteBook();
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
	public DeleteBook() {

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
		setBounds(100, 100, 660, 320);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Delete Book");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewBook = new JLabel("Delete Book");
		lblAddNewBook.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddNewBook.setForeground(Color.GRAY);
		lblAddNewBook.setBounds(80, 20, 200, 40);
		contentPane.add(lblAddNewBook);

		JLabel lblBookID = new JLabel("Book Id:");
		lblBookID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBookID.setForeground(Color.GRAY);
		lblBookID.setBounds(80, 80, 200, 60);
		contentPane.add(lblBookID);

		JTextField txtBookID = new JTextField();
		txtBookID.setColumns(10);
		txtBookID.setBounds(300, 90, 300, 40);
		txtBookID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtBookID);

		JButton btnDelete = new JButton("Delete book");
		btnDelete.setBounds(80, 180, 200, 40);
		btnDelete.setFocusable(true);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid = txtBookID.getText();
				if (bid == null || bid.trim().equals("")) {
					JOptionPane.showMessageDialog(DeleteBook.this, "Enter a valid Book ID");
				} else {
					int id = Integer.parseInt(bid);
					int i = booksService.deleteBook(id);
					if (i > 0) {
						JOptionPane.showMessageDialog(DeleteBook.this, "Record deleted successfully!");
					} else {
						JOptionPane.showMessageDialog(DeleteBook.this, "Unable to delete the given book");
					}
					frame.dispose();
				}
			}
		});

	}
}
