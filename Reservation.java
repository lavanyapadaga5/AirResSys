package airReservation;

public class Reservation {
	private String name;
	private Flight flight;
	public Reservation(String name, Flight flight) {
		super();
		this.name = name;
		this.flight = flight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Flight getFlightNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
