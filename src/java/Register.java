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
public class Register extends HttpServlet { 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        String fname=request.getParameter("firstname");
        String lname=request.getParameter("lastname");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");
        String mobile=request.getParameter("mobile");
        String dob=request.getParameter("dob");
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
            Statement st=conn.createStatement();
            //st.executeUpdate("insert into stud values('"+fname+"','"+lname+"','"+dept+"','"+mob+"')");
            st.executeUpdate("insert into register values('"+fname+"','"+lname+"','"+email+"','"+password+"','"+gender+"','"+mobile+"','"+dob+"')");
            
            out.println("<h3>Data inserted successfully.....</h3>");
            RequestDispatcher rs=request.getRequestDispatcher("login.html");
            rs.forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
}
