package TravelApp.components;

import java.util.ArrayList;
import java.util.List;

// Class representing a passenger
public class Passenger {
    private final String name;
    private final int passengerNumber;
    private final PassengerType type;
    private double balance;
    private final List<Activity> activities;

    public Passenger(String name, int passengerNumber, PassengerType type, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.balance = balance;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public PassengerType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = Math.max(0.0, balance);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        if (!activities.contains(activity) && activity!=null && activities.size() < activity.getCapacity()) {
            activities.add(activity);
    }
    }
}
