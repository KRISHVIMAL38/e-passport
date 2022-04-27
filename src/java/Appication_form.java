/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author krushnat malvekar
 */
public class Appication_form extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String dob=request.getParameter("dob");
        String pob=request.getParameter("pob"); 
        String gender=request.getParameter("gender");
        String state=request.getParameter("state");
        String dist=request.getParameter("dist");
        String ms=request.getParameter("ms");
        String aadhar=request.getParameter("aadhar");
        String et=request.getParameter("et");
        String ed=request.getParameter("ed");
        String fathername=request.getParameter("fathername");
        String mothername=request.getParameter("mothername");
        String houseno=request.getParameter("houseno");
        String streetno=request.getParameter("streetno");
        String city=request.getParameter("city");
        String pincode=request.getParameter("pincode");
        String telephone=request.getParameter("telephone");
        String email=request.getParameter("email");
        String rname=request.getParameter("rname");
        String raddr=request.getParameter("raddr");
        String rtelephone=request.getParameter("rtelephone");
        
        try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
            Statement st=conn.createStatement();
            //st.executeUpdate("insert into stud values('"+fname+"','"+lname+"','"+dept+"','"+mob+"')");
            
            st.executeUpdate("insert into details values('"+fname+"','"+lname+"','"+dob+"','"+pob+"','"+gender+"','"+state+"','"+dist+"','"+ms+"','"+aadhar+"','"+et+"','"+ed+"','"+fathername+"','"+mothername+"','"+houseno+"','"+streetno+"','"+city+"','"+pincode+"','"+telephone+"','"+email+"','"+rname+"','"+raddr+"','"+rtelephone+"')");
            
           out.println("<h3>Data inserted successfully.....</h3>");
           RequestDispatcher rs=request.getRequestDispatcher("User_login_success.html");
            rs.forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
