import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "FR756", "EDI", "GLA", "1530");
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



}
