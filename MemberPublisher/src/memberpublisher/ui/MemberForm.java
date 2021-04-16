/**
 * 
 */
package memberpublisher.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import memberpublisher.Model.Member;
import memberpublisher.Service.MembersService;
import memberpublisher.Service.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Harini
 *
 */
public class MemberForm extends JFrame {
	private static MemberForm frame;
	private MembersService membersService;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtTel;
	private JTextField txtDate;
	private JTextField txtCity;
	
	// application
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MemberForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the frame
	
	public MemberForm() {

		membersService = new MemberServiceImpl();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 520);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Add New Member");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewMember = new JLabel("Add New Member");
		lblAddNewMember.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAddNewMember.setForeground(Color.GRAY);
		lblAddNewMember.setBounds(80, 20, 200, 40);
		contentPane.add(lblAddNewMember);

		JLabel lblMemID = new JLabel("Member ID:");
		lblMemID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemID.setForeground(Color.GRAY);
		lblMemID.setBounds(80, 80, 200, 60);
		contentPane.add(lblMemID);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setForeground(Color.GRAY);
		lblName.setBounds(80, 140, 200, 60);
		contentPane.add(lblName);

		JLabel lblTel = new JLabel("Telephone:");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTel.setForeground(Color.GRAY);
		lblTel.setBounds(80, 200, 200, 60);
		contentPane.add(lblTel);

		JLabel lblRegDate = new JLabel("Registerd Date:"); 
		lblRegDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegDate.setForeground(Color.GRAY);
		lblRegDate.setBounds(80, 260, 200, 60);
		contentPane.add(lblRegDate);

		JLabel lblCity = new JLabel("City: ");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setForeground(Color.GRAY);
		lblCity.setBounds(80, 320, 200, 60);
		contentPane.add(lblCity);

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

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(300, 210, 300, 40);
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtTel);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(300, 270, 300, 40);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDate);

		txtCity = new JTextField();
		txtCity .setColumns(10);
		txtCity .setBounds(300, 330, 300, 40);
		txtCity .setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtCity);

		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.setBounds(80, 420, 200, 40);
		btnAddMember.setFocusable(true);
		btnAddMember.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnAddMember);
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer.parseInt(txtID.getText());
					if (!(Integer.parseInt(txtID.getText()) > 0)) {
						throw new Exception();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please enter a valid member ID", "Invalid Member ID",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!txtName.getText().isEmpty() && !txtTel.getText().isEmpty() && !txtDate.getText().isEmpty()
						&& !txtCity.getText().isEmpty()) {
					Member member = new Member();
					member.setMemID(Integer.parseInt(txtID.getText()));
					member.setName(txtName.getText());
					member.setTel(txtTel.getText());
					member.setRegDate(txtDate.getText());
					member.setCity(txtCity.getText());

					int i = membersService.addMember(member);
					if (i > 0) {
						JOptionPane.showMessageDialog(MemberForm.this, "Member was saved successfully!");
					} else {
						JOptionPane.showMessageDialog(MemberForm.this, "Sorry, unable to save!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter all the member details", "Invalid Member Details",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}


}
