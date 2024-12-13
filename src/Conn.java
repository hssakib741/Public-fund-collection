
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn()
    {
        try {
            
            System.out.println("Driver Loaded");
            c = DriverManager.getConnection("jdbc:mysql:///publicfund","root","pass123");
            s=c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}