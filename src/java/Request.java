/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krushnat malvekar
 */
public class Request extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int day1=Integer.parseInt(request.getParameter("day"));
        String month1=request.getParameter("month");
        String email1=request.getParameter("email");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
            //String sql ="select * from appt where day='"+day1+"'"+" and "+"month='"+month1+"'"; 
            
            PreparedStatement st = conn.prepareStatement("insert into appt values(?, ?, ?)");
            st.setString(1, email1);
            st.setInt(2, day1);
            st.setString(3,month1);
            st.executeUpdate();
            st.close();
            conn.close();
            
            out.println("<h2>Mast Plan hai..</h2>");
            out.println("<h3>Request Submitted successfully...</h3>");
//            RequestDispatcher rs=request.getRequestDispatcher("User_login_success.html");
//            rs.forward(request, response);

            out.print("<a href='" + getServletContext().getContextPath() + "/User_login_success.html'>Click here to land on Homepage</a>"); 
        }
        catch(Exception e){
            out.println("<h3>Plan Me thoda change hai..</h3>");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
