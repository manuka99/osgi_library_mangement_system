/**
 * 
 */
package memberpublisher.ui;

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
 * @author Harini
 *
 */
public class MembersMenu extends JFrame {
	
	private static MembersMenu frame;
	private JPanel contentPane;

	// Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MembersMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the frame
	public MembersMenu() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 420);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Member management");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbllibrary = new JLabel("MEMBER MANAGEMENT");
		lbllibrary.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbllibrary.setForeground(Color.GRAY);
		lbllibrary.setBounds(200, 20, 400, 30);
		contentPane.add(lbllibrary);

		JButton btnNewButton = new JButton("New Member");
		btnNewButton.setBounds(80, 80, 220, 60);
		btnNewButton.setFocusable(true);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberForm.main(new String[] {});
			}
		});

		JButton btnViewAllMembers = new JButton("All Members");
		btnViewAllMembers.setBounds(340, 80, 220, 60);
		btnViewAllMembers.setFocusable(true);
		btnViewAllMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewAllMembers);
		btnViewAllMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListMembers.main(new String[] {});
			}
		});

		JButton btnViewUpdateMembers = new JButton("Update Member");
		btnViewUpdateMembers.setBounds(80, 180, 220, 60);
		btnViewUpdateMembers.setFocusable(true);
		btnViewUpdateMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewUpdateMembers);
		btnViewUpdateMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateMember.main(new String[] {});
			}
		});

		JButton btnDeleteMembers = new JButton("Delete Member");
		btnDeleteMembers.setBounds(340, 180, 220, 60);
		btnDeleteMembers.setFocusable(true);
		btnDeleteMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnDeleteMembers);
		btnDeleteMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteMember.main(new String[] {});
			}
		});

		JButton btnViewSearchMembers = new JButton("Search Members");
		btnViewSearchMembers .setBounds(80, 280, 220, 60);
		btnViewSearchMembers .setFocusable(true);
		btnViewSearchMembers .setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewSearchMembers);
		btnViewSearchMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMembers.main(new String[] {});
			}
		});

	}
	
	
}
