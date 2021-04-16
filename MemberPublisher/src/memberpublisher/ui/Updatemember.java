/**
 * 
 */
package memberpublisher.ui;

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


import memberpublisher.MembersActivator;
import memberpublisher.Model.Member;
import memberpublisher.Service.MembersService;
import memberpublisher.Service.MemberServiceImpl;
import dbpublisher.DBServiceImpl;


/**
 * @author Harini
 *
 */
public class Updatemember extends JFrame {
	
	private static Updatemember frame;
	private MembersService membersService;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtTel;
	private JTextField txtDate;
	private JTextField txtCity;
	private JLabel lblMemberDetails;
	private Member member;
	
	
	
	  //Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Updatemember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Create the frame
	
	public Updatemember() {

		membersService = new MemberServiceImpl();
		member = new Member();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Update Member");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddNewMember = new JLabel("Get Member details");
		lblAddNewMember.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddNewMember.setForeground(Color.GRAY);
		lblAddNewMember.setBounds(80, 20, 400, 40);
		contentPane.add(lblAddNewMember);

		JLabel lblMemID = new JLabel("Enter Member ID:");
		lblMemID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMemID.setForeground(Color.GRAY);
		lblMemID.setBounds(80, 80, 200, 60);
		contentPane.add(lblMemID);

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
					JOptionPane.showMessageDialog(null, "Please enter a valid Member ID", "Invalid Member ID",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				member = membersService.getMember(Integer.parseInt(txtID.getText()));

				lblMemberDetails.setText("Update Member details #" + member.getMemID());

				txtName.setText(member.getName());
				txtTel.setText(member.getTel());
				txtDate.setText(member.getRegDate());
				txtCity.setText(member.getCity());

				if (member.getMemID() == 0)
					JOptionPane.showMessageDialog(null, "Please enter a valid member ID", "No Results",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		lblMemberDetails = new JLabel("Update Member details #" + member.getMemID());
		lblMemberDetails.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMemberDetails.setForeground(Color.GRAY);
		lblMemberDetails.setBounds(80, 220, 400, 60);
		contentPane.add(lblMemberDetails);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setForeground(Color.GRAY);
		lblName.setBounds(80, 280, 200, 60);
		contentPane.add(lblName);

		JLabel lblTel = new JLabel("Telephone:");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTel.setForeground(Color.GRAY);
		lblTel.setBounds(80, 340, 200, 60);
		contentPane.add(lblTel);

		JLabel lblRegDate = new JLabel("Registerd Date:");
		lblRegDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegDate.setForeground(Color.GRAY);
		lblRegDate.setBounds(80, 400, 200, 60);
		contentPane.add(lblRegDate);

		JLabel lblCity = new JLabel("City: ");
		lblCity .setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity .setForeground(Color.GRAY);
		lblCity .setBounds(80, 460, 200, 60);
		contentPane.add(lblCity );

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

		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(300, 350, 300, 40);
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtTel);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(300, 410, 300, 40);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDate);

		txtCity = new JTextField();
		txtCity .setColumns(10);
		txtCity .setBounds(300, 470, 300, 40);
		txtCity .setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtCity );

		JButton btnUpdateMember = new JButton("Update");
		btnUpdateMember .setBounds(80, 560, 200, 40);
		btnUpdateMember .setFocusable(true);
		btnUpdateMember .setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnUpdateMember );
		btnUpdateMember .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtName.getText().isEmpty() && !txtTel.getText().isEmpty() && !txtDate.getText().isEmpty()
						&& !txtCity.getText().isEmpty()) {
					member.setName(txtName.getText());
					member.setTel(txtTel.getText());
					member.setRegDate(txtDate.getText());
					member.setCity(txtCity.getText());

					int i = membersService.updateMember(member);
					if (i > 0) {
						JOptionPane.showMessageDialog(Updatemember.this, "Member was updated successfully!");
					} else {
						JOptionPane.showMessageDialog(Updatemember.this, "Sorry, unable to save!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter all the  details", "Invalid Member Details",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

}
