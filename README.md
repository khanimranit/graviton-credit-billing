# Graviton Credit-Based Billing System

## How to Run

1. Place input files in root directory:
   - pricing.csv
   - purchases.csv
   - usage.csv

2. Compile:
   javac -d out src/**/*.java

3. Run:
   java -cp out Main

Output will be generated as output.csv

## Assumptions
- Credits never expire
- No concurrency handling (CLI application)
- Services and Packages are independent