package TravelApp.components;
import java.util.ArrayList;
import java.util.List;

// Class representing a destination
public class Destination {
    private final String name;
    private final List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        if(activity != null) activities.add(activity);
    }
}
