import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font; 
import javax.swing.plaf.FontUIResource;

;public class uproom extends JFrame implements ActionListener//,TableModelListener 
{	
	
	JPanel p,p1; 
	JTable t;
	JScrollPane s;
	JButton b,m;
	JTableHeader th;
	ResultSet rs;
	ResultSetMetaData rsmd;
	int numberOfColumns;
	int rm;
	DefaultTableModel model;
	PreparedStatement  ps;
	public uproom()
	{
		super("Customer records: ");
		
		setSize(1900,900);
		p=new JPanel();
		p1=new JPanel();
		 t=new JTable() {public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex) {
		        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
		        if (rowIndex % 2 == 0 && !isCellSelected(rowIndex, vColIndex)) {
		          c.setBackground(Color.white);
		        } else {
		          c.setBackground(Color.cyan);
		        }
		        return c;
	      }
	    };
		
		 try {
      	  Connection con = null;
      	  rs=null;
      	    Class.forName("com.mysql.cj.jdbc.Driver");
	          con = DriverManager.getConnection("jdbc:mysql://localhost/hotel?" +"user=root&password=MySql");
	       	         //String query=("SELECT * FROM customers");
	          ps=con.prepareStatement("SELECT * FROM customers");
	         rs=ps.executeQuery();
	         
	         
	         model =(DefaultTableModel)t.getModel();
	         model.setColumnIdentifiers(new String[]{"C_Id","C_name","IDType", "RoomNo.","EmailID","RoomType",
	        		 "Nationality","Address", "CheckIn","CheckOut","Tariff","GST","Disc.","M/S","No/Rooms","Gender","NetAmt","No/Ds"}); 
	        	 while(rs.next()){
	        		 model.addRow( new Object[] { rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
		                		rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11), 
		                		rs.getFloat(12),rs.getFloat(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getDouble(17),rs.getInt(18)});
	        	 }
	           
	             t.setModel(model);
	             t.setEnabled(true);
	            
	             t.setPreferredScrollableViewportSize(new Dimension(1847, 400));
	            // p.setLayout(new GridLayout(1,1));
	            
	             t.setAutoCreateColumnsFromModel(false);
	           
	             TableColumn col = t.getColumnModel().getColumn(0);
	             col.setMinWidth(70);
	             col.setMaxWidth(70);
	             col.setPreferredWidth(70);
	             TableColumn col1 = t.getColumnModel().getColumn(1);
	             col1.setMinWidth(170);
	             col1.setMaxWidth(170);
	             col1.setPreferredWidth(170);
	             TableColumn col2 = t.getColumnModel().getColumn(2);
	             col2.setMinWidth(147);
	             col2.setMaxWidth(147);
	             col2.setPreferredWidth(147);
	             TableColumn col3 = t.getColumnModel().getColumn(3);
	             col3.setMinWidth(120);
	             col3.setMaxWidth(120);
	             col3.setPreferredWidth(120);
	             TableColumn col4 = t.getColumnModel().getColumn(4);
	             col4.setMinWidth(200);
	             col4.setMaxWidth(200);
	             col4.setPreferredWidth(200);
	           
	             TableColumn col5 = t.getColumnModel().getColumn(5);
	             col5.setMinWidth(170);
	             col5.setMaxWidth(170);
	             col5.setPreferredWidth(170);
	             TableColumn col6 = t.getColumnModel().getColumn(6);
	             col6.setMinWidth(170);
	             col6.setMaxWidth(170);
	             col6.setPreferredWidth(170);
	             TableColumn col7 = t.getColumnModel().getColumn(7);
	             col7.setMinWidth(320);
	             col7.setMaxWidth(350);
	             col7.setPreferredWidth(320);
	             TableColumn col8 = t.getColumnModel().getColumn(8);
	             col8.setMinWidth(270);
	             col8.setMaxWidth(270);
	             col8.setPreferredWidth(270);
	             
	             TableColumn col9 = t.getColumnModel().getColumn(9);
	             col9.setMinWidth(270);
	             col9.setMaxWidth(270);
	             col9.setPreferredWidth(270);
	             TableColumn col10 = t.getColumnModel().getColumn(10);
	             col10.setMinWidth(130);
	             col10.setMaxWidth(130);
	             col10.setPreferredWidth(130);
	             TableColumn col11 = t.getColumnModel().getColumn(11);
	             col11.setMinWidth(90);
	             col11.setMaxWidth(90);
	             col11.setPreferredWidth(90);

	             TableColumn col12 = t.getColumnModel().getColumn(12);
	             col12.setMinWidth(90);
	             col12.setMaxWidth(90);
	             col12.setPreferredWidth(90);
	             TableColumn col13 = t.getColumnModel().getColumn(13);
	             col13.setMinWidth(110);
	             col13.setMaxWidth(110);
	             col13.setPreferredWidth(110);
	             TableColumn col14 = t.getColumnModel().getColumn(14);
	             col14.setMinWidth(130);
	             col14.setMaxWidth(130);
	             col14.setPreferredWidth(130);
	           
	             TableColumn col15 = t.getColumnModel().getColumn(15);
	             col15.setMinWidth(90);
	             col15.setMaxWidth(90);
	             col15.setPreferredWidth(90);
	             TableColumn col16 = t.getColumnModel().getColumn(16);
	             col16.setMinWidth(110);
	             col16.setMaxWidth(110);
	             col16.setPreferredWidth(110);
	             TableColumn col17 = t.getColumnModel().getColumn(17);
	             col17.setMinWidth(70);
	             col17.setMaxWidth(70);
	             col17.setPreferredWidth(70);
	            /* TableColumn col18 = t.getColumnModel().getColumn(18);
	             col18.setMinWidth(60);
	             col18.setMaxWidth(60);
	             col18.setPreferredWidth(60);
	           */  
	             t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	             t.getTableHeader().setReorderingAllowed(false);
	   //  t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    
	             //t.setAutoscrolls(true);
	             t.setCellSelectionEnabled(true);
	    
	         con.close();
	         rs.close();    
		 }
		 catch(Exception e )
		 {
			 System.out.println("error "+e.getMessage());
		 }
	    t.setRowHeight(33);
		t.setRowMargin(-3);
		th=t.getTableHeader();
		th.setBackground(Color.yellow);
		
		th.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		t.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		t.setForeground(Color.RED);
		s=new JScrollPane(t);
		 s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		 
		s.setViewportView(t);
		t.setRowSelectionAllowed(true);
		t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		t.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		p.add(s,BorderLayout.CENTER);
		validate();
		b=new JButton("RETURN");
		m=new JButton("UPDATE");
		b.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		b.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
		m.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		m.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
		b.setVisible(true);
		m.setVisible(true);
		b.addActionListener(this);
		m.addActionListener(this);
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		p.setBackground(Color.WHITE);
		p1.setBackground(Color.green);
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		p1.add(b);p1.add(m);
		add(p);
		add(p1,BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	/*t.getModel().addTableModelListener(new TableModelListener()
	{

	      public void tableChanged(TableModelEvent e) {
	         // your code goes here;
	      }
	    }*/
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand()=="RETURN")
		{
			dispose();
			new welc();
		}
	
	 
		 if(evt.getActionCommand()=="UPDATE")
			{
			     Connection con = null;
				 String q;
				 PreparedStatement sql;
				//JOptionPane.showMessageDialog(null, "Hekki");
				 try { 
		        	
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?" +"user=root&password=MySql");
		        int r=t.getRowCount();
				for(int i=1;i<=r;i++)
				{
				  int idcustomers=Integer.parseInt(t.getValueAt(r,0).toString());
				  System.out.println(idcustomers);
				  String c_name=t.getValueAt(r,1).toString();
		          String id_type=t.getValueAt(r,2).toString();
		          String r_no=t.getValueAt(r,3).toString();
		          String e_id=t.getValueAt(r,4).toString();
		          String R_type=t.getValueAt(r,5).toString();
		          String nation=t.getValueAt(r,6).toString();
		          String address=t.getValueAt(r,7).toString();
		          String chkin=t.getValueAt(r,8).toString();
		          String chkout=t.getValueAt(r,9).toString();
		          double tar=Double.parseDouble(t.getValueAt(r,10).toString());
				  float gst=Float.parseFloat(t.getValueAt(r,11).toString());
				  float dis=Float.parseFloat(t.getValueAt(r,12).toString());
				  String mst=t.getValueAt(r,13).toString();
		          int noOfrooms=Integer.parseInt(t.getValueAt(r,14).toString());
		          String gender=t.getValueAt(r,15).toString();
		          double amt=Double.parseDouble(t.getValueAt(r,16).toString());
		          int noOfday=Integer.parseInt(t.getValueAt(r,17).toString());
		         
		          q="Update customers Set 'c_name'=?,'id_type'=?,'noOfR'=?`r_no`=?,`e_id`=?,`r_type`=?,`nation`=?,`address`=?,`chkin`=?,`chkout`=?,`tariff`=?,`gst`=?,`disc`=?,`mst`=?,`noOfR`=?,`gender`=?,`netamt`=?,`noOfdays`=? Where 'idcustomers'=?";
		          sql= con.prepareStatement(q);
		          sql.setString(1,c_name);
		          sql.setString(2,id_type);
		          sql.setString(3,r_no);
		          sql.setString(4,e_id);
		          sql.setString(5,R_type);
		          sql.setString(6,nation);
		          sql.setString(7,address);
		          sql.setString(8,chkin);
		          sql.setString(9,chkout);
		          sql.setDouble(10,tar);
		          sql.setFloat(11,gst);
		          sql.setFloat(12,dis);
		          sql.setString(13,mst);
		          sql.setInt(14,noOfrooms);
		          sql.setString(15,gender);
		          sql.setDouble(16,amt);
		          sql.setInt(17,noOfday);
		          sql.setInt(18,idcustomers);
		          sql.executeUpdate();

	              con.close();
	              sql.close();
				}

				 }catch(Exception e) 
				 {
					 e.printStackTrace();
				 }
				
	                 
				System.out.println(t.getValueAt(0,10).getClass());
	                   
				  if(rm>0 )
				  {  JLabel l=new JLabel("Rooms Updated");
					UIManager.put("OptionPane.minimumSize",new Dimension(347,147)); 
					l.setFont(new Font("Serif", Font.ITALIC, 32));
					JPanel pane=new JPanel();
					pane.add(l);
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,30))); 
				    JOptionPane.showMessageDialog(null,pane,"Rooms Updated",JOptionPane.PLAIN_MESSAGE);
				  }           
		        	 
				  else
		        	  { 
					  JLabel l=new JLabel("Rooms Updated");
					  UIManager.put("OptionPane.minimumSize",new Dimension(347,147)); 
		        	  l.setFont(new Font("Serif", Font.ITALIC, 32));
		        	  JPanel pane=new JPanel();
		        	  pane.add(l);
		        	  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,30))); 
		        	  JOptionPane.showMessageDialog(null,pane,"Rooms Updated",JOptionPane.PLAIN_MESSAGE);
				  }           
				
	 }
	
 }		
	
		
	public static void main(String[] args)
	
	{
		new uproom();
	}
	
}
