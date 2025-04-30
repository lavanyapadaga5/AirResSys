package airReservation;

public class Flight {
	private int flightNumber;
	private String designation;
	private int avilableSeats;
	public Flight(int flightNumber, String designation, int avilableSeats) {
		super();
		this.flightNumber = flightNumber;
		this.designation = designation;
		this.avilableSeats = avilableSeats;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getAvilableSeats() {
		return avilableSeats;
	}
	public void setAvilableSeats(int avilableSeats) {
		this.avilableSeats = avilableSeats;
	}
	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", designation=" + designation + "]";
	}
    public void decreaseAvilableSeats() {
    	if(avilableSeats>0) {
    		avilableSeats--;
    	}
    }
}
