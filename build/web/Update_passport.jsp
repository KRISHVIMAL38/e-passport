<%-- 
    Document   : Update_passport
    Created on : 25 Apr, 2022, 4:39:45 PM
    Author     : krushnat malvekar
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String email1 = request.getParameter("email");
String month = request.getParameter("month");
int day=Integer.parseInt(request.getParameter("day"));
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "capstone";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
PreparedStatement ps = null;
%>
<!DOCTYPE html>
<html>
<body>

<h1>Plan Me thoda change hai</h1>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="update appt set email=?,day=?,month=? where email='"+email1+"'";
ps = connection.prepareStatement(sql);
ps.setString(1,email1);
ps.setInt(2, day);
ps.setString(3, month);

int i = ps.executeUpdate();
if(i > 0)
{
out.println("Record Updated Successfully");
out.println("<h3></h3>");
out.println("<a href='" + getServletContext().getContextPath() + "/Admin_loginsuccess.html'>Click here to land on Homepage</a>"); 
}
else
{
out.print("There is a problem in updating Record.");
} 

connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>


</body>
</html>