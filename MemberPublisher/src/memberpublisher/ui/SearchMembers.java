/**
 * 
 */
package memberpublisher.ui;

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


import memberpublisher.Model.Member;
import memberpublisher.Service.MembersService;
import memberpublisher.Service.MemberServiceImpl;


/**
 * @author Harini
 *
 */
public class SearchMembers extends JFrame {
	
	private static SearchMembers frame;
	private JPanel contentPane;
	private MembersService membersService;
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
	
	//Create Frame
	public SearchMembers() {

		membersService = new MemberServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 340);
		setResizable(false);
		setTitle("Search Books");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Data to be displayed in the JTable
		String[][] data = getListMembersToStringArray();

		// Column Names to be displayed in the JTable
		String[] columnNames = { "MemberID", "Name", "Telephone", "Registerd Date", "City" };

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

	public String[][] getListMembersToStringArray() {
		List<Member> members = membersService.listMembers();
		String[][] membersStringArray = new String[members.size()][];

		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			membersStringArray[i] = new String[] { String.valueOf(member.getMemID()), member.getName(), member.getTel(),
					member.getRegDate(), member.getCity() };
		}

		return membersStringArray;
	}
	
	

}
