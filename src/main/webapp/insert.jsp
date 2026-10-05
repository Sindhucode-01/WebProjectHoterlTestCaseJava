<%@page import="java.sql.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Hotel</title>
</head>
<body>
	<%
	String n1 = request.getParameter("name");
	String roomType = request.getParameter("room");
	String price = request.getParameter("price");

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "Sindhu@1");
		Statement st = cn.createStatement();
		String query = "insert into hotel_database.hotel(`name`,`room`,`price`) values('" + n1 + "','" + roomType + "','"+ price + "')";
		int x = 0;
		x = st.executeUpdate(query);
		if (x == 0) {
			System.out.println("Code Not working");
			//InsertHotel.adddHotel();
		}

		response.sendRedirect("add.html");
	} 
	catch (Exception e) {
		System.out.println(e);
	}
	%>
</body>
</html>
