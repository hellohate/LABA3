package model;
import exception.*;


public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void volume() throws RectangleCallException {
        throw new RectangleCallException("");
    }

    @Override
    public String toString() {
        return name;
    }
}
