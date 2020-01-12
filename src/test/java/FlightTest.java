import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightTest {

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
        plane = new Plane(PlaneType.BOEING747);
        plane2 = new Plane(PlaneType.RV7A);
        departureTime1 = new Date(2020, 2,20,15,30);
        departureTime2 = new Date(2020, 2,24,13,45);
        flight = new Flight(plane, "FR756", "EDI", "GLA", departureTime1);
        flight2 = new Flight(plane2, "GB241", "GDA", "KRK", departureTime2);
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
    public void shouldAddFlightToPassenger() {
        flight.addPassenger(passenger1);
        assertEquals(flight, passenger1.getFlight());
    }

    @Test
    public void shouldAddSeatNumberToPassenger() {
        flight.addPassenger(passenger1);
        assertTrue(passenger1.getSeatNumber() > 0);
        assertTrue(passenger1.getSeatNumber() <= 200);
    }

    @Test
    public void shouldNotGiveSameSeatNumberToDifferentPassengers() {
        flight2.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        boolean notSameSeat = (passenger1.getSeatNumber() != passenger2.getSeatNumber());
        System.out.println(passenger1.getSeatNumber());
        System.out.println(passenger2.getSeatNumber());
        assertTrue(notSameSeat);
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
