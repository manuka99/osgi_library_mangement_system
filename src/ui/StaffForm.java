package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.StaffMembers;
import service.StaffMembersService;
import service.StaffsServiceImpl;

public class StaffForm extends JFrame {
	
	private static StaffForm frame;
	private StaffMembersService staffsService;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtDesignation;
	private JTextField txtDepartment;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StaffForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public StaffForm() {
		
		staffsService = new StaffsServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 520);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Add New Staff Member");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddStaffMember = new JLabel("Add New Staff Member");
		lblAddStaffMember.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddStaffMember.setForeground(Color.GRAY);
		lblAddStaffMember.setBounds(80, 20, 400, 40);
		contentPane.add(lblAddStaffMember);

		JLabel lblStaffMemberID = new JLabel("Member ID:");
		lblStaffMemberID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStaffMemberID.setForeground(Color.GRAY);
		lblStaffMemberID.setBounds(80, 80, 200, 60);
		contentPane.add(lblStaffMemberID);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setForeground(Color.GRAY);
		lblName.setBounds(80, 140, 200, 60);
		contentPane.add(lblName);


		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDesignation.setForeground(Color.GRAY);
		lblDesignation.setBounds(80, 200, 200, 60);
		contentPane.add(lblDesignation);

		JLabel lblDepartment = new JLabel("DEpartment : ");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDepartment.setForeground(Color.GRAY);
		lblDepartment.setBounds(80, 260, 200, 60);
		contentPane.add(lblDepartment);

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

		txtDesignation = new JTextField();
		txtDesignation.setColumns(10);
		txtDesignation.setBounds(300, 210, 300, 40);
		txtDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDesignation);

		txtDepartment = new JTextField();
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(300, 270, 300, 40);
		txtDepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDepartment);

		JButton btnAddStaffMember = new JButton("Add Staff Member");
		btnAddStaffMember.setBounds(80, 420, 200, 40);
		btnAddStaffMember.setFocusable(true);
		btnAddStaffMember.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnAddStaffMember);
		btnAddStaffMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer.parseInt(txtID.getText());
					if (!(Integer.parseInt(txtID.getText()) > 0)) {
						throw new Exception();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please enter a valid member ID", "Invalid MemberID",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!txtName.getText().isEmpty() && !txtDesignation.getText().isEmpty() && !txtDepartment.getText().isEmpty()) {
					StaffMembers staff = new StaffMembers();
					staff.setMemberID(Integer.parseInt(txtID.getText()));
					staff.setName(txtName.getText());
					staff.setDesignation(txtDesignation.getText());
					staff.setDepartment(txtDepartment.getText());

					int i = staffsService.storeStaffMembers(staff);
					if (i > 0) {
						JOptionPane.showMessageDialog(StaffForm.this, "Member was saved successfully!");
					} else {
						JOptionPane.showMessageDialog(StaffForm.this, "Sorry, unable to save!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter all the Member details", "Invalid Member Details",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}

}
