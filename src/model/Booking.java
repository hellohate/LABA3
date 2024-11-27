package model;

import java.time.LocalDate;

public class Booking {
    private Cottage cottage;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(Cottage cottage, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.cottage = cottage;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean overlaps(LocalDate start, LocalDate end) {
        return (start.isBefore(endDate) && end.isAfter(startDate));
    }

    @Override
    public String toString() {
        return "Booking for " + customer + " in " + cottage + " from " + startDate + " to " + endDate;
    }
}
