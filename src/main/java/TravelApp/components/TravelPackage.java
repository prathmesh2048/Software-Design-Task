package TravelApp.components;

import java.util.ArrayList;
import java.util.List;

// Class representing a travel package
public class TravelPackage {
    private final String name;
    private final int passengerCapacity;
    private final List<Destination> destinations;
    private final List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addDestination(Destination destination) {
        if (destination != null) {
            destinations.add(destination);
        }
    }

    public void addPassenger(Passenger passenger) {
        if(passenger != null) passengers.add(passenger);
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: $" + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger Name: " + passenger.getName() + ", Passenger Number: " +
                    passenger.getPassengerNumber());
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        StringBuilder details = new StringBuilder();
        details.append("Details of passenger ").append(passenger.getName()).append(" (#").append(passenger.getPassengerNumber()).append("):\n");
        if (passenger.getType() == PassengerType.STANDARD || passenger.getType() == PassengerType.GOLD) {
            details.append("- Balance: $").append(passenger.getBalance()).append("\n");
        }
        details.append("- Activities:\n");
        if (passenger.getActivities().isEmpty()) {
            details.append("No activities signed up\n");
        } else {
            for (Activity activity : passenger.getActivities()) {
                details.append("- ").append(activity.getName()).append(" at ").append(getDestinationName(activity))
                        .append(" - Price Paid: $").append(getActivityPrice(passenger, activity)).append("\n");
            }
        }
        System.out.print(details.toString());
    }


    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getAvailableSpace() > 0) {
                    System.out.println("Activity: " + activity.getName() + ", Destination: " +
                            destination.getName() + ", Available Spaces: " + activity.getAvailableSpace());
                }
            }
        }
    }

    private String getDestinationName(Activity activity) {
        for (Destination destination : destinations) {
            if (destination.getActivities().contains(activity)) {
                return destination.getName();
            }
        }
        return "";
    }

    private double getActivityPrice(Passenger passenger, Activity activity) {
        double price = activity.getCost();
        if (passenger.getType() == PassengerType.GOLD) {
            price *= 0.9; // Apply 10% discount for gold passengers
        }
        return price;
    }
}
