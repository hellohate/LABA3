package model;

import java.util.ArrayList;
import java.util.List;

public class Cottage {
    private String category;
    private int maxGuests;
    private List<Amenity> amenities;
    private double baseCost;

    public Cottage(String category, int maxGuests, double baseCost) {
        this.category = category;
        this.maxGuests = maxGuests;
        this.baseCost = baseCost;
        this.amenities = new ArrayList<>();
    }

    public void addAmenity(Amenity amenity) {
        amenities.add(amenity);
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public int getTotalGuests() {
        return maxGuests + amenities.stream().mapToInt(Amenity::getAdditionalGuests).sum();
    }

    public double calculateCost(boolean isLowSeason) {
        double totalCost = baseCost + amenities.stream().mapToDouble(Amenity::getCost).sum();
        return isLowSeason ? totalCost * 0.8 : totalCost;
    }

    @Override
    public String toString() {
        return category + " (Max Guests: " + getTotalGuests() + ")";
    }
}
