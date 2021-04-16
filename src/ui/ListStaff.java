package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.StaffMembers;
import service.StaffMembersService;
import service.StaffsServiceImpl;

public class ListStaff extends JFrame{
	
	private static ListStaff frame;
	private JPanel contentPane;
	private JTable table;
	private StaffMembersService staffService;

	public static void main(String[] strings) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ListStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	public ListStaff() {

		staffService = new StaffsServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 340);
		setResizable(false);
		setTitle("List all Members");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Data to be displayed in the JTable
		String[][] data = getListMembersToStringArray();

		// Column Names to be displayed in the JTable
		String[] columnNames = { "MemberID", "Name", "Designation", "Department" };

		table = new JTable(data, columnNames);
		JScrollPane sp = new JScrollPane(table);
		contentPane.add(sp, BorderLayout.CENTER);
	}

	public String[][] getListMembersToStringArray() {
		List<StaffMembers> staffs = staffService.listStaffMembers();
		String[][] staffsStringArray = new String[staffs.size()][];

		for (int i = 0; i < staffs.size(); i++) {
			StaffMembers staff = staffs.get(i);
			staffsStringArray[i] = new String[] { String.valueOf(staff.getMemberID()), staff.getName(), staff.getDesignation(),
					staff.getDepartment()};
		}

		return staffsStringArray;
	}


}
