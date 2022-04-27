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

<h1>User Details Are</h1>
<table border="1">
<tr>


<td>Email</td>
<td>SSC</td>
<td>Aadhar or PAN</td>
<td>Payment Status</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from documents where email='"+id+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
    <td><a href="<%=resultSet.getString("email") %>"><%=resultSet.getString("email") %></a></td>
    <td><a href="<%=resultSet.getString("ssc") %>"><%=resultSet.getString("ssc") %></a></td>
    <td><a href="<%=resultSet.getString("ssc") %>"><%=resultSet.getString("aadhar") %></a></td>
    <td><a href="<%=resultSet.getString("payslip") %>"><%=resultSet.getString("payslip") %></a></td>

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