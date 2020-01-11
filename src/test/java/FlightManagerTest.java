import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Flight flight2;
    private Plane plane;
    private Plane plane2;
    private Passenger passenger1;
    private Passenger passenger2;
    private Date departureTime1;
    private Date departureTime2;

    @Before
    public void before() {
        flightManager = new FlightManager();
        plane = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.RV7A);
        departureTime1 = new Date(2020, 2,20,15,30);
        departureTime2 = new Date(2020, 2,24,13,45);
        flight = new Flight(plane, "FR756", "EDI", "GLA", departureTime1);
        flight2 = new Flight(plane2, "GB241", "GDA", "KRK", departureTime2);
        passenger1 = new Passenger("John", 2);
        passenger2 = new Passenger("Eugene", 1);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
    }

    @Test
    public void shouldCalculateReservedBaggageWeightPerPassenger() {
        assertEquals(10.00,flightManager.bagWeightPerPerson(flight), 0.01);
    }

    @Test
    public void shouldCalculateWeightOfBookedBaggage() {
        assertEquals(30.00, flightManager.bookedBaggage(flight), 0.01);
    }

    @Test
    public void shouldCalculateRemainingWeightReserved() {
        assertEquals( 1970.00, flightManager.remainingReservedWeight(flight), 0.01);
    }




}
