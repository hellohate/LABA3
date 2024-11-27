package service;

import model.*;
import exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private List<Cottage> cottages;
    private List<Booking> bookings;
    private List<Amenity> hotelAmenities;

    public Hotel() {
        cottages = new ArrayList<>();
        bookings = new ArrayList<>();
        hotelAmenities = new ArrayList<>();
    }

    public void addAmenity(Amenity amenity) {
        hotelAmenities.add(amenity);
    }

    public void addCottage(Cottage cottage) {
        cottages.add(cottage);
    }

    public void bookCottage(Customer customer, Cottage cottage, LocalDate startDate, LocalDate endDate) throws Exception {
        if (bookings.stream().anyMatch(b -> b.getCottage() == cottage && b.overlaps(startDate, endDate))) {
            throw new DuplicateBookingException("Cottage is already booked for the given dates!");
        }
        if (bookings.stream().anyMatch(b -> b.getCustomer() == customer)) {
            throw new InvalidBookingException("Customer already has a booking!");
        }
        bookings.add(new Booking(cottage, customer, startDate, endDate));
    }

    public List<Cottage> findCottagesByAmenity(String amenityName) {
        return cottages.stream()
                .filter(c -> c.getAmenities().stream().anyMatch(a -> a.getName().equalsIgnoreCase(amenityName)))
                .collect(Collectors.toList());
    }

    public double calculateIncome() {
        return bookings.stream().mapToDouble(b -> b.getCottage().calculateCost(isLowSeason(b))).sum();
    }

    private boolean isLowSeason(Booking booking) {
        int month = booking.getStartDate().getMonthValue();
        return month == 3 || month == 11;
    }

    public void printAllBookings() {
        bookings.forEach(System.out::println);
    }
}
