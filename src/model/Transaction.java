package model;

public class Transaction {
    private final String description;
    private final int creditChange;
    private final int balanceAfter;
    private final boolean denied;

    public Transaction(String description, int creditChange, int balanceAfter, boolean denied) {
        this.description = description;
        this.creditChange = creditChange;
        this.balanceAfter = balanceAfter;
        this.denied = denied;
    }

    @Override
    public String toString() {
        return description + "," + creditChange + "," + balanceAfter + "," +
                (denied ? "DENIED" : "SUCCESS");
    }
}