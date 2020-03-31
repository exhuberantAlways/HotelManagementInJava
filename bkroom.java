import java.sql.*;
import java.io.*;
import com.toedter.calendar.*;
import java.lang.String;
import com.toedter.components.JLocaleChooser;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.*;
//import com.toedter.components.JLocaleChooser;

public class bkroom implements ActionListener
{
	JFrame fr;
	JPanel pa;
	JButton reset,book,cancel,gbill;
	JLabel label, l1, l2, l3, l4, l5, l6, l7, l8,l9, l10, l11, l12, l13, l14, l15, l16,l17;
	JTextField t1, t2,t,t10,t11,t12,t13,t14;
	JRadioButton rb1, rb2, rb3, rb4, rb5;
	JComboBox c2, c3, c4, c5, c6, c7;
	JCalendar c;
	ButtonGroup g, g1;
	JLocaleChooser localeChooser;
	JDateChooser dateChooser,dateChooser_1;
	int noOfrooms,noOfday;
	float dis,gst;
	static int c_id=4;
			int r;
	double amt,tar;
	String mst,gender;
	public bkroom() {
		try {
			fr = new JFrame("Hotel Holiday Inn_Room Booking");
			pa = new JPanel();
			fr.setSize(1400, 1400);
			fr.add(pa);

			rb1 = new JRadioButton("FEMALE", true);
			rb2 = new JRadioButton("MALE");
			rb3 = new JRadioButton("OTHER");
			rb4 = new JRadioButton("Single", true);
			rb5 = new JRadioButton("Married");
			g = new ButtonGroup();
			g1 = new ButtonGroup();
			
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);
			rb5.setSelected(false);
			
			g.add(rb1);
			g.add(rb2);
			g.add(rb3);
			g1.add(rb4);
			g1.add(rb5);
			book = new JButton("BookRoom");
			reset = new JButton("RESET");
			cancel=new JButton("RETURN");
			gbill=new JButton("GenerateBill");
			 dateChooser = new JDateChooser();
			 localeChooser = new JLocaleChooser();
			 dateChooser_1 = new JDateChooser();
			

			t1 = new JTextField(20);
			t2 = new JTextField(20);
			t14 = new JTextField(20);
			t = new JTextField(20);
			t10 = new JTextField(20);
			t11 = new JTextField(20);
			t12 = new JTextField(20);
			t13 = new JTextField(20);
			label = new JLabel();
			l1 = new JLabel("Customer Name:");
			l2 = new JLabel("Martial Status:");
			l3 = new JLabel("Gender:");
			l4 = new JLabel("ID Type:");
			l5 = new JLabel("Address:");
			l6 = new JLabel("Nationality:");
			l7 = new JLabel("Check In:");
			l8 = new JLabel("Check Out:");
			l9 = new JLabel("No. of Days:");
			l10 = new JLabel("Room No:");
			l11 = new JLabel("Room Type:");
			l12 = new JLabel("TariffPerRoom:");
			l13 = new JLabel("  GSTperRoom:");
			l14 = new JLabel("No. of rooms:");
			l15 = new JLabel(" Discount:");
			l16 = new JLabel("Net Amount:");
			l17 = new JLabel("Email ID:");
			
			label.setText("<html>(Please enter the Client details:-)<br></html>");
			label.setFont(new Font("Serif", Font.ITALIC, 34));
			l1.setFont(new Font("Serif", Font.PLAIN, 30));
			l2.setFont(new Font("Serif", Font.PLAIN, 30));
			l3.setFont(new Font("Serif", Font.PLAIN, 30));
			l4.setFont(new Font("Serif", Font.PLAIN, 30));
			l5.setFont(new Font("Serif", Font.PLAIN, 30));
			l6.setFont(new Font("Serif", Font.PLAIN, 30));
			l7.setFont(new Font("Serif", Font.PLAIN, 30));
			l8.setFont(new Font("Serif", Font.PLAIN, 30));
			l9.setFont(new Font("Serif", Font.PLAIN, 30));
			l10.setFont(new Font("Serif", Font.PLAIN, 30));
			l11.setFont(new Font("Serif", Font.PLAIN, 30));
			l12.setFont(new Font("Serif", Font.PLAIN, 30));
			l13.setFont(new Font("Serif", Font.PLAIN, 30));
			l14.setFont(new Font("Serif", Font.PLAIN, 30));
			l15.setFont(new Font("Serif", Font.PLAIN, 30));
			l16.setFont(new Font("Serif", Font.PLAIN, 30));
			l17.setFont(new Font("Serif", Font.PLAIN, 30));

			rb1.setFont(new Font("Serif", Font.PLAIN, 30));
			rb2.setFont(new Font("Serif", Font.PLAIN, 30));
			rb3.setFont(new Font("Serif", Font.PLAIN, 30));
			rb4.setFont(new Font("Serif", Font.PLAIN, 30));
			rb5.setFont(new Font("Serif", Font.PLAIN, 30));
			
			reset.setFont(new Font("Serif", Font.PLAIN, 30));
			book.setFont(new Font("Serif", Font.PLAIN, 30));
			cancel.setFont(new Font("Serif", Font.PLAIN, 30));
			gbill.setFont(new Font("Serif", Font.PLAIN, 30));
			
			t1.setFont(new Font("Serif", Font.PLAIN, 30));
			t2.setFont(new Font("Serif", Font.PLAIN, 30));
			
			t.setFont(new Font("Serif", Font.PLAIN, 30));
			t10.setFont(new Font("Serif", Font.PLAIN, 30));
			t11.setFont(new Font("Serif", Font.PLAIN, 30));
			t12.setFont(new Font("Serif", Font.PLAIN, 30));
			t13.setFont(new Font("Serif", Font.PLAIN, 30));
			t14.setFont(new Font("Serif", Font.PLAIN, 30));
			
			t.setHorizontalAlignment(JTextField.CENTER);
			t12.setHorizontalAlignment(JTextField.CENTER);
			
			
			String ID[] = { "Adhar Card", "Passport", "Driving Licence", "Other" };
			String Tariff[] = { "2000", "2700", "3000","3500", "4000", "5000" };
			String Discount[] = { "5", "7", "10" };
			String GST[] = { "12", "15", "18" };
			String RoomNo[] = { "101", "102", "103", "104", "105", "201", "202", "203", "204", "205", "301", "302",
					"303", "304", "305","401", "402", "403", "404", "405", "501", "502", "503", "504", "505", "601", "602",
					"603", "604", "605" };
			String RoomType[] = {"NON-AC/SBed","NON-AC/DBed", "AC/SBed", "AC/DBed","Deluxe Room", "Suite" };

			c2 = new JComboBox(ID);
			c2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			c2.setEditable(true);
			c3 = new JComboBox(Tariff);
			c3.setEditable(true);
			c3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			c4 = new JComboBox(Discount);
			c4.setEditable(true);
			c4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			c5 = new JComboBox(GST);
			c5.setEditable(true);
			c5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			c6 = new JComboBox(RoomNo);
			c6.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			c6.setEditable(true);
			c7 = new JComboBox(RoomType);
			c7.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			c7.setEditable(true);
			localeChooser.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			dateChooser.setFont(new Font("Times New Roman", Font.PLAIN, 24));
			dateChooser_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));

			ImageIcon background = new ImageIcon("F:\\Maneet document\\hotelimages\\room.jpg");
			Image img = background.getImage();
			Image temp = img.getScaledInstance(1447, 1147, Image.SCALE_SMOOTH);
			background = new ImageIcon(temp);
			JLabel back = new JLabel(background);
			back.setLayout(null);
			back.setBounds(0, 0, 1447, 1147);
			//pa.setLayout(null);

			label.setBounds(347, 40, 600, 50);
			l1.setBounds(74, 130, 300, 40);
			t1.setBounds(280, 130, 300, 40);
			l2.setBounds(74, 230, 300, 40);
			t2.setBounds(280, 530, 747, 40);
			l3.setBounds(74, 330, 200, 40);
			
			l4.setBounds(74, 430, 200, 40);
			
			l5.setBounds(74, 530, 200, 40);
			
			l6.setBounds(74, 630, 200, 40);
			localeChooser.setBounds(280, 630, 309, 45);
			localeChooser.setEditable(true);
			l7.setBounds(74, 715, 200, 40);
			dateChooser.setBounds(280, 720, 160, 35);
			
			l8.setBounds(474, 715, 200, 40);
			dateChooser_1.setBounds(648, 720, 160, 35);
			
			l9.setBounds(874, 715, 188, 40);
			t12.setBounds(1062, 715, 150, 40);
			
			l10.setBounds(774, 130, 200, 40);
			l17.setBounds(574, 430, 150, 40);
			t14.setBounds(724, 430, 400, 40);
			l11.setBounds(774, 230, 200, 40);
			c2.setBounds(274, 430, 200, 40);
			l12.setBounds(74, 830, 230, 40);
			c3.setBounds(277, 830, 100, 50);
			c4.setBounds(824, 830, 100, 50);
			c7.setBounds(927, 230, 200, 40);
			l14.setBounds(774, 330, 200, 40);
			c5.setBounds(590, 830, 100, 50);
			l15.setBounds(694, 830, 150, 40);
			c6.setBounds(924, 130, 200, 40);
			rb1.setBounds(280, 330, 150, 40);
			t.setBounds(974, 330, 150, 40);
			rb2.setBounds(430, 330, 120, 40);
			rb3.setBounds(547, 330, 150, 40);
			rb4.setBounds(280, 230, 120, 40);
			rb5.setBounds(400, 230, 120, 40);
			l13.setBounds(384, 830, 200, 40);
			t13.setBounds(1100, 834, 217, 45);
			l16.setBounds(931, 834, 200, 40);
			reset.setBounds(652,920, 200, 40);
			gbill.setBounds(402,920, 250, 40);
			book.setBounds(852,920,200,40);
			cancel.setBounds(1052,920,200,40);
			
			t.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			t14.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			t1.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			t12.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			t2.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			t13.setBorder( BorderFactory.createLineBorder(Color.RED, 3));
			c2.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			c3.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			c4.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			c5.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			c6.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			c7.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			gbill.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			reset.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			book.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			cancel.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			dateChooser.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			localeChooser.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			dateChooser_1.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
			pa.add(back);

			back.add(label);
			back.add(l1);
			back.add(t1);
			back.add(l2);
			back.add(t2);
			back.add(t10);
			back.add(t12);
			back.add(t13);
			back.add(l3);
			back.add(l4);
			back.add(l5);
			back.add(l6);
			back.add(l7);
			back.add(l8);
			back.add(l9);
			back.add(l10);
			back.add(l11);
			back.add(l12);
			back.add(l13);
			back.add(l14);
			back.add(l15);
			back.add(l16);
			back.add(l17);
			
			back.add(rb1);
			back.add(rb2);
			back.add(rb3);
			back.add(rb4);
			back.add(rb5);

			back.add(t);
			back.add(t14);

			back.add(c2);
			back.add(c3);
			back.add(c4);
			back.add(c5);
			back.add(c6);
			back.add(c7);
			back.add(reset);
			back.add(gbill);
			back.add(book);
			back.add(cancel);
			
			back.add(localeChooser);
			back.add(dateChooser);
			back.add(dateChooser_1);
			
			
			
			fr.setVisible(true);
			fr.setDefaultCloseOperation(2);
			fr.setLocationRelativeTo(null);
			fr.setResizable(false);
			 book.addActionListener(this);
			 reset.addActionListener(this);
			 cancel.addActionListener(this);
			 gbill.addActionListener(this);
			 rb1.addActionListener(this);
			 rb2.addActionListener(this);
			 rb3.addActionListener(this);
			 rb4.addActionListener(this);
			 rb5.addActionListener(this);
			 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}
	  
	
	 public void actionPerformed(ActionEvent evt)
		{		
			if(evt.getActionCommand()=="RETURN")
			  {
				
				new welc();
				fr.dispose();
			
			  }
			if(evt.getActionCommand()=="RESET")
			  {  
				 t.setText(null);
				 t1.setText(null);
				 t2.setText(null);
				 t.setText(null);
				 t10.setText(null);
				 t11.setText(null);
				 t12.setText(null);
				 t13.setText(null);
				 t14.setText(null);
				 rb1.setSelected(false);
				 rb2.setSelected(false);
				 rb3.setSelected(false);
				 rb4.setSelected(false);
				 rb5.setSelected(false);
				 c2.setSelectedIndex(0);
				 c3.setSelectedIndex(0); 
				 c4.setSelectedIndex(0);
				 c5.setSelectedIndex(0);
				 c6.setSelectedIndex(0);
				 c7.setSelectedIndex(0);
				 dateChooser.setDate(null);
				 dateChooser_1.setDate(null);
				 localeChooser.setLocale(null);
			
			  }
			 if(evt.getActionCommand()=="Single")
	  			  mst="Single";
	  		  else if(evt.getActionCommand()=="Married")
	  			  mst="Married";
			 if(evt.getActionCommand()=="MALE")
				 gender="MALE";
			 else if(evt.getActionCommand()=="FEMALE")
				 gender="FEMALE";
			 else if(evt.getActionCommand()=="OTHER")
				 gender="OTHER";
				 
			if(evt.getActionCommand()=="GenerateBill")
			  {
				
				tar=Double.parseDouble((String)c3.getSelectedItem());
				System.out.println(tar);
				gst=Float.parseFloat((String)c5.getSelectedItem());
				System.out.println(gst);
				dis=Float.parseFloat((String)c4.getSelectedItem());
				System.out.println(dis);
				noOfday=Integer.parseInt((t12.getText()));
				System.out.println(noOfday);
				
	
				noOfrooms=Integer.parseInt((t.getText()));
				System.out.println(noOfrooms);
				
				amt=tar*(1+(gst*0.01))*(1-(dis*0.01))*noOfrooms*noOfday;
				System.out.println(amt);
				
				//pamt=String.format(("Rs.%lf.2"),amt);
				t13.setText("Rs."+String.valueOf(amt));
			
			  }
		
		
			if(evt.getActionCommand()=="BookRoom")
			  {
				Connection con = null;
				String sql;
				Statement stmt=null;
				//JOptionPane.showMessageDialog(null, "Hekki");
				 try { 
		        	
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?" +"user=root&password=MySql");
		          stmt=con.createStatement();
		           
		          String c_name=t1.getText();
		          int noOfrooms=Integer.parseInt(String.valueOf(t.getText()));
		          String e_id=String.valueOf(t14.getText());
		          String id_type=String.valueOf((String)c2.getSelectedItem());
		          String r_no=String.valueOf(c6.getSelectedItem());
		          String R_type=String.valueOf(c7.getSelectedItem());
		          String nation=String.valueOf(localeChooser.getSelectedItem());
		          String chkin=String.valueOf( dateChooser.getDate());
		          String chkout=String.valueOf(dateChooser_1.getDate());
		          String address=String.valueOf(t2.getText());
		          tar=Double.parseDouble((String)c3.getSelectedItem());
				  gst=Float.parseFloat((String)c5.getSelectedItem());
				  dis=Float.parseFloat((String)c4.getSelectedItem());
				  noOfday=Integer.parseInt((t12.getText()));
				  System.out.println(mst);
				  System.out.println(gender);
				   String q="INSERT INTO `hotel`.`customers` (`c_name`, `id_type`, `r_no`, `e_id`, `r_type`, `nation`, `address`, `chkin`, `chkout`, `tariff`, `gst`, `disc`, `mst`, `noOfR`, `gender`, `netamt`, `noOfdays`)"+
				            " VALUES('"+c_name+"','"+id_type+"','"+r_no+"','"+e_id+"','"+R_type+"','"+nation+"','"+address+"','"+chkin+"','"+chkout+"',"
				            +tar+","+gst+","+dis+",'"+mst+"',"+noOfrooms+",'"+gender+"',"+amt+","+noOfday+")";
				   PreparedStatement pr=con.prepareStatement(q);
	                  //sql.setInt(1,c_id);
	                
	                 
	              r=pr.executeUpdate();
	                  
	                   
				  if(r>0 )
				  {
					  JLabel l=new JLabel("Room Booked Successfully....:-)");
					  UIManager.put("OptionPane.minimumSize",new Dimension(347,147)); 
		        	  l.setFont(new Font("Serif", Font.ITALIC, 32));
		        	  JPanel pane=new JPanel();
		        	  pane.add(l);
		        	  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,30))); 
		        	  JOptionPane.showMessageDialog(null,pane,"",JOptionPane.PLAIN_MESSAGE);
				  }
		        	  else
		        	  { JLabel l=new JLabel("Sorry, Room cannot be Added ..:-(");
					  UIManager.put("OptionPane.minimumSize",new Dimension(347,147)); 
		        	  l.setFont(new Font("Serif", Font.ITALIC, 32));
		        	  JPanel pane=new JPanel();
		        	  pane.add(l);
		        	  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,30))); 
		        	  JOptionPane.showMessageDialog(null,pane,"",JOptionPane.PLAIN_MESSAGE); 
		        	  //JOptionPane.showMessageDialog(null, "Sorry, Room cannot be Added ..:-(");
		        	  }  
		        	  System.out.println("Connection successful");
			          
		      
		     
	        	  pr.close();
		          con.close(); 
	      	  
		        } catch(Exception ee)
			        { ee.printStackTrace();
		        	//System.out.println(ee.getMessage());
			        }
			  }    
			  
		  }    
	 
	
	public static void main(String args[]) throws Exception {
		new bkroom();

	}
}

