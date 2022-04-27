import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class validate_admin {
    public static boolean checkUser(String email,String password){
        boolean st=false;
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
           PreparedStatement ps=con.prepareStatement("select * from adminregister where username=? and password=?");
           ps.setString(1, email);
           ps.setString(2, password);
           
           ResultSet rs=ps.executeQuery();
           st=rs.next();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
}
