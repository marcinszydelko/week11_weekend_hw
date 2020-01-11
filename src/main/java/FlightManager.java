public class FlightManager {

    public FlightManager() {

    }

    public double bagWeightPerPerson(Flight flight) {
        int planeWeight = flight.getPlane().getPlaneType().getTotalWeight();
        int planeCapacity = flight.getPlane().getPlaneType().getCapacity();
        return (0.5 * planeWeight) / planeCapacity;
    }
}
