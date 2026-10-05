package HotelTest;

public class Hotel {
	int id;
	String name;
	String room;
	int price;

	public Hotel(int id, String name, String room, int price) {
		super();
		this.id = id;
		this.name = name;
		this.room = room;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRoom() {
		return room;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", room=" + room + "price=" + price + "]";
	}
}
