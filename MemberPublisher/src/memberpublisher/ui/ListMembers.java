/**
 * 
 */
package memberpublisher.ui;

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


import memberpublisher.MemberActivator;
import memberpublisher.Model.Member;
import memberpublisher.Service.MembersService;
import memberpublisher.Service.MemberServiceImpl;
import dbpublisher.DBServiceImpl;

/**
 * @author Harini
 *
 */
public class ListMembers extends JFrame {
	
	private static ListMembers frame;
	private JPanel contentPane;
	private JTable table;
	private MembersService membersService;
	
// Launching
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ListMembers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
// create frame
	public ListMembers() {

		membersService = new MemberServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 340);
		setResizable(false);
		setTitle("List all Books");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Data to be displayed in the JTable
		String[][] data = getListMembersToStringArray();

		// Column Names to be displayed in the JTable
		String[] columnNames = { "MemID", "Name", "Telephone", "Reg Date", "City" };

		table = new JTable(data, columnNames);
		JScrollPane sp = new JScrollPane(table);
		contentPane.add(sp, BorderLayout.CENTER);
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
