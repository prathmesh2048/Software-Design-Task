package TravelApp.components;

// Class representing an activity
public class Activity {
    private final String name;
    private final String description;
    private final double cost;
    private final int capacity;
    private int availableSpace;

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.availableSpace = capacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSpace() {
        return availableSpace;
    }

    public void decrementAvailableSpace() {
        if (availableSpace > 0) {
            availableSpace--;
        }
    }
}
