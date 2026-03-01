package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String id;
    private int balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Customer(String id) {
        this.id = id;
    }

    public void addCredits(int credits, String packageName) {
        balance += credits;
        transactions.add(new Transaction("PURCHASE " + packageName, credits, balance, false));
    }

    public void useService(String serviceName, int totalCost) {
        if (balance >= totalCost) {
            balance -= totalCost;
            transactions.add(new Transaction("USAGE " + serviceName, -totalCost, balance, false));
        } else {
            transactions.add(new Transaction("USAGE " + serviceName, -totalCost, balance, true));
        }
    }

    public List<Transaction> getTransactions() { return transactions; }
}