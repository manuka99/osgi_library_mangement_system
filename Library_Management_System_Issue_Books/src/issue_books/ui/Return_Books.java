/**
 * Bandara M.H.M.N.D.T.
 * IT19152288
 * 
 */

package issue_books.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import issue_books.model.issueBook;
import issue_books.service.IssueBooksService;
import issue_books.service.IssueBooksServiceImpl;

public class Return_Books {

	 private JFrame frame;
	 private JLabel uid;
	 private JLabel bid;
	 private JTextField userId;
	 private JTextField bookId;
	 private JButton btn ;
	 
	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	Return_Books window = new Return_Books();
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
   public Return_Books() {
       initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
   	
   	IssueBooksService service = new IssueBooksServiceImpl();
   	
       frame = new JFrame("Return Book");
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
        * Button
        */
       
       btn = new JButton("Return");
       btn.setBounds(160, 190, 200, 40);
       btn.setFocusable(true);
       btn.setFont(new Font("Serif", Font.PLAIN, 24));
       frame.getContentPane().add(btn);
       btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!userId.getText().isEmpty() && !bookId.getText().isEmpty() ) {
					issueBook book = new issueBook();
					book.setBookId(Integer.parseInt(bookId.getText()));
					book.setUserId(Integer.parseInt(userId.getText()));
					
					int i = service.issueBooks(book);
					if(i>0) {
						JOptionPane.showMessageDialog(bid, Return_Books.this, "Suceessfully Issued!", i);
					}
					else {
						JOptionPane.showMessageDialog(bid, Return_Books.this, "Issue Failed!", i);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "All the field Required!", "Fill all the Feilds!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
        	
        });
        
       
       

 }
}

