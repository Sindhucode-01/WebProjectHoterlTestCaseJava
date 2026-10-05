package HotelTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertHotel {

	public static void addHotel() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter hotel name");
		String name = scanner.next();

		System.out.println("Enter room type");
		String room = scanner.next();

		System.out.println("Enter price");
		int price = scanner.nextInt();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root","Sindhu@1");

			Statement statement = connection.createStatement();

			String query = "INSERT INTO hotel_database.hotel (name, room, price) VALUES ('" + name + "', '" + room+ "', " + price + ")";
			int x = statement.executeUpdate(query);
			if (x == 0) {
				System.out.println("Code not working");
			} else {
				System.out.println("Hotel added successfully!");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}