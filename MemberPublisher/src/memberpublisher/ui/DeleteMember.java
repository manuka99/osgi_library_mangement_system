/**
 * 
 */
package memberpublisher.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import memberpublisher.MemberActivator;
import memberpublisher.Service.MembersService;
import memberpublisher.Service.MemberServiceImpl;

import dbpublisher.DBServiceImpl;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * @author Harini
 *
 */
public class DeleteMember extends JFrame {
	
	private static DeleteMember frame;
	private JPanel contentPane;
	private MembersService membersService;
	
	//Launch the application
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the frame
	
	public DeleteMember() {

		membersService = new MemberServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 320);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Delete Member");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewMember = new JLabel("Delete Member");
		lblAddNewMember.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddNewMember.setForeground(Color.GRAY);
		lblAddNewMember.setBounds(80, 20, 200, 40);
		contentPane.add(lblAddNewMember);

		JLabel lblMemID = new JLabel("Member Id:");
		lblMemID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemID.setForeground(Color.GRAY);
		lblMemID.setBounds(80, 80, 200, 60);
		contentPane.add(lblMemID);

		JTextField txtMemID = new JTextField();
		txtMemID.setColumns(10);
		txtMemID.setBounds(300, 90, 300, 40);
		txtMemID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtMemID);

		JButton btnDelete = new JButton("Delete Member");
		btnDelete.setBounds(80, 180, 200, 40);
		btnDelete.setFocusable(true);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer.parseInt(txtMemID.getText());
					if (!(Integer.parseInt(txtMemID.getText()) > 0)) {
						throw new Exception();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please enter a valid member ID", "Invalid Member ID",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int i = membersService.deleteMember(Integer.parseInt(txtMemID.getText()));
				if (i > 0) {
					JOptionPane.showMessageDialog(DeleteMember.this, "Record deleted successfully!");
				} else {
					JOptionPane.showMessageDialog(DeleteMember.this, "Unable to delete the member");
				}

			}
		});

	}

}
