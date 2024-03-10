package TravelAppTest;

import TravelApp.components.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class DestinationTest {

    @Test
    public void testGetName() {
        Destination destination = new Destination("Mountain Resort");
        assertEquals("Mountain Resort", destination.getName());
    }

    @Test
    public void testGetActivities_Empty() {
        Destination destination = new Destination("Mountain Resort");
        List<Activity> activities = destination.getActivities();
        assertNotNull(activities);
        assertTrue(activities.isEmpty());
    }

    @Test
    public void testGetActivities_NonEmpty() {
        Destination destination = new Destination("Mountain Resort");
        Activity activity1 = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        Activity activity2 = new Activity("Skiing", "Ski down the slopes", 100.0, 15);
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        List<Activity> activities = destination.getActivities();
        assertNotNull(activities);
        assertEquals(2, activities.size());
        assertTrue(activities.contains(activity1));
        assertTrue(activities.contains(activity2));
    }

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Mountain Resort");
        Activity activity = new Activity("Hiking", "Enjoy a hike in the mountains", 50.0, 20);
        destination.addActivity(activity);
        List<Activity> activities = destination.getActivities();
        assertNotNull(activities);
        assertEquals(1, activities.size());
        assertTrue(activities.contains(activity));
    }

    @Test
    public void testAddActivity_NullActivity() {
        Destination destination = new Destination("Mountain Resort");
        destination.addActivity(null);
        List<Activity> activities = destination.getActivities();
        assertNotNull(activities);
        assertTrue(activities.isEmpty());
    }
}
