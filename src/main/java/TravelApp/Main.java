package TravelApp;

import TravelApp.components.*;

public class Main {
    public static void main(String[] args) {

        Activity hiking = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        Activity snorkeling = new Activity("Snorkeling", "Explore the underwater world", 80.0, 15);
        Activity sightseeing = new Activity("Sightseeing", "Visit historical landmarks", 30.0, 25);


        Destination mountains = new Destination("Mountains");
        mountains.addActivity(hiking);

        Destination beach = new Destination("Beach");
        beach.addActivity(snorkeling);

        Destination city = new Destination("City");
        city.addActivity(sightseeing);


        TravelPackage package1 = new TravelPackage("Adventure Package", 30);
        package1.addDestination(mountains);
        package1.addDestination(beach);
        package1.addDestination(city);


        Passenger passenger1 = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        Passenger passenger2 = new Passenger("Alice", 2, PassengerType.GOLD, 500.0);
        Passenger passenger3 = new Passenger("Bob", 3, PassengerType.PREMIUM, 0.0);


        package1.addPassenger(passenger1);
        package1.addPassenger(passenger2);
        package1.addPassenger(passenger3);


        package1.printItinerary();
        package1.printPassengerList();
        package1.printPassengerDetails(passenger1);
        package1.printAvailableActivities();
    }
}
