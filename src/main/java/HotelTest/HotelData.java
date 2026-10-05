package HotelTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HotelData {
	public List<Hotel> storeAllHotels(){
		List<Hotel> hotels = new ArrayList<Hotel>();
		try {
			Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root","Sindhu@1");
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("SELECT * FROM hotel_database.hotel;");
			
		while(set.next())
		{
		Hotel hotel=new Hotel(set.getInt(1), set.getString(2), set.getString(3), set.getInt(4));
		hotels.add(hotel);
		}
	}
		catch (Exception e) {
			// TODO: handle exception
		}
		return hotels;
		
	}
}
