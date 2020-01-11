import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Flight flight2;
    private Plane plane;
    private Plane plane2;
    private Passenger passenger1;
    private Passenger passenger2;

    @Before
    public void before() {
        flightManager = new FlightManager();
        plane = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.RV7A);
        flight = new Flight(plane, "FR756", "EDI", "GLA", "1530");
        flight2 = new Flight(plane2, "GB241", "GDA", "KRK", "1020");
        passenger1 = new Passenger("John", 2);
        passenger2 = new Passenger("Eugene", 1);
    }

    @Test
    public void shouldCalculateReservedBaggageWeightPerPassenger() {
        assertEquals(10.00,flightManager.bagWeightPerPerson(flight), 0.01);
    }


}
