package HotelTest;

public class User {
	int id;
	String name;
	int age;
	String address;

	public User(int id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	protected int getId() {
		return id;
	}

	protected String getName() {
		return name;
	}

	protected int getAge() {
		return age;
	}

	protected String getAddress() {
		return address;
	}
}
