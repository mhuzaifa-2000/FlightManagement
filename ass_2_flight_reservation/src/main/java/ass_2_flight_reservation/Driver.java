package ass_2_flight_reservation;

import java.io.*;
import java.util.*;

public class Driver {

	public static ArrayList<Flight> populateFlights() throws FileNotFoundException{
		ArrayList<Flight> flights = new ArrayList<Flight>();
		Scanner input = new Scanner(new File("file.txt"));
		while(input.hasNextLine() && input.hasNext()) {
			String id = input.next();
			String origin = input.next();
			String destination = input.next();
			int numEconomySeats = input.nextInt();
			int numBusinessSeats = input.nextInt();
			int numFirstClassSeats = input.nextInt();
			int year = input.nextInt();
			int month = input.nextInt();
			int day = input.nextInt();
			int hour = input.nextInt();
			int minutes = input.nextInt();
			int seconds = input.nextInt();
			DateandTime departureTime = new DateandTime(year, month, day, hour, minutes, seconds);
			year = input.nextInt();
			month = input.nextInt();
			day = input.nextInt();
			hour = input.nextInt();
			minutes = input.nextInt();
			seconds = input.nextInt();
			DateandTime arrivalTime = new DateandTime(year, month, day, hour, minutes, seconds);
			int economyFare = input.nextInt();
			int businessFare = input.nextInt();
			int firstClassFare= input.nextInt();
			
			Flight f1 = new Flight(id,origin,destination,numEconomySeats,numBusinessSeats, numFirstClassSeats,departureTime,arrivalTime,firstClassFare,businessFare, economyFare);
			flights.add(f1);
		}
		return flights;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException,InvalidCreditCardException {
		ArrayList<Flight> flights = populateFlights();
		populateFlights();
		Scanner input = new Scanner(System.in);
		PrintStream output = new PrintStream(new BufferedOutputStream(new FileOutputStream("file.txt",true)));
		int option=0;
		while(option !=3)
		{
			System.out.println("--------Airline Booking--------");
			System.out.println("1.Admin Controls");
			System.out.println("2. Search and Book a Flight");
			System.out.println("3 .Exit");
			System.out.print("Select Option: ");
			option = input.nextInt();
			if(option==1) {
				System.out.println("1. Add a new flight");
				System.out.print("Select Option: ");
				int subOption = input.nextInt();
				if(subOption == 1) {
					System.out.print("Enter Flight ID: ");
					String id = input.next();
					System.out.print("Enter Flight Origin: ");
					String origin = input.next();
					System.out.print("Enter Flight Destination: ");
					String destination = input.next();
					System.out.print("Enter number of economy seats: ");
					int numEconomySeats = input.nextInt();
					System.out.print("Enter number of business seats: ");
					int numBusinessSeats = input.nextInt();
					System.out.print("Enter number of first class seats: ");
					int numFirstClassSeats = input.nextInt();
					System.out.print("Enter economy fare: ");
					int economyFare = input.nextInt();
					System.out.print("Enter business fare: ");
					int businessFare = input.nextInt();
					System.out.print("Enter first class fare: ");
					int firstClassFare= input.nextInt();
					System.out.println("-Departure Date And Time- ");
					System.out.print("Year: ");
					int year = input.nextInt();
					System.out.print("Month: ");
					int month = input.nextInt();
					System.out.print("Day: ");
					int day = input.nextInt();
					System.out.print("Hour: ");
					int hour = input.nextInt();
					System.out.print("Minute: ");
					int minutes = input.nextInt();
					System.out.print("Seconds: ");
					int seconds = input.nextInt();
					DateandTime departureTime = new DateandTime(year, month, day, hour, minutes, seconds);
					System.out.println("-Arrival Date And Time- ");
					System.out.print("Year: ");
					year = input.nextInt();
					System.out.print("Month: ");
					month = input.nextInt();
					System.out.print("Day: ");
					day = input.nextInt();
					System.out.print("Hour: ");
					hour = input.nextInt();
					System.out.print("Minute: ");
					minutes = input.nextInt();
					System.out.print("Seconds: ");
					seconds = input.nextInt();
					DateandTime arrivalTime = new DateandTime(year, month, day, hour, minutes, seconds);
					output.printf("%s %s %s %d %d %d %s %s %d %d %d\n",id,origin,destination,numEconomySeats,numBusinessSeats, numFirstClassSeats,departureTime,arrivalTime,firstClassFare,businessFare, economyFare);
				}
			}
			else if(option==2)
			{
				for(int i=0; i<flights.size(); i++) {
					System.out.println("Flight Number: "+i);
					System.out.println(flights.get(i).getFlightDetails());
				}
				System.out.println("Enter Flight Number: ");
				int flightNumber = input.nextInt();
				Flight selectedFlight = flights.get(flightNumber);
				System.out.print(selectedFlight);
				System.out.print("\n Enter the seat Number you want to book: ");
				int seatNumber = input.nextInt();
				Seat seat = selectedFlight.getSeat(seatNumber);
				System.out.println("Enter your details");
				System.out.print("Name: ");
				String name = input.next();
				System.out.print("Gender: ");
				String gender = input.next();
				System.out.print("Age: ");
				int age = input.nextInt();
				System.out.print("Address: ");
				String address = input.next();
				System.out.print("Passport Number: ");
				String passportNumber = input.next();
				Passenger passenger;
				try {
					passenger = new Passenger(name, gender, age, address, passportNumber);
					System.out.println("Enter your card details");
					System.out.print("Card Number Must be 13 digit: ");
					String cardNumber = input.next();
					System.out.print("Card Pin Must be 4 digit: ");
					String cardPin = input.next();
					if(cardNumber.length()!=13 || cardPin.length()!=4) {
						throw new InvalidCreditCardException("Payment failed");
					}
					passenger.assignSeat(seat);
					System.out.println("--YOUR E-TICKET--");
					System.out.print(selectedFlight+"\n"+passenger+"\n");
				}catch(InvalidPassengerDetailsException e) {
					System.out.println(e+" Try Again");
				}
				
			}
			if(option==3)
			{
				output.close();
				input.close();
			}
			
		}
		
	}
}
