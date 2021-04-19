/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main_Page {
	
public static void main(String args[] ){
	
	//Creating a JPnael	
	JPanel panel = new JPanel();
	panel.setBorder(new EmptyBorder(2,3,2,3));
	JPanel layout = new JPanel();
	layout.setBorder(new EmptyBorder(5,5,5,5));
	JPanel btnPanel = new JPanel(new GridLayout(50,10,50,10));
	
	/**
	 * Creating a JFrame
	 */
	
	JFrame f = new JFrame("Issue Books");
	f.add(panel);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//f.setSize(100,200);
	//f.setLocation(200,200);
	f.setBounds(200,200,400,300);
	f.setResizable(false);
	//f.setTitle("Issuing Books");
	
	/**
	 * Creating Buttons
	 */
	JButton b1 = new JButton("Issue Books");
	b1.setBounds(50,200,180,30);
	b1.setLayout(null);
	b1.setFont(new Font("Serif", Font.PLAIN, 24));
	btnPanel.add(b1);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Issue_Books.main(new String[] {});
			//dispose();
		}
	});
	
	JButton b2 = new JButton("Return Books");
	b2.setBounds(50,200,180,30);
	b2.setLayout(null);
	b2.setFont(new Font("Serif", Font.PLAIN, 24));
	btnPanel.add(b2);
	b2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Return_Books.main(new String[] {});
			//dispose();
		}
	});
	
	JButton b3 = new JButton("Issue Book List");
	b3.setBounds(50,200,180,30);
	b3.setLayout(null);
	b3.setFont(new Font("Serif", Font.PLAIN, 24));
	btnPanel.add(b3);
	b3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			List_Books.main(new String[] {});
			//dispose();	
		}
	});
	
	JButton b4 = new JButton("Return Book List");
	b4.setBounds(50,200,180,30);
	b4.setLayout(null);
	b4.setFont(new Font("Serif", Font.PLAIN, 24));
	btnPanel.add(b4);
	b4.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			List_Return_Books.main(new String[] {});
			//dispose();	
		}
	});
//	btnPanel.add(new JButton("Return Books"));
//	btnPanel.add(new JButton("Issued Book List"));
	layout.add(btnPanel);
	panel.add(layout, BorderLayout.CENTER);
	
	

	
	}

}
