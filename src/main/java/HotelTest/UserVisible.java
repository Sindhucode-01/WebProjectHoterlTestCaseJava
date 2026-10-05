package HotelTest;

import java.util.List;
import java.util.Scanner;

public class UserVisible {
	static HotelData data = new HotelData();
	static List<Hotel> list = data.storeAllHotels();

	public static List<Hotel> availableHotels() {
		System.out.println("Avaibale Hotels are");

		for (Hotel h : list) {
			System.out.println(h.getName() + " " + h.getPrice() + " " + h.getRoom());
		}
		return list;
	}

	public static float enterUserData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter hotel name ");
		String name = scanner.next();
		System.out.println("Enter how many days ");
		int days = scanner.nextInt();
		float bill = 0.0f;
		for (Hotel hh : list) {
			if (hh.getName().equals(name)) {
				bill = hh.getPrice() * days;
			} else {
				System.out.println("Hotel Not Found!!");
			}
		}
		System.out.println("Total bill is = " + bill);

		System.out.println("Would you like to go with this ?");
		String agree = scanner.next();
		if (agree.equals("Y")) {
			System.out.println("Final bill= " + bill);
			System.exit(1);
		} else {
			UserVisible.enterUserData();
		}
		return bill;
	}
}
