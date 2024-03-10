package TravelAppTest;

import TravelApp.components.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TravelPackageTest {

    @Test
    public void testGetName() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        assertEquals("Mountain Adventure", travelPackage.getName());
    }

    @Test
    public void testGetPassengerCapacity() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        assertEquals(50, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testGetDestinations_Empty() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        List<Destination> destinations = travelPackage.getDestinations();
        assertNotNull(destinations);
        assertTrue(destinations.isEmpty());
    }

    @Test
    public void testGetDestinations_NonEmpty() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        Destination destination1 = new Destination("Mountain Resort");
        Destination destination2 = new Destination("Ski Lodge");
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);
        List<Destination> destinations = travelPackage.getDestinations();
        assertNotNull(destinations);
        assertEquals(2, destinations.size());
        assertTrue(destinations.contains(destination1));
        assertTrue(destinations.contains(destination2));
    }

    @Test
    public void testGetPassengers_Empty() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        List<Passenger> passengers = travelPackage.getPassengers();
        assertNotNull(passengers);
        assertTrue(passengers.isEmpty());
    }

    @Test
    public void testGetPassengers_NonEmpty() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        Passenger passenger1 = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        Passenger passenger2 = new Passenger("Alice", 2, PassengerType.GOLD, 300.0);
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        List<Passenger> passengers = travelPackage.getPassengers();
        assertNotNull(passengers);
        assertEquals(2, passengers.size());
        assertTrue(passengers.contains(passenger1));
        assertTrue(passengers.contains(passenger2));
    }

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        Destination destination = new Destination("Mountain Resort");
        travelPackage.addDestination(destination);
        List<Destination> destinations = travelPackage.getDestinations();
        assertNotNull(destinations);
        assertEquals(1, destinations.size());
        assertTrue(destinations.contains(destination));
    }

    @Test
    public void testAddDestination_NullDestination() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        travelPackage.addDestination(null);
        List<Destination> destinations = travelPackage.getDestinations();
        assertNotNull(destinations);
        assertTrue(destinations.isEmpty());
    }

    @Test
    public void testAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        travelPackage.addPassenger(passenger);
        List<Passenger> passengers = travelPackage.getPassengers();
        assertNotNull(passengers);
        assertEquals(1, passengers.size());
        assertTrue(passengers.contains(passenger));
    }

    @Test
    public void testAddPassenger_NullPassenger() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        travelPackage.addPassenger(null);
        List<Passenger> passengers = travelPackage.getPassengers();
        assertNotNull(passengers);
        assertTrue(passengers.isEmpty());
    }

    @Test
    public void testPrintPassengerDetails() {
        TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        travelPackage.addPassenger(passenger);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        travelPackage.printPassengerDetails(passenger);
        String expectedOutput = "Details of passenger John (#1):\n" +
                "- Balance: $200.0\n" +
                "- Activities:\n" +
                "No activities signed up\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
