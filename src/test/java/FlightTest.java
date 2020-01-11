import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Flight flight2;
    private Plane plane;
    private Plane plane2;
    private Passenger passenger1;
    private Passenger passenger2;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.RV7A);
        flight = new Flight(plane, "FR756", "EDI", "GLA", "1530");
        flight2 = new Flight(plane2, "GB241", "GDA", "KRK", "1020");
        passenger1 = new Passenger("John", 2);
        passenger2 = new Passenger("Eugene", 1);
    }

    @Test
    public void shouldGetNumberOfAvailableSeats() {
        assertEquals(200, flight.availableSeats());
    }

    @Test
    public void shouldAddPassengerToFlight() {
        flight.addPassenger(passenger1);
        assertEquals(199, flight.availableSeats());
    }

    @Test
    public void shouldNotAddPassengerToFlightIfCapacityFull() {
        flight2.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        flight2.addPassenger(passenger1);
        assertEquals(0, flight2.availableSeats());
        assertEquals(2, flight2.getPassengerList().size());
    }

    @Test
    public void shouldReturnReservedBaggageWeight() {
        assertEquals(2000.00,flight.reservedBaggageWeight(), 0.01);
    }







}
