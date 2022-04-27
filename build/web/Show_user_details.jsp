<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("email");
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
%>
<!DOCTYPE html>
<html>
<body>

<h1>Your Details Are</h1>
<table border="1">
<tr>
<td>first name</td>
<td>last name</td>
<td>Date Of Birth</td>
<td>Place Of Birth</td>
<td>Gender</td>
<td>State</td>
<td>District</td>
<td>Marietal Status</td>
<td>Aadhar</td>
<td>Employment Type</td>
<td>Educational Details</td>
<td>Father Name</td>
<td>Mother Name</td>
<td>House Number</td>
<td>Street Name / Number</td>
<td>City</td>
<td>Pincode</td>
<td>Telephone</td>
<td>Email</td>
<td>Reference Name</td>
<td>Reference Address</td>
<td>Reference Telephone</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from details where email='"+id+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("fname") %></td>
<td><%=resultSet.getString("lname") %></td>
<td><%=resultSet.getString("dob") %></td>
<td><%=resultSet.getString("pob") %></td>
<td><%=resultSet.getString("gender") %></td>
<td><%=resultSet.getString("state") %></td>
<td><%=resultSet.getString("dist") %></td>
<td><%=resultSet.getString("ms") %></td>
<td><%=resultSet.getString("aadhar") %></td>
<td><%=resultSet.getString("et") %></td>
<td><%=resultSet.getString("ed") %></td>
<td><%=resultSet.getString("fathername") %></td>
<td><%=resultSet.getString("mothername") %></td>
<td><%=resultSet.getString("houseno") %></td>
<td><%=resultSet.getString("streetno") %></td>
<td><%=resultSet.getString("city") %></td>
<td><%=resultSet.getString("pincode") %></td>
<td><%=resultSet.getString("telephone") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("rname") %></td>
<td><%=resultSet.getString("raddr") %></td>
<td><%=resultSet.getString("rtelephone") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 

</body>
</html>