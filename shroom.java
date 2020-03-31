import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;

import java.util.*;
import javax.sql.rowset.*;
;public class shroom extends JFrame implements ActionListener 
{	
	//JFrame fr;
	JPanel p,p1; 
	JTable t;
	JScrollPane s;
	JButton b,m;
	JTableHeader th;
	ResultSet rs;
	ResultSetMetaData rsmd;
	int numberOfColumns;
	 PreparedStatement  ps;
	public shroom()
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
	         
	         
	         DefaultTableModel model =(DefaultTableModel)t.getModel();
	         model.setColumnIdentifiers(new String[]{"C_Id","C_name","IDType", "RoomNo.","EmailID","RoomType",
	        		 "Nationality","Address", "CheckIn","CheckOut","Tariff","GST","Disc.","M/S","No/Rooms","Gender","NetAmt","No/Ds"}); 
	        	 while(rs.next()){
	        		 model.addRow( new Object[] { rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
		                		rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11), 
		                		rs.getFloat(12),rs.getFloat(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getDouble(17),rs.getInt(18)});
	        	 }
	           
	             t.setModel(model);
	             t.setEnabled(false);
	            
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
		 t.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		p.add(s,BorderLayout.CENTER);
		validate();
		b=new JButton("RETURN");
		m=new JButton("RETURN2");
		b.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		b.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
		m.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		m.setBorder( BorderFactory.createLineBorder(Color.BLACK, 2));
		b.setVisible(true);
		m.setVisible(true);
		b.addActionListener(this);
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		p.setBackground(Color.WHITE);
		p1.setBackground(Color.green);
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		p1.add(b);//p1.add(m);
		add(p);
		add(p1,BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	
	
		
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand()=="RETURN")
		{
			dispose();
			new welc();
		}
	}
	public static void main(String[] args)
	
	{
		new shroom();
	}
	
}