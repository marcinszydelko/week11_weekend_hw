import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "FR756", "EDI", "GLA", "1530");
    }

    @Test
    public void shouldGetNumberOfAvailableSeats() {
        assertEquals(200, flight.availableSeats());
    }

}
