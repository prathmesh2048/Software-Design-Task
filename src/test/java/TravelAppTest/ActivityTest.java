package TravelAppTest;

import TravelApp.components.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    @Test
    public void testGetName() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        assertEquals("Hiking", activity.getName());
    }

    @Test
    public void testGetDescription() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        assertEquals("Enjoy a hike in the mountains", activity.getDescription());
    }

    @Test
    public void testGetCost() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        assertEquals(50.0, activity.getCost(), 0.001);
    }

    @Test
    public void testGetCapacity() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        assertEquals(20, activity.getCapacity());
    }

    @Test
    public void testGetAvailableSpace() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        assertEquals(20, activity.getAvailableSpace());
    }

    @Test
    public void testDecrementAvailableSpace() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        activity.decrementAvailableSpace();
        assertEquals(19, activity.getAvailableSpace());
    }

    @Test
    public void testDecrementAvailableSpace_Negative() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 0);
        activity.decrementAvailableSpace(); // Attempt to decrement available space when capacity is already 0
        assertEquals(0, activity.getAvailableSpace());
    }

    @Test
    public void testDecrementAvailableSpace_AtCapacity() {
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 1);
        activity.decrementAvailableSpace();
        assertEquals(0, activity.getAvailableSpace());
        activity.decrementAvailableSpace(); // Attempt to decrement available space when capacity is already reached
        assertEquals(0, activity.getAvailableSpace());
    }
}
