package ass_2_flight_reservation;

import java.util.ArrayList;

public class Flight {
	private String id;
	ArrayList<Seat> seats;
	String origin;
	String destination;
	DateandTime departureTime;
	DateandTime arrivalTime;
	int firstClassFare, businessFare, economyFare;
	public Flight(String id,String origin, String destination, int numEconomySeats,int numBusinessSeats, int numFirstClassSeats,DateandTime departureTime, DateandTime arrivalTime,int firstClassFare, int businessFare, int economyFare) {
		this.economyFare = economyFare;
		this.businessFare = businessFare;
		this.firstClassFare = firstClassFare;
		this.origin=origin;
		this.destination=destination;
		seats = new ArrayList<Seat>();
		this.id=id;
		addSeats(numEconomySeats,numBusinessSeats,numFirstClassSeats);
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	private void addSeats(int numEconomySeats,int numBusinessSeats, int numFirstClassSeats) {
		int seatNumber=0;
		for(int i=0; i<numEconomySeats ; i++) {
			String seatLocation="";
			if(i%2 == 0) {
				seatLocation = "Window";
			}
			else {
				seatLocation = "Aisle";
			}
			Seat newSeat = new Seat(seatNumber++,"Economy",seatLocation,economyFare);
			seats.add(newSeat);
		}
		for(int i=0; i<numBusinessSeats ; i++) {
			String seatLocation="";
			if(i%2 == 0) {
				seatLocation = "Window";
			}
			else {
				seatLocation = "Aisle";
			}
			Seat newSeat = new Seat(seatNumber++,"Business",seatLocation,businessFare);
			seats.add(newSeat);
		}
		for(int i=0; i<numFirstClassSeats ; i++) {
			String seatLocation="";
			if(i%2 == 0) {
				seatLocation = "Window";
			}
			else {
				seatLocation = "Aisle";
			}
			Seat newSeat = new Seat(seatNumber++,"First Class",seatLocation,firstClassFare);
			seats.add(newSeat);
		}
	}
	public ArrayList<Seat> getSeatsByType(String type){
		ArrayList<Seat> seatsByType = new ArrayList<Seat>();
		for(int i=0; i<seats.size(); i++)
		{
			if(seats.get(i).getType()==type) {
				seatsByType.add(seats.get(i));
			}
		}
		return seatsByType;
	}
	public ArrayList<Seat> getSeatsByLocation(String location){
		ArrayList<Seat> seatsByLocation = new ArrayList<Seat>();
		for(int i=0; i<seats.size(); i++)
		{
			if(seats.get(i).getLocation()==location) {
				seatsByLocation.add(seats.get(i));
			}
		}
		return seatsByLocation;
	}
	public Seat getSeat(int Number) {
		Seat s2 = seats.get(Number);
		return s2;
	}
	public String getFlightDetails() {
		String returnVal="";
		returnVal += "ID: "+id+"\n"+
				      "Origin: "+origin+"\n"+
				      "Destination: "+destination+"\n"+
					  "Departure: "+departureTime.getDateAndTime()+"\n"
					  +"Arrival Time: "+arrivalTime.getDateAndTime()+"\n";
		return returnVal;
	}
	public String toString() {
		String returnVal="";
		returnVal += "ID: "+id+"\n";
		for(int i=0; i<seats.size(); i++) {
			returnVal+=seats.get(i).toString();
		}
		
		return returnVal;
	}
	public void showStatus() {
		for(Seat seat:seats) {
			System.out.println(seat.getStatus());
		}
	}
//	public static void main(String[] args) {
//		DateandTime dep = new DateandTime(2021, 10, 30, 23, 20, 30);
//		DateandTime arr = new DateandTime(2021, 10, 31, 3, 20, 30);
//		Flight plane1 = new Flight("PK-232","Islamabad","Karachi",12,12,12,dep,arr,33444,2333,2333);
//		System.out.print(plane1);
//		
//	}
}
