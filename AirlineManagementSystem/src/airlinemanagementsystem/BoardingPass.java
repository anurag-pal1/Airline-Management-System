
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BoardingPass extends JFrame implements ActionListener {
    JLabel tfname,tfnationality,tfsrc,lbldest,labelfname,labelfcode,labeldate;
    JTextField tfpnr;
    JButton btnfetch;
    public BoardingPass(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(400,10,450,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(380,50,450,35);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60,100,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
        btnfetch = new JButton("Fetch Details");
        btnfetch.setBackground(Color.BLACK);
        btnfetch.setForeground(Color.WHITE);
        btnfetch.setBounds(380,100,125,25);
        btnfetch.addActionListener(this);
        add(btnfetch);
                
        
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality=new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        JLabel lblsource = new JLabel("SOURCE");
        lblsource.setBounds(60,220,150,25);
        lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblsource);
        
        tfsrc=new JLabel();
        tfsrc.setBounds(220,220,180,25);
        add(tfsrc);
        
        JLabel lbldestination = new JLabel("DESTINATION");
        lbldestination.setBounds(300,220,150,25);
        lbldestination.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldestination);
        
        lbldest = new JLabel();
        lbldest.setBounds(450,220,150,25);
        add(lbldest);
         
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,260,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname=new JLabel();
        labelfname.setBounds(220,260,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(300,260,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode=new JLabel();
        labelfcode.setBounds(460,260,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,300,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        labeldate=new JLabel();
        labeldate.setBounds(220,300,150,25);
        add(labeldate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2=i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600,0,300,300);
        add(lblimage);
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== btnfetch){
            String pnr = tfpnr.getText();
            try{
            
            Conn conn=new Conn();
            String query="select * from reservation where PNR = '"+pnr+"'";
            
             ResultSet rs=conn.stment.executeQuery(query);
             
             if(rs.next()){
                 
                 tfname.setText(rs.getString("name"));
                 tfnationality.setText(rs.getString("nationality"));
                 tfsrc.setText(rs.getString("src"));
                 lbldest.setText(rs.getString("dest"));
                 labelfname.setText(rs.getString("flightname"));
                 labelfcode.setText(rs.getString("flightcode"));
                 labeldate.setText(rs.getString("ddate"));
                 
             }else{
                 JOptionPane.showMessageDialog(null, "Please enter correct aadhar number.");
          
             }
        }catch(Exception e){
            e.printStackTrace();
        }  
        }   
    }
}

