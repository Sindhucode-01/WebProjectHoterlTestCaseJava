<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel Details</title>
</head>
<body>
	<h1>Available Hotels</h1>
	<%
	String hotelName = request.getParameter("hotelName");
	String daysString = request.getParameter("days");

	int days = 0;
	int finalBill = 0;

	boolean hotelFound = false;
	try {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root","Sindhu@1");

		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery("select * from hotel");
		while (set.next()) {
			String name = set.getString(2);
			int price = set.getInt(4);

			out.println(name + " " + price);
			out.println("<br>");

			/*
			 * Calculate bill if user has entered
			 * hotel name and number of days.
			 */

			if (hotelName != null && daysString != null && hotelName.equals(name)) {
				days = Integer.parseInt(daysString);
				finalBill = price * days;
				hotelFound = true;
			}
		}

		connection.close();
	} 
	catch (Exception e) {
		System.out.println(e);
	}
	%>
	<br>
	<h2 style="margin-top: 5px;">Enter Your Details</h2>

	<form action="display.jsp" method="get">

		Hotel Name: <input type="text" name="hotelName"> <br> <br>
		Number of Days: <input type="text" name="days"> <br> <br>

		<input type="submit" value="Calculate Bill">

	</form>

	<%
	if (hotelName != null && daysString != null) {
		if (hotelFound) {
		%>
		<h2>Bill Details</h2>
		Hotel Name: <%=hotelName%>
		<br>
		Number of Days: <%=days%>
		<br> 
		Final Bill = <%=finalBill%>
		<%
		} 
		else {
		%>
		<h2>Hotel Not Found!!</h2>
		<%
		}
	}
	%>
	<br>
	<br>
	<form action="index.html">
		<input type="submit" value="Go to Home">
	</form>
</body>
</html>