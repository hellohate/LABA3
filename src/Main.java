import model.*;
import service.Hotel;
import exception.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Hotel hotel = new Hotel();

            hotel.addAmenity(new Amenity("WiFi", 10.0, 0));
            hotel.addAmenity(new Amenity("SPA", 50.0, 0));

            Cottage standard = new Cottage("Standard", 2, 100.0);
            Cottage deluxe = new Cottage("Deluxe", 3, 200.0);
            standard.addAmenity(new Amenity("Sofa Bed", 20.0, 1));

            hotel.addCottage(standard);
            hotel.addCottage(deluxe);

            Customer customer1 = new Customer("John Doe");
            hotel.bookCottage(customer1, standard, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 15));

            System.out.println("Cottages with WiFi:");
            hotel.findCottagesByAmenity("WiFi").forEach(System.out::println);

            hotel.printAllBookings();

            System.out.println("Total income: " + hotel.calculateIncome());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}