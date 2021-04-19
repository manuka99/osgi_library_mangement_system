/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import issue_books.model.issueBook;
import issue_books.service.IssueBooksService;
import issue_books.service.IssueBooksServiceImpl;


public class Issue_Books {
	 JFrame frame;
	 private JLabel uid;
	 private JLabel bid;
	 private JLabel lperiod;
	// private JLabel ldate;
	 private JTextField userId;
	 private JTextField bookId;
	 private JTextField period;
	 //private JTextField date;
	 private JButton btnissue;
	 
	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	Issue_Books window = new Issue_Books();
	                    window.frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	 
	    /**
	     * Create the application.
	     */
	    public Issue_Books() {
	        initialize();
	    }
	 
	    /**
	     * Initialize the contents of the frame.
	     */
	    private void initialize() {
	    	
	    	IssueBooksService service = new IssueBooksServiceImpl();
	    	
	        frame = new JFrame("Issue Book");
	        frame.setBounds(100, 100, 500, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);
	 
	    
	        /**
	         * User Id
	         */
	        userId = new JTextField();
	        userId.setBounds(150, 28, 50, 25);
	        frame.getContentPane().add(userId);
	        userId.setColumns(10);
        
	        uid = new JLabel("User Id");
	        uid.setBounds(65, 28, 46, 14);
	        uid.setFont(new Font("Serif", Font.PLAIN, 15));
	        frame.getContentPane().add(uid);
	        
	        /**
	         * Book Id
	         */
	       
	        
	        bookId = new JTextField();
	        bookId.setBounds(150, 60, 50, 25);
	        frame.getContentPane().add(bookId);
	        bookId.setColumns(0);
        
	        bid = new JLabel("Book Id");
	        bid.setBounds(65, 60, 46, 14);
	        bid.setFont(new Font("Serif", Font.PLAIN, 13));
	        frame.getContentPane().add(bid);
	        
	        /**
	         * Period
	         */
	        
	        period = new JTextField();
	        period.setBounds(150, 90, 50, 25);
	        frame.getContentPane().add(period);
	        period.setColumns(0);
        
	        lperiod = new JLabel("Period");
	        lperiod.setBounds(65, 90, 46, 14);
	        lperiod.setFont(new Font("Serif", Font.PLAIN, 15));
	        frame.getContentPane().add(lperiod);
	        
	        /**
	         * Date of Issue
	         */
	        
	        //date = new JTextField();
	        //date.setBounds(150, 120, 50, 25);
	        //frame.getContentPane().add(date);
	        //date.setColumns(0);
        
	        //ldate = new JLabel("Date");
	        //ldate.setBounds(65, 120, 46, 14);
	        //ldate.setFont(new Font("Serif", Font.PLAIN, 15));
	        //frame.getContentPane().add(ldate);
	        
	        /**
	         * Button
	         */
	        
	        btnissue = new JButton("Issue ");
	        btnissue.setBounds(160, 190, 200, 40);
	        btnissue.setFocusable(true);
	        btnissue.setFont(new Font("Serif", Font.PLAIN, 24));
	        frame.getContentPane().add(btnissue);
	        btnissue.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!userId.getText().isEmpty() && !bookId.getText().isEmpty() && !period.getText().isEmpty() ) {
						issueBook book = new issueBook();
						book.setBookId(Integer.parseInt(bookId.getText()));
						book.setUserId(Integer.parseInt(userId.getText()));
						book.setPeriod(Integer.parseInt(period.getText()));
						
						int i = service.issueBooks(book);
						if(i>0) {
							JOptionPane.showMessageDialog(bid, Issue_Books.this, "Suceessfully Issued!", i);
						}
						else {
							JOptionPane.showMessageDialog(bid, Issue_Books.this, "Issue Failed!", i);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "All the field Required!", "Fill all the Feilds!", JOptionPane.ERROR_MESSAGE);
					}
					
				}
	        	
	        });
	        
	        
	 

}

}

