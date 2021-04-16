package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.StaffMembersService;
import service.StaffsServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteStaff extends JFrame{

	private static DeleteStaff frame;
	private JPanel contentPane;
	private StaffMembersService staffService;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	}

	
	public DeleteStaff() {

		staffService = new StaffsServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 320);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Delete Member");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDeleteNewMember = new JLabel("Delete Member");
		lblDeleteNewMember.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDeleteNewMember.setForeground(Color.GRAY);
		lblDeleteNewMember.setBounds(80, 20, 200, 40);
		contentPane.add(lblDeleteNewMember);

		JLabel lblMemberID = new JLabel("Member Id:");
		lblMemberID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemberID.setForeground(Color.GRAY);
		lblMemberID.setBounds(80, 80, 200, 60);
		contentPane.add(lblMemberID);

		JTextField txtMemberID = new JTextField();
		txtMemberID.setColumns(10);
		txtMemberID.setBounds(300, 90, 300, 40);
		txtMemberID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtMemberID);

		JButton btnDelete = new JButton("Delete Member");
		btnDelete.setBounds(80, 180, 200, 40);
		btnDelete.setFocusable(true);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer.parseInt(txtMemberID.getText());
					if (!(Integer.parseInt(txtMemberID.getText()) > 0)) {
						throw new Exception();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please enter a valid Member ID", "Invalid MemberID",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int i = staffService.deleteStaffMembers(Integer.parseInt(txtMemberID.getText()));
				if (i > 0) {
					JOptionPane.showMessageDialog(DeleteStaff.this, "Record deleted successfully!");
				} else {
					JOptionPane.showMessageDialog(DeleteStaff.this, "Unable to delete the given book");
				}

			}
		});

	}
}
