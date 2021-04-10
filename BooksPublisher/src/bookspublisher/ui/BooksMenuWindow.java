package bookspublisher.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Manuka yasas
 *
 */
public class BooksMenuWindow extends JFrame {
	private static BooksMenuWindow frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BooksMenuWindow();
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
	public BooksMenuWindow() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 420);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Books management");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbllibrary = new JLabel("BOOKS MANAGEMENT");
		lbllibrary.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbllibrary.setForeground(Color.GRAY);
		lbllibrary.setBounds(200, 20, 400, 30);
		contentPane.add(lbllibrary);

		JButton btnNewButton = new JButton("New Book");
		btnNewButton.setBounds(80, 80, 220, 60);
		btnNewButton.setFocusable(true);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksForm.main(new String[] {});
				frame.dispose();
			}
		});

		JButton btnViewAllBooks = new JButton("All Books");
		btnViewAllBooks.setBounds(340, 80, 220, 60);
		btnViewAllBooks.setFocusable(true);
		btnViewAllBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewAllBooks);
		btnViewAllBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListBooks.main(new String[] {});
				frame.dispose();
			}
		});

		JButton btnViewUpdateBooks = new JButton("Update Books");
		btnViewUpdateBooks.setBounds(80, 180, 220, 60);
		btnViewUpdateBooks.setFocusable(true);
		btnViewUpdateBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewUpdateBooks);
		btnViewUpdateBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setBounds(340, 180, 220, 60);
		btnDeleteBook.setFocusable(true);
		btnDeleteBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnDeleteBook);
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBook.main(new String[] {});
				frame.dispose();
			}
		});

		JButton btnViewSearchBooks = new JButton("Search Books");
		btnViewSearchBooks.setBounds(80, 280, 220, 60);
		btnViewSearchBooks.setFocusable(true);
		btnViewSearchBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewSearchBooks);
		btnViewSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

	}
}
