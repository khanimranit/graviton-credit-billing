import model.*;
import processor.FileProcessor;
import service.BillingService;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        Map<String, Service> services = FileProcessor.loadServices("pricing.csv");
        Map<String, CreditPackage> packages = FileProcessor.loadPackages("pricing.csv");

        BillingService billingService = new BillingService(services, packages);

        FileProcessor.processPurchases("purchases.csv", billingService);
        FileProcessor.processUsage("usage.csv", billingService);

        FileProcessor.generateOutput("output.csv", billingService.getCustomers());

        System.out.println("Processing completed. Check output.csv");
    }
}