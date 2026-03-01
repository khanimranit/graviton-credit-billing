package model;

public class CreditPackage {
    private final String name;
    private final int credits;
    private final double price;

    public CreditPackage(String name, int credits, double price) {
        this.name = name;
        this.credits = credits;
        this.price = price;
    }

    public String getName() { return name; }
    public int getCredits() { return credits; }
    public double getPrice() { return price; }
}