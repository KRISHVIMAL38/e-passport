/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krushnat malvekar
 */
public class View_user_details extends HttpServlet {

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email2=request.getParameter("email");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone","root","");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from details where email=email2");
              
               
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th> first Name</th><th>Last Name</th><th>DOB</th><th>POB</th><th>Gender</th><th>State</th><th>Dist</th><th>ms</th><th>Aadhar</th><th>et</th><th>ed</th><th>father Name</th><th>Motehr Name</th><th>House No</th><th>Street No</th><th>City</th><th>Pincode</th><th>telephone</th><th>Email</th><th>RName</th><th>Raddr</th><tr>");

            while(rs.next()){
        String fname=rs.getString("fname");
        String lname=rs.getString("lname");
        String dob=rs.getString("dob");
        String pob=rs.getString("pob");
        String gender=rs.getString("gender");
        String state=rs.getString("state");
        String dist=rs.getString("dist");
        String ms=rs.getString("ms");
        String aadhar=rs.getString("aadhar");
        String et=rs.getString("et");
        String ed=rs.getString("ed");
        String fathername=rs.getString("fathername");
        String mothername=rs.getString("mothername");
        String houseno=rs.getString("houseno");
        String streetno=rs.getString("streetno");
        String city=rs.getString("city");
        String pincode=rs.getString("pincode");
        String telephone=rs.getString("telephone");
        String email1=rs.getString("email");
        String rname=rs.getString("rname");
        String raddr=rs.getString("raddr");
        String rtelephone=rs.getString("rtelephone");
        
        
        out.println("<tr><th>"+fname+"</th><th>"+ lname+"</th><th>"+gender+"</th><th>"+dob+"</th><th>"+pob+"</th><th>"+gender+"</th><th>"+state+"</th><th>"+dist+"</th><th>"+ms+"</th><th>"+aadhar+"</th><th>"+et+"</th><th>"+ed+"</th><th>"+fathername+"</th><th>"+mothername+"</th><th>"+houseno+"</th><th>"+streetno+"</th><th>"+city+"</th><th>"+pincode+"</th><th>"+telephone+"</th><th>"+email1+"</th><th>"+rname+"</th><th>"+raddr+"</th><th>"+rtelephone+"</th></tr>");
                }  
        }
        catch(Exception e){
            PrintWriter out1 = response.getWriter(); 
            out1.println("<html><body><b>Error in  connecting"
						+ "</b></body></html>");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
