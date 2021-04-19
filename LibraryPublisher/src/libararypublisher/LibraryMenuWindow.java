package libararypublisher;

import bookspublisher.ui.BooksMenuWindow;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import memberpublisher.ui.MembersMenu;

/**
 * @author Manuka yasas
 *
 */
public class LibraryMenuWindow extends JFrame {

	private static LibraryMenuWindow frame;
	private JPanel contentPane;

	private static boolean BooksMenuClick = false;
	private static boolean IssueBooksMenuClick = false;
	private static boolean MembersMenuClick = false;
	private static boolean StaffMenuClick = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibraryMenuWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibraryMenuWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Library management system");
		setBounds(100, 100, 660, 340);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbllibrary = new JLabel("CLEVERX LIBRARY MANAGER");
		lbllibrary.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbllibrary.setForeground(Color.GRAY);
		lbllibrary.setBounds(160, 20, 400, 30);
		contentPane.add(lbllibrary);

//		manage books
		JButton btnBooks = new JButton("Manage books");
		btnBooks.setBounds(80, 80, 220, 60);
		btnBooks.setFocusable(true);
		btnBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnBooks);
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksMenuClick = LibraryActivator.BooksTrackerChecker();
				if (BooksMenuClick == true) {
					BooksMenuWindow obj = new BooksMenuWindow();
					obj.setVisible(true);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please Start Library books Service",
							"Library books Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});

//		borrow books
		JButton btnBorrowBooks = new JButton("Borrow Books");
		btnBorrowBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBorrowBooks.setBounds(340, 80, 220, 60);
		btnBorrowBooks.setFocusable(true);
		contentPane.add(btnBorrowBooks);
		btnBorrowBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

//		manage staff
		JButton btnStaff = new JButton("Manage Staff");
		btnStaff.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStaff.setBounds(80, 180, 220, 60);
		btnStaff.setFocusable(true);
		contentPane.add(btnStaff);
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

//		manage members
		JButton btnMembers = new JButton("Manage Members");
		btnMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMembers.setBounds(340, 180, 220, 60);
		btnMembers.setFocusable(true);
		contentPane.add(btnMembers);
		btnMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MembersMenuClick = LibraryActivator.MembersTrackerChecker();
				if (MembersMenuClick == true) {
					MembersMenu obj = new MembersMenu();
					obj.setVisible(true);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please Start Library members Service",
							"Library members Service Not Found", JOptionPane.OK_OPTION);
				}
			}
		});

	}

}
