
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Cancel extends JFrame implements ActionListener {
    JLabel tfname,cancellationno,lblfcode,labeldate;
    JTextField tfpnr;
    JButton btncancel,btnfetch;
    public Cancel(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random= new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(240,20,250,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(470,120,250,250);
        add(lblimage);
        
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(220,80,150,25);
        add(tfpnr);
        
        btnfetch = new JButton("Fetch Details");
        btnfetch.setBackground(Color.BLACK);
        btnfetch.setForeground(Color.WHITE);
        btnfetch.setBounds(380,80,125,25);
        btnfetch.addActionListener(this);
        add(btnfetch);
                
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        
        JLabel lblcancellation = new JLabel("Cancellation Number");
        lblcancellation.setBounds(60,180,150,25);
        lblcancellation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcancellation);
        
        cancellationno=new JLabel(""+random.nextInt(1000000));
        cancellationno.setBounds(220,180,150,25);
        add(cancellationno);
        
        
        
        JLabel fcode = new JLabel("Flight Code");
        fcode.setBounds(60,230,150,25);
        fcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(fcode);
        
        lblfcode=new JLabel();
        lblfcode.setBounds(220,230,180,25);
        add(lblfcode);
        
        JLabel lbldot = new JLabel("Date of Travel");
        lbldot.setBounds(60,280,150,25);
        lbldot.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldot);
        
        labeldate = new JLabel();
        labeldate.setBounds(220,280,150,25);
        add(labeldate);
         
        
        btncancel=new JButton("Cancel");
        btncancel.setBackground(Color.BLACK);
        btncancel.setForeground(Color.WHITE);
        btncancel.setBounds(220,330,150,25);
        btncancel.addActionListener(this);
        add(btncancel);
        
       
        setSize(800,430);
        setLocation(350,150);
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
                 lblfcode.setText(rs.getString("flightcode"));
                 labeldate.setText(rs.getString("ddate"));
                 
                 
             }else{
                 JOptionPane.showMessageDialog(null, "Please enter correct PNR number.");
          
             }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()== btncancel){
            String name = tfname.getText();
            String pnr= tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = labeldate.getText();
            try{
            
            Conn conn=new Conn();
            String query="insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"','"+fcode+"', '"+date+"' )";
            
             conn.stment.executeUpdate(query);
             
             conn.stment.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
             
             
                 JOptionPane.showMessageDialog(null, "Ticket Cancelled.");
                 setVisible(false);
         
        }catch(Exception e){
            e.printStackTrace();
        }
           
        }   
    }
}

