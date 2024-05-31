
package airlinemanagementsystem;

import java.sql.*;
public class Conn {
    
    Connection conn;
    Statement stment;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root","anurag");
            stment=conn.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
