package ui;

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

public class StaffMenuWindow extends JFrame{
	private static StaffMenuWindow frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StaffMenuWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public StaffMenuWindow() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 420);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Staff management");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbllibrary = new JLabel("STAFF MANAGEMENT");
		lbllibrary.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbllibrary.setForeground(Color.GRAY);
		lbllibrary.setBounds(200, 20, 400, 30);
		contentPane.add(lbllibrary);

		JButton btnNewButton = new JButton("New Staff Member");
		btnNewButton.setBounds(80, 80, 220, 60);
		btnNewButton.setFocusable(true);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffForm.main(new String[] {});
			}
		});

		JButton btnViewAllStaffMembers = new JButton("All Staff Members");
		btnViewAllStaffMembers.setBounds(340, 80, 220, 60);
		btnViewAllStaffMembers.setFocusable(true);
		btnViewAllStaffMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewAllStaffMembers);
		btnViewAllStaffMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListStaff.main(new String[] {});
			}
		});

		JButton btnViewUpdateStaff = new JButton("Update Staff Members");
		btnViewUpdateStaff.setBounds(80, 180, 220, 60);
		btnViewUpdateStaff.setFocusable(true);
		btnViewUpdateStaff.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewUpdateStaff);
		btnViewUpdateStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateStaff.main(new String[] {});
			}
		});

		JButton btnDeleteStaff = new JButton("Delete Staff Members");
		btnDeleteStaff.setBounds(340, 180, 220, 60);
		btnDeleteStaff.setFocusable(true);
		btnDeleteStaff.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnDeleteStaff);
		btnDeleteStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStaff.main(new String[] {});
			}
		});

		JButton btnViewSearchMembers = new JButton("Search Members");
		btnViewSearchMembers.setBounds(80, 280, 220, 60);
		btnViewSearchMembers.setFocusable(true);
		btnViewSearchMembers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnViewSearchMembers);
		btnViewSearchMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMembers.main(new String[] {});
			}
		});

	}

}
