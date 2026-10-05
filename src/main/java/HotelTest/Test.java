package HotelTest;

import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		// would you like to add more hotels y/n
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to add more hotels Y/N ?");
		String choice = sc.next();

		if (choice.equals("Y")) {
			System.out.println("Enter Passsword:");
			String pass = sc.next();
			if (pass.equals("1234")) {
				InsertHotel.addHotel();

			}

		} else {
			List<Hotel> list = UserVisible.availableHotels();
			System.out.println(UserVisible.enterUserData());
		}
		Test.main(args);
	}
}
