
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
     JButton btnreset,btnsubmit,btnclose;
     JTextField tfusername;
     JPasswordField tfpassword;
    public Login(){
        
        getContentPane().setBackground(Color.WHITE);
         setLayout(null);
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,20,100,20);
        add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20,60,100,20);
        add(lblpassword);
        
        tfpassword=new JPasswordField();
        tfpassword.setBounds(130,60,200,20);
        add(tfpassword);
        
        btnreset = new JButton("Reset");
        btnreset.setBounds(60,120,100,20);
        btnreset.addActionListener(this);
        add(btnreset);
        
        btnsubmit = new JButton("Submit");
        btnsubmit.setBounds(200,120,100,20);
        btnsubmit.addActionListener(this);
        add(btnsubmit);
        
        btnclose = new JButton("Close");
        btnclose.setBounds(130,160,100,20);
        btnclose.addActionListener(this);
        add(btnclose);
        
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() == btnsubmit)
       {
           String username= tfusername.getText();
           String password= tfpassword.getText();
           
           try{
               Conn c=new Conn();
               String query= "select * from login where username ='"+username+"' and password = '"+password+"'";
               ResultSet rs=c.stment.executeQuery(query);
               
               if(rs.next()){
                   new Home(); 
                   setVisible(false);
                   
               }else{
                   JOptionPane.showMessageDialog(null,"Invalid Username or Password");
               }
               
           }catch(Exception e){
               e.printStackTrace();
           }
           
       }
       else if(ae.getSource() == btnclose)
       {
            setVisible(false);
       }
       else if(ae.getSource() == btnreset)
       {
           tfusername.setText("");
           tfpassword.setText("");
       }
    }
    
    public static void main(String args[])
    {
        new Login(); 
    }   
}
