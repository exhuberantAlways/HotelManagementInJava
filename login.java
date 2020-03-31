import java.io.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.*;

import java.awt.event.*;
public class login implements ActionListener
{
	
	    
	     JFrame fr,frm;JPanel pa; JButton b1,b2;JPasswordField pf;
	     JLabel l1,l2,l3,l4;
	     JTextField t;
	    
	     public login()
	     {
			fr=new JFrame("Hotel Holiday Inn");
			pa=new JPanel();
			fr.setSize(1400,1400);
			
			
			fr.add(pa);
			b1=new JButton("LOGIN");
			pf=new JPasswordField(20);
			pf.setEchoChar('@');
			t=new JTextField(20);

			l1=new JLabel("Enter");
			l2=new JLabel("Enter");
			l4=new JLabel(" Password:");
			l3=new JLabel(" User ID:");

			l1.setFont(new Font("Serif", Font.BOLD, 40));
			l2.setFont(new Font("Serif",Font.BOLD,40));
			l3.setFont(new Font("Serif",Font.BOLD,40));
			l4.setFont(new Font("Serif",Font.BOLD,40));
			t.setFont(new Font("Serif",Font.PLAIN,40));
			pf.setFont(new Font("Serif",Font.PLAIN,40));
			b1.setFont(new Font("Serif",Font.PLAIN,40));

			l1.setForeground(Color.yellow);
			l2.setForeground(Color.yellow);
			l3.setForeground(Color.yellow);
			l4.setForeground(Color.yellow);
			b1.setForeground(Color.red);
			
			pa.setLayout(null);

			 ImageIcon background=new ImageIcon("F:\\Maneet document\\hotelimages\\holiday.jpg");
    			Image img=background.getImage();
		              Image temp=img.getScaledInstance(1447,1147,Image.SCALE_SMOOTH);
   		              background=new ImageIcon(temp);
		             JLabel back=new JLabel(background);
			    back.setLayout(null);
 			   back.setBounds(0,0,1447,1147);

			
			l1.setBounds(390,380,104,100);
			l2.setBounds(394,495,100,100);
			l3.setBounds(494,380,200,100);
			l4.setBounds(494,495,200,100);	
			t.setBounds(747,407,400,74);
			pf.setBounds(747,498,400,74);
			b1.setBounds(847,600,200,100);
			pa.add(back);
			back.add(t);
			back.add(pf);
			back.add(b1);
			back.add(l1);
			back.add(l2);
			back.add(l3);
			back.add(l4);
			fr.setVisible(true);
			fr.setDefaultCloseOperation(2);
			fr.setLocationRelativeTo(null);
			fr.setResizable(false);
			b1.addActionListener(this);
			
			}
		
			public void actionPerformed(ActionEvent evt)
			{	
			 String pwd="hello";
	                            String user="great";
			
			if(evt.getSource()==b1)
			{	
				String s=t.getText().trim();
				String s1=String.valueOf(pf.getPassword());
			
				if((s.equals(user)) && (s1.equals(pwd)))
				{
					new welc();
					fr.dispose();
				}
				
				else if(!(s.equals(user)) && !(s1.equals(pwd)))
				{
					t.setText("");
					pf.setText("");
					 JLabel l=new JLabel("Please Re-enter the correct UserID & Password.");
					  UIManager.put("OptionPane.minimumSize",new Dimension(347,147)); 
		        	  l.setFont(new Font("Serif", Font.ITALIC, 32));
		        	  JPanel pane=new JPanel();
		        	  pane.add(l);
		        	  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,30))); 
		        	  JOptionPane.showMessageDialog(null,pane,"Invalid Entry",JOptionPane.PLAIN_MESSAGE);
				 
				}

				else if(!s.equals(user))
				{
					t.setText("");
				 // JOptionPane.showMessageDialog(frm,"Re-enter the correct UserID.","Wrong User ID",JOptionPane.PLAIN_MESSAGE);
				  JLabel l=new JLabel("Please Re-enter the correct UserID.");
				  UIManager.put("OptionPane.minimumSize",new Dimension(347,147)); 
	        	  l.setFont(new Font("Serif", Font.ITALIC, 32));
	        	  JPanel pane=new JPanel();
	        	  pane.add(l);
	        	  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,30))); 
	        	  JOptionPane.showMessageDialog(null,pane,"Wrong User ID",JOptionPane.PLAIN_MESSAGE);
				}
				else if(!s1.equals(pwd))
				{
					pf.setText("");
				
				 // JOptionPane.showMessageDialog(frm,"Re-enter the correct Password.","Wrong password",JOptionPane.PLAIN_MESSAGE);
					 JLabel l=new JLabel("Please Re-enter the correct Password.");
					  UIManager.put("OptionPane.minimumSize",new Dimension(347,147)); 
		        	  l.setFont(new Font("Serif", Font.ITALIC, 32));
		        	  JPanel pane=new JPanel();
		        	  pane.add(l);
		        	  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,30))); 
		        	  JOptionPane.showMessageDialog(null,pane,"Wrong password",JOptionPane.PLAIN_MESSAGE);
				}
		       	  }
			}
	   public static void main(String args[])throws Exception
	   {
		new login();
		
	    }
	}	
		
	
