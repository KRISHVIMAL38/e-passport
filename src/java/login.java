/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
 *
 * @author krushnat malvekar
 */
public class login extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email=request.getParameter("username");
        String pass=request.getParameter("password");
        
         try{
            if(validate.checkUser(email, pass)){
            HttpSession s=request.getSession();
            s.setAttribute("User_Email", email);
            
            RequestDispatcher rs=request.getRequestDispatcher("User_login_success.html");
            rs.forward(request, response);
            }
        else{
            RequestDispatcher rs=request.getRequestDispatcher("login.html");
            rs.include(request, response);
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
