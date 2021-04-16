package ui;

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

import model.StaffMembers;
import service.StaffMembersService;
import service.StaffsServiceImpl;

public class UpdateStaff extends JFrame {
	
	private static UpdateStaff frame;
	private StaffMembersService staffService;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtDesignation;
	private JTextField txtDepartment;
	private JLabel lblStaffDetails;
	private StaffMembers staff;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public UpdateStaff() {

		staffService = new StaffsServiceImpl();
		staff = new StaffMembers();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Update Staff Member");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewStaff = new JLabel("Get Member Details");
		lblAddNewStaff.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddNewStaff.setForeground(Color.GRAY);
		lblAddNewStaff.setBounds(80, 20, 400, 40);
		contentPane.add(lblAddNewStaff);

		JLabel lblMemberID = new JLabel("Enter Member ID:");
		lblMemberID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemberID.setForeground(Color.GRAY);
		lblMemberID.setBounds(80, 80, 200, 60);
		contentPane.add(lblMemberID);

		JButton btnRetrieveMember = new JButton("Retrieve");
		btnRetrieveMember.setBounds(80, 160, 200, 40);
		btnRetrieveMember.setFocusable(true);
		btnRetrieveMember.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnRetrieveMember);
		btnRetrieveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer.parseInt(txtID.getText());
					if (!(Integer.parseInt(txtID.getText()) > 0)) {
						throw new Exception();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please enter a valid Member ID", "Invalid MemberID",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				staff = staffService.getStaffMembers(Integer.parseInt(txtID.getText()));

				lblStaffDetails.setText("Update Book details #" + staff.getMemberID());

				txtName.setText(staff.getName());
				txtDesignation.setText(staff.getDesignation());
				txtDepartment.setText(staff.getDepartment());
			

				if (staff.getMemberID() == 0)
					JOptionPane.showMessageDialog(null, "Please enter a valid Member ID", "No Results",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		lblStaffDetails = new JLabel("Update Book details #" + staff.getMemberID());
		lblStaffDetails.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStaffDetails.setForeground(Color.GRAY);
		lblStaffDetails.setBounds(80, 220, 400, 60);
		contentPane.add(lblStaffDetails);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setForeground(Color.GRAY);
		lblName.setBounds(80, 280, 200, 60);
		contentPane.add(lblName);

		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDesignation.setForeground(Color.GRAY);
		lblDesignation.setBounds(80, 340, 200, 60);
		contentPane.add(lblDesignation);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartment.setForeground(Color.GRAY);
		lblDepartment.setBounds(80, 400, 200, 60);
		contentPane.add(lblDepartment);

		

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

		txtDesignation = new JTextField();
		txtDesignation.setColumns(10);
		txtDesignation.setBounds(300, 350, 300, 40);
		txtDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDesignation);

		txtDepartment = new JTextField();
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(300, 410, 300, 40);
		txtDepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDepartment);

		JButton btnUpdateMember = new JButton("Update");
		btnUpdateMember.setBounds(80, 560, 200, 40);
		btnUpdateMember.setFocusable(true);
		btnUpdateMember.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnUpdateMember);
		btnUpdateMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtName.getText().isEmpty() && !txtDesignation.getText().isEmpty() && !txtDepartment.getText().isEmpty()) {
					staff.setName(txtName.getText());
					staff.setDesignation(txtDesignation.getText());
					staff.setDepartment(txtDepartment.getText());
					

					int i = staffService.updateStaffMembers(staff);
					if (i > 0) {
						JOptionPane.showMessageDialog(UpdateStaff.this, "Book was updated successfully!");
					} else {
						JOptionPane.showMessageDialog(UpdateStaff.this, "Sorry, unable to save!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter all the Staff details", "Invalid Staff Details",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}


}
