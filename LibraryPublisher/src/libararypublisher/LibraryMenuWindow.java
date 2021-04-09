package libararypublisher;

import bookspublisher.ui.BooksMenuWindow;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.activation.Activator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LibraryMenuWindow extends JFrame {
	
	private JPanel contentPane;
	private JButton btnAdd;
	
	private static boolean BooksMenuClick = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryMenuWindow frame = new LibraryMenuWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibraryMenuWindow() {
		setResizable(false);
		setTitle("Library management system");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 600, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdd = new JButton("Library books");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooksMenuClick = LibraryActivator.BooksTrackerChecker();
				if (BooksMenuClick == true) {
					BooksMenuWindow obj = new BooksMenuWindow();
					obj.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Please Start Addition Service",
							"Addition Service Not Found", JOptionPane.OK_OPTION);
				}

			}
		});
		btnAdd.setBounds(23, 80, 225, 60);
		contentPane.add(btnAdd);
	}
	
}
