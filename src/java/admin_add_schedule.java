
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author krushnat malvekar
 */
public class admin_add_schedule extends HttpServlet { 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        int monthid=Integer.parseInt(request.getParameter("monthid"));
        String monthname=request.getParameter("monthname");
        int availdays=Integer.parseInt(request.getParameter("days"));
        int timeslots=Integer.parseInt(request.getParameter("timeslots"));
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
            Statement st=conn.createStatement();
            
            st.executeUpdate("insert into addschedule values('"+monthid+"','"+monthname+"','"+availdays+"','"+timeslots+"')");
            
            out.println("<h3>Schedule Added successfully.....</h3>");
            out.print("<a href='" + getServletContext().getContextPath() + "/Admin_loginsuccess.html'>Click here to land on Homepage</a>"); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
}
