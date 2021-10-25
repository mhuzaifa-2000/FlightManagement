package ass_2_flight_reservation;

public class Passenger {
	private String name;
	private String gender;
	private int age;
	private String address;
	private String passportNumber;
	private Seat seat;
	
	public Passenger(String name, String gender, int age, String address,String passportNumber) throws InvalidPassengerDetailsException {
		if(name.length()>100 || age<0 || gender==null) {
			throw new InvalidPassengerDetailsException("Invalid Credentials");
		}
		this.name=name;
		this.gender=gender;
		this.age = age;
		this.address = address;
		this.passportNumber = passportNumber;
		this.seat = null;
	}
	public String getName() {
		return name;
	}
	
	public Seat getSeat() {
		return this.seat;
	}
	public void unBookSeat() {
		this.seat.unBookSeat();
		this.seat = null;
	}
	public void assignSeat(Seat seat) {
		this.seat = seat;
		this.seat.bookSeat();
	}
	public String toString() {
		String str = String.format("Name: %s\n Gender: %s\n Age: %d\n Address: %s\nPassport Number: %s\n", name,gender,age,address,passportNumber);
		str+=this.seat.toString();
		return str;
	}
}
