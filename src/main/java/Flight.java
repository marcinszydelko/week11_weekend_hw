import java.util.ArrayList;

public class Flight {
    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, String departureTime) {
        this.passengerList = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }


    public int availableSeats() {
        return this.plane.getPlaneType().getCapacity() - this.passengerList.size();
    }


    public void addPassenger(Passenger passenger) {
        this.passengerList.add(passenger);
    }
}
