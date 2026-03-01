package service;

import model.*;

import java.util.HashMap;
import java.util.Map;

public class BillingService {

    private final Map<String, Service> services;
    private final Map<String, CreditPackage> packages;
    private final Map<String, Customer> customers = new HashMap<>();

    public BillingService(Map<String, Service> services,
                          Map<String, CreditPackage> packages) {
        this.services = services;
        this.packages = packages;
    }

    private Customer getCustomer(String id) {
        return customers.computeIfAbsent(id, Customer::new);
    }

    public void processPurchase(String customerId, String packageName) {
        Customer customer = getCustomer(customerId);
        CreditPackage pkg = packages.get(packageName);
        customer.addCredits(pkg.getCredits(), packageName);
    }

    public void processUsage(String customerId, String serviceName, int count) {
        Customer customer = getCustomer(customerId);
        Service service = services.get(serviceName);
        int totalCost = service.getCreditCost() * count;
        customer.useService(serviceName, totalCost);
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }
}