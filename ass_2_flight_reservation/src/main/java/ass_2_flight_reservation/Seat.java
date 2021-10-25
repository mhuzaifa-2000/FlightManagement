package ass_2_flight_reservation;
public class Seat {
	private String status;
	private int seatNumber;
	private String seatType;
	private String seatLocation;
	private int fare;
	
	public Seat(int seatNumber, String seatType, String seatLocation,int fare) {
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.seatLocation = seatLocation;
		this.status = "Available";
		this.fare = fare;
	}
	
	public String getType() {
		return this.seatType;
	}
	public String getLocation() {
		return this.seatLocation;
	}
	public String toString() {
		return "Seat Number: "+this.seatNumber+"\n"
				+"Seat Type: "+this.seatType+"\n"
				+"Seat Location: "+this.seatLocation+"\n"
				+"Fare: $"+this.fare+"\n\n";
		
	}
	public String getStatus() {
		return this.status;
	}
	public void bookSeat() {
		this.status = "Reserved";
	}
	public void unBookSeat() {
		this.status = "Available";
	}
}
