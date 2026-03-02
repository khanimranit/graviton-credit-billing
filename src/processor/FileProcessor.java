package processor;

import model.*;
import service.BillingService;

import java.io.*;
import java.util.*;

public class FileProcessor {

    public static Map<String, Service> loadServices(String file) throws Exception {
        Map<String, Service> services = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if ("SERVICE".equals(parts[0])) {
                services.put(parts[1], new Service(parts[1], Integer.parseInt(parts[2])));
            }
        }
        br.close();
        return services;
    }

    public static Map<String, CreditPackage> loadPackages(String file) throws Exception {
        Map<String, CreditPackage> packages = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if ("PACKAGE".equals(parts[0])) {
                packages.put(parts[1],
                        new CreditPackage(parts[1],
                                Integer.parseInt(parts[2]),
                                Double.parseDouble(parts[3])));
            }
        }
        br.close();
        return packages;
    }

    public static void processPurchases(String file, BillingService service) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            service.processPurchase(parts[0], parts[1]);
        }
        br.close();
    }

    public static void processUsage(String file, BillingService service) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            service.processUsage(parts[0], parts[1], Integer.parseInt(parts[2]));
        }
        br.close();
    }

    public static void generateOutput(String file, Map<String, Customer> customers) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            bw.write("CUSTOMER: " + entry.getKey());
            bw.newLine();
            for (Transaction t : entry.getValue().getTransactions()) {
                bw.write(t.toString());
                bw.newLine();
            }
            bw.newLine();
        }
        bw.close();
    }
}