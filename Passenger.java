package airReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {
	private static final Reservation Reservationtocancel = null;
	static ArrayList<Flight> list=new ArrayList();
	static ArrayList<Reservation> Res=new ArrayList();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		list.add(new Flight(123,"Paris",5));
		list.add(new Flight(888,"London",3));
		list.add(new Flight(332,"Bengalore",5));
		while(true) {
			System.out.println("\n------Air Reservation System------\n");
			System.out.println("1.Display Seats");
			System.out.println("2.Book a Flight");
			System.out.println("3.View Reservation");
			System.out.println("4.Cancel Booking");
			System.out.println("5.Exit");
			System.out.println("Choose an Option");
			int choice=getValidIntegerInput();
			switch(choice) {
			case 1:{
				displayAvilableFlights();
				break;
			}
			case 2:{
				bookFlight();
				break;
			}
			case 3:{
				viewReservation();
				break;
			}
			case 4:{
				cancelBooking();
				break;
			}
			case 5:{
				System.out.println("Exiting the System");
				scan.close();
				return;
			}
			default:{
				System.out.println("Invalid Option Please Try Again");
			}
			}
		}
	}
	private static void cancelBooking() {
		System.out.println("Enter the name of the Passenger to cancel the flight");
		String PassengerName=scan.next();
		for(Reservation r:Res) {
			if(r.getName().equalsIgnoreCase(PassengerName)) {
				Reservationtocancel=r;
				break;
			}
		}
		if(Reservationtocancel!=null) {
			Flight flight=Reservationtocancel.getFlightNumber();
			flight.setAvilableSeats(flight.getAvilableSeats()+1);
			Res.remove(Reservationtocancel);
			System.out.println("Reservation is cancelled for the passenger");
		}
		else {
			System.out.println("No Reservation with the name:"+PassengerName);
		}
	}
	private static void viewReservation() {
		if(Res.isEmpty()) {
			System.out.println("No Reservations done Yet!");
		}
		else {
			System.out.println("Reservations------");
			for(Reservation r:Res) {
				System.out.println("PassengerName:"+ r.getName());
				System.out.println("FlightNumber:"+r.getFlight().getFlightNumber());
				System.out.println("Designation:"+r.getFlight().getDesignation());
				System.out.println("--------------------------------------------");
			}
		}
		
	}
	private static void bookFlight() {
		displayAvilableFlights();
		System.out.println("Enter the flight number to book a flight");
		int flightNumber=getValidIntegerInput();
		Flight selectFlight=null;
		for(Flight flight:list) {
			if(flight.getFlightNumber()==flightNumber) {
				selectFlight=flight;
				break;
			}
		}
		if(selectFlight==null) {
			System.out.println("Invalid Flight Number,Try Again");
			return;
		}
		if(selectFlight.getAvilableSeats()>0) {
			System.out.println("Enter Your Name");
			String Passenger =scan.next();
			Reservation reservation=new Reservation(Passenger,selectFlight);
			Res.add(reservation);
			selectFlight.decreaseAvilableSeats();
			System.out.println("Booking Successful!!!!");
		}else {
			System.out.println("Sorry Seats Are not avilable in selected Flight");
		}
		
	}
	private static void displayAvilableFlights() {
		System.out.println("\n---Avilable Flights");
		for(Flight f:list) {
			System.out.println("Flight Number"+f.getFlightNumber()+",Destination"+f.getDesignation()+",Avilable Seats"+f.getAvilableSeats());
		}
		
	}
	private static int getValidIntegerInput() {
		while(!scan.hasNextInt()) {
			System.out.println("Enter the proper Number");
			scan.next();
		}
		return scan.nextInt();
	}

}
