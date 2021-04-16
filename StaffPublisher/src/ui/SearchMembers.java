package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.StaffMembers;
import service.StaffMembersService;
import service.StaffsServiceImpl;

public class SearchMembers extends JFrame{

	private static SearchMembers frame;
	private JPanel contentPane;
	private StaffMembersService staffService;
	private JTextField txtID;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SearchMembers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SearchMembers() {

		staffService = new StaffsServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 340);
		setResizable(false);
		setTitle("Search Members");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Data to be displayed in the JTable
		String[][] data = getListBooksToStringArray();

		// Column Names to be displayed in the JTable
		String[] columnNames = { "MemberID", "Name", "Designation", "Department" };

		TableModel tableModel = new DefaultTableModel(data, columnNames) {
			public Class getColumnClass(int column) {
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};

		final JTable table = new JTable(tableModel);
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
		table.setRowSorter(sorter);
		JScrollPane pane = new JScrollPane(table);
		contentPane.add(pane, BorderLayout.CENTER);

		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Filter");
		panel.add(label, BorderLayout.WEST);
		final JTextField filterText = new JTextField("");
		panel.add(filterText, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.NORTH);
		JButton button = new JButton("Filter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = filterText.getText();
				if (text.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}
			}
		});
		contentPane.add(button, BorderLayout.SOUTH);

	}

	public String[][] getListBooksToStringArray() {
		List<StaffMembers> staff = staffService.listStaffMembers();
		String[][] membersStringArray = new String[staff.size()][];

		for (int i = 0; i < staff.size(); i++) {
			StaffMembers staffs = staff.get(i);
			membersStringArray[i] = new String[] { String.valueOf(staffs.getMemberID()), staffs.getName(), staffs.getDesignation(),
					staffs.getDepartment()};
		}

		return membersStringArray;
	}

}
