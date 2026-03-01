package model;

public class Service {
    private final String name;
    private final int creditCost;

    public Service(String name, int creditCost) {
        this.name = name;
        this.creditCost = creditCost;
    }

    public String getName() { return name; }
    public int getCreditCost() { return creditCost; }
}