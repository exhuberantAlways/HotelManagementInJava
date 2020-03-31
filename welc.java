import java.io.*;
import javax.swing.*;
import java.awt.*;
//	import java.awt.AWTEvent;
import java.awt.event.*;
import javax.swing.BorderFactory;
public class welc implements ActionListener
{
	     JFrame fr;JPanel pa; 
	    JLabel wel1,wel2,wel3,wel4,wel5;
	     JButton b1,b2,b3,b4,b5;
	     
	     public welc()
	     {
			fr=new JFrame("WELCOME TO HOTEL HOLIDAY INN");
			pa=new JPanel();
			fr.setSize(1400,1400);
			fr.add(pa);
			
			wel1=new JLabel("Welcome");
			wel2=new JLabel(" to");
			wel3=new JLabel(" Hotel");
			wel4=new JLabel(" Holiday");
			wel5=new JLabel(" Inn");

			wel1.setFont(new Font("Serif", Font.BOLD, 40));
			wel2.setFont(new Font("Serif",Font.BOLD,40));
			wel3.setFont(new Font("Serif",Font.BOLD,40));
			wel4.setFont(new Font("Serif",Font.BOLD,40));
			wel5.setFont(new Font("Serif",Font.BOLD,40));
			

			wel1.setForeground(Color.yellow);
			wel2.setForeground(Color.yellow);
			wel3.setForeground(Color.yellow);
			wel4.setForeground(Color.yellow);
			wel5.setForeground(Color.yellow);
			
			JButton b1=new JButton("BOOK ROOMS");
			JButton b2=new JButton("UPDATE BOOKING");
			JButton b3=new JButton("SHOW BOOKING");
			JButton b4=new JButton("DELETE BOOKING");
			JButton b5=new JButton("LOG OUT");
			
			b1.setFont(new Font("Serif",Font.PLAIN,30));
			b2.setFont(new Font("Serif",Font.PLAIN,30));
			b3.setFont(new Font("Serif",Font.PLAIN,30));
			b4.setFont(new Font("Serif",Font.PLAIN,30));
			b5.setFont(new Font("Serif",Font.PLAIN,30));
			
			b1.setFocusPainted(true);
			b2.setFocusPainted(true);
			b3.setFocusPainted(true);
			b4.setFocusPainted(true);
			b5.setFocusPainted(true);
		
			 
			
			b1.setBorder(BorderFactory.createLineBorder(Color.black));
			b2.setBorder(BorderFactory.createLineBorder(Color.black));
			b3.setBorder(BorderFactory.createLineBorder(Color.black));
			b4.setBorder(BorderFactory.createLineBorder(Color.black));
			b5.setBorder(BorderFactory.createLineBorder(Color.black));
		
			b1.setVerticalTextPosition(AbstractButton.BOTTOM);
    			b1.setHorizontalTextPosition(AbstractButton.CENTER);
			b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		               b2.setHorizontalTextPosition(AbstractButton.CENTER);
			b3.setVerticalTextPosition(AbstractButton.BOTTOM);
		               b3.setHorizontalTextPosition(AbstractButton.CENTER);
			b4.setVerticalTextPosition(AbstractButton.BOTTOM);
		               b4.setHorizontalTextPosition(AbstractButton.CENTER);
			b5.setVerticalTextPosition(AbstractButton.BOTTOM);
		               b5.setHorizontalTextPosition(AbstractButton.CENTER);


			pa.setLayout(null);

			 ImageIcon background=new ImageIcon("F:\\Maneet document\\hotelimages\\holiday.jpg");
    			Image img=background.getImage();
		              Image temp=img.getScaledInstance(1400,1147,Image.SCALE_SMOOTH);
   		              background=new ImageIcon(temp);
		             JLabel back=new JLabel(background);
			    back.setLayout(null);
 			   back.setBounds(0,0,1400,1147);

			
			wel1.setBounds(347,498,170,174);
			wel2.setBounds(517,498,90,174);
			wel3.setBounds(607,498,120,174);
			wel4.setBounds(727,498,150,174);
			wel5.setBounds(877,498,100,174);

			b1.setBounds(974,150,300,150);
			b2.setBounds(974,300,300,150);
			b3.setBounds(974,450,300,150);
			b4.setBounds(974,600,300,150);
			b5.setBounds(974,750,300,150);
			
			b1.setForeground(Color.red);
			b2.setForeground(Color.red);
			b3.setForeground(Color.red);
			b4.setForeground(Color.red);	
			b5.setForeground(Color.red);

			b1.setBackground(Color.yellow);
			b2.setBackground(Color.yellow);
			b3.setBackground(Color.yellow);
			b4.setBackground(Color.yellow);
			b5.setBackground(Color.yellow);
			
			b1.setOpaque(true);
			b2.setOpaque(true);
			b3.setOpaque(true);
			b4.setOpaque(true);
			b5.setOpaque(true);

			pa.add(back);
			back.add(wel1);
			back.add(wel2);
			back.add(wel3);
			back.add(wel4);
			back.add(wel5);

			back.add(b1);
			back.add(b2);
			back.add(b3);
			back.add(b4);
			back.add(b5);
			
			fr.setVisible(true);
			fr.setDefaultCloseOperation(2);
			fr.setLocationRelativeTo(null);
			fr.setResizable(false);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);	
			b5.addActionListener(this);
			//b5.setEnabled(true);		

	}
		 public void actionPerformed(ActionEvent evt)
		{		//System.out.println("Helle");
			if(evt.getActionCommand().equals("BOOK ROOMS"))
			{	
				bkroom bk=new bkroom();
				fr.dispose();
			}
			if(evt.getActionCommand()=="UPDATE BOOKING")
			{	
				uproom bk=new uproom();
				fr.dispose();
				
			}
			if(evt.getActionCommand()=="SHOW BOOKING")
			{	
				shroom l=new shroom();
				fr.dispose();
			}
			if(evt.getActionCommand()=="DELETE BOOKING")
			{	
				delroom l=new delroom();
				fr.dispose();
			}
			if(evt.getActionCommand()=="LOG OUT")
			  {
				login l=new login();
				fr.dispose();
				
			  }
		}
		
		  public static void main(String args[])throws Exception
	   	  {
			new welc();
		    }
	}	
		
		
	     
	
