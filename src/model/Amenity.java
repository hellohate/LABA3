package model;

public class Amenity {
    private String name;
    private double cost;
    private int additionalGuests;

    public Amenity(String name, double cost, int additionalGuests) {
        this.name = name;
        this.cost = cost;
        this.additionalGuests = additionalGuests;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getAdditionalGuests() {
        return additionalGuests;
    }

    @Override
    public String toString() {
        return name + " (Cost: " + cost + ", Extra Guests: " + additionalGuests + ")";
    }
}
