
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
public class BookFlight extends JFrame implements ActionListener {
    JLabel tfname,tfnationality,tfaddress,labelgender,labelfname,labelfcode;
    JTextField tfaadhar;
    JButton btnbookflight,btnflight,btnfetch;
    Choice source,destination;
    JDateChooser dcdate;
    public BookFlight(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(350,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220,80,150,25);
        add(tfaadhar);
        
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
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality=new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress=new JLabel();
        tfaddress.setBounds(220,230,180,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220,280,150,25);
        add(labelgender);
         
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblsource);
        
        source= new Choice();
        source.setBounds(220,330,150,25);
        add(source);
        
        
        JLabel lbldestination = new JLabel("Destination");
        lbldestination.setBounds(60,380,150,25);
        lbldestination.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldestination);
        
        destination= new Choice();
        destination.setBounds(220,380,120,25);
        add(destination);
        
        try{
            Conn conn = new Conn();
            String query="select * from flight";
            ResultSet rs=conn.stment.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        btnflight=new JButton("Fetch Flights");
        btnflight.setBackground(Color.BLACK);
        btnflight.setForeground(Color.WHITE);
        btnflight.setBounds(380,380,150,25);
        btnflight.addActionListener(this);
        add(btnflight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,430,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname=new JLabel();
        labelfname.setBounds(220,430,150,25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,480,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode=new JLabel();
        labelfcode.setBounds(220,480,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60,530,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        dcdate=new JDateChooser();
        dcdate.setBounds(220,530,150,25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 320,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
        
        
        btnbookflight=new JButton("Book Flight");
        btnbookflight.setBackground(Color.BLACK);
        btnbookflight.setForeground(Color.WHITE);
        btnbookflight.setBounds(220,580,150,25);
        btnbookflight.addActionListener(this);
        add(btnbookflight);
        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== btnfetch){
            String aadhar = tfaadhar.getText();
            try{
            
            Conn conn=new Conn();
            String query="select * from passenger where aadhar = '"+aadhar+"'";
            
             ResultSet rs=conn.stment.executeQuery(query);
             
             if(rs.next()){
                 
                 tfname.setText(rs.getString("name"));
                 tfnationality.setText(rs.getString("nationality"));
                 tfaddress.setText(rs.getString("address"));
                 labelgender.setText(rs.getString("gender"));
                 
             }else{
                 JOptionPane.showMessageDialog(null, "Please enter correct aadhar number.");
          
             }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()== btnflight){
            String src = source.getSelectedItem();
            String dest= destination.getSelectedItem();
            try{
            
            Conn conn=new Conn();
            String query="select * from flight where source = '"+src+"' and destination = '"+dest+"'";
            
             ResultSet rs=conn.stment.executeQuery(query);
             
             if(rs.next()){
                 
                 labelfname.setText(rs.getString("f_name"));
                 labelfcode.setText(rs.getString("f_code"));
                 
                 
             }else{
                 JOptionPane.showMessageDialog(null, "No flights found.");
          
             }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else{
            
            Random random = new Random();
            
           String aadhar = tfaadhar.getText();
           String name = tfname.getText();
           String nationality = tfnationality.getText();
           String flightname=labelfname.getText();
           String flightcode=labelfcode.getText();
           String src=source.getSelectedItem();
           String dest=destination.getSelectedItem();
           String ddate = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
           
           try{
            
            Conn conn=new Conn();
            String query="insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC- "+random.nextInt(10000)+"','"+aadhar+"' , '"+name+"', '"+nationality+"', '"+flightname+"' , '"+flightcode+"', '"+src+"', '"+dest+"', '"+ddate+"' )";
            
             conn.stment.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null, "Ticket Booked Successfully.");
             
             setVisible(false);
             
        }catch(Exception e){
            e.printStackTrace();
        }
           
        }
        
    }
}
