
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
public class Upload_docs extends HttpServlet { 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        
        String email=request.getParameter("email");
        String ssc=request.getParameter("ssc");
        String aadhar=request.getParameter("aadhar");
        String payslip=request.getParameter("payslip");
        
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
            Statement st=conn.createStatement();
            //st.executeUpdate("insert into stud values('"+fname+"','"+lname+"','"+dept+"','"+mob+"')");
            st.executeUpdate("insert into documents values('"+email+"','"+ssc+"','"+aadhar+"','"+payslip+"')");
            
            out.println("<h3>Document Uploaded Successfully.....</h3>");
            out.print("<a href='" + getServletContext().getContextPath() + "/User_login_success.html'>Click here to land on Homepage</a>"); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
}
