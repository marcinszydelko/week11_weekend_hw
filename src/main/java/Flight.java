import java.util.ArrayList;
import java.util.Date;

public class Flight {
    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private Date departureTime;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, Date departureTime) {
        this.passengerList = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public int availableSeats() {
        return this.plane.getPlaneType().getCapacity() - this.passengerList.size();
    }


    public void addPassenger(Passenger passenger) {
        if (availableSeats() > 0) {
            this.passengerList.add(passenger);
            passenger.setFlight(Flight.this);
        }
    }


    public double reservedBaggageWeight() {
        return 0.5 * plane.getPlaneType().getTotalWeight();
    }
}
