public class FlightManager {

    public FlightManager() {

    }

    public double bagWeightPerPerson(Flight flight) {
        int planeWeight = flight.getPlane().getPlaneType().getTotalWeight();
        int planeCapacity = flight.getPlane().getPlaneType().getCapacity();
        return (0.5 * planeWeight) / planeCapacity;
    }

    public double bookedBaggage(Flight flight) {
        double singleBagWeight = bagWeightPerPerson(flight);
        double totalBaggageWeight = 0;

        for( Passenger passenger : flight.getPassengerList() ){
            totalBaggageWeight += passenger.getBags() * singleBagWeight;
        }

        return totalBaggageWeight;
    }

    public double remainingReservedWeight(Flight flight) {
        return flight.reservedBaggageWeight() - bookedBaggage(flight);
    }
}
