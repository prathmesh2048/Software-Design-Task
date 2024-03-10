package TravelAppTest;

import TravelApp.components.Activity;
import TravelApp.components.Passenger;
import TravelApp.components.PassengerType;
import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerTest {

    @Test
    public void testGetName() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        assertEquals("John", passenger.getName());
    }

    @Test
    public void testGetPassengerNumber() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        assertEquals(1, passenger.getPassengerNumber());
    }

    @Test
    public void testGetType() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        assertEquals(PassengerType.STANDARD, passenger.getType());
    }

    @Test
    public void testGetBalance() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        assertEquals(200.0, passenger.getBalance(), 0.001);
    }

    @Test
    public void testSetBalance() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        passenger.setBalance(300.0);
        assertEquals(300.0, passenger.getBalance(), 0.001);
    }

    @Test
    public void testSetBalance_Negative() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        passenger.setBalance(-100.0);
        assertEquals(0.0, passenger.getBalance(), 0.001);
    }

    @Test
    public void testAddActivity() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        passenger.addActivity(activity);
        assertTrue(passenger.getActivities().contains(activity));
    }

    @Test
    public void testAddActivity_NullActivity() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        passenger.addActivity(null);
        assertEquals(0, passenger.getActivities().size());
    }

    @Test
    public void testAddActivity_DuplicateActivity() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        passenger.addActivity(activity);
        passenger.addActivity(activity); // Adding the same activity again
        assertEquals(1, passenger.getActivities().size());
    }

    @Test
    public void testAddActivity_ActivityLimitReached() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 200.0);
        for (int i = 0; i < 25; i++) {
            Activity activity = new Activity("Activity" + i, "Description", 50.0, 20);
            passenger.addActivity(activity);
        }
        Activity extraActivity = new Activity("Extra Activity", "Description", 50.0, 20);
        passenger.addActivity(extraActivity); // Attempt to add more than the capacity
        assertFalse(passenger.getActivities().contains(extraActivity));
    }
}
