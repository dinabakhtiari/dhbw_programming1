package DataType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class FinancialTransactionTracker {
    public static void main(String[] args) {
        //ArrayList<String> transactions = new ArrayList<>();
        HashMap<Integer, String> transactions = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int transId = 1;

        while (true) { 
            System.out.println("\nFinancial Transaction Tracker");
            System.out.println("1. Add Transaction");
            System.out.println("2. Transactions Yesterday");
            System.out.println("3. Total Income and Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter the type : (Purchase/Sale): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter the amount:");
                    double amount = scanner.nextDouble();
                    LocalDate date = LocalDate.now();

                    transactions.put(transId++, type + "," + amount + "," + date);
                    System.out.println("Transaction added.");
                    break;
                    
                case 2: 
                     LocalDate yesterday = LocalDate.now().minusDays(1);
                    int count = 0;
                    for (String transaction : transactions.values()) {
                        String[] parts = transaction.split(",");
                        if (parts[2].equals(yesterday.toString())) {
                            count++;
                        }
                    }
                    System.out.println("Transactions yesterday: " + count);
                    break;


                case 3:
                    double income = 0, expense = 0;
                    for (String transaction : transactions.values()) {
                        String[] parts = transaction.split(",");
                        String tType = parts[0];
                        double tAmount = Double.parseDouble(parts[1]);
                        if (tType.equalsIgnoreCase("Sale")) {
                            income += tAmount;
                        } else if (tType.equalsIgnoreCase("Purchase")) {
                            expense += tAmount;
                        }
                    }
                    System.out.println("Total Income: " + income);
                    System.out.println("Total Expense: " + expense);
                    break;

                case 4:
                    System.out.println("Exiting tracker. Goodbye!");
                    scanner.close();
                    return; 

                default:
                    System.out.println("Invalid choice. Try again.");

            }

        }
    }

}

