
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
public class add_pass extends HttpServlet { 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        int offid=Integer.parseInt(request.getParameter("offid"));
        String offname=request.getParameter("offname");
        String offjuri=request.getParameter("offjuri");
        String offaddr=request.getParameter("offaddr");
        String offphone=request.getParameter("offphone");
        
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
            Statement st=conn.createStatement();
            //st.executeUpdate("insert into stud values('"+fname+"','"+lname+"','"+dept+"','"+mob+"')");
            st.executeUpdate("insert into addpass values('"+offid+"','"+offname+"','"+offjuri+"','"+offaddr+"','"+offphone+"')");
            
            out.println("<h3>Office Added successfully.....</h3>");
            out.print("<a href='" + getServletContext().getContextPath() + "/Admin_loginsuccess.html'>Click here to land on Homepage</a>"); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
}
