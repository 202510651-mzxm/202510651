// My roll number: 202510651

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int pin = 1234;
        int enteredPin;
        int attempts = 0;
        boolean login = false;

        double balance = 1000;

        String[] history = new String[100];
        int count = 0;

        // Login
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            enteredPin = input.nextInt();

            if (enteredPin == pin) {
                login = true;
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Wrong PIN!");
            }
        }

        if (login) {

            int choice = 0;

            while (choice != 5) {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Your balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double deposit = input.nextDouble();

                        if (deposit > 0) {
                            balance += deposit;

                            history[count] = "Deposited: " + deposit;
                            count++;

                            System.out.println("Deposit successful!");
                        } else {
                            System.out.println("Invalid amount!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdraw = input.nextDouble();

                        if (withdraw > 0 && withdraw <= balance) {
                            balance -= withdraw;

                            history[count] = "Withdrawn: " + withdraw;
                            count++;

                            System.out.println("Withdrawal successful!");
                        } else {
                            System.out.println("Insufficient balance or invalid amount!");
                        }
                        break;

                    case 4:
                        System.out.println("Transaction History:");

                        for (int i = 0; i < count; i++) {
                            System.out.println(history[i]);
                        }

                        if (count == 0) {
                            System.out.println("No transactions yet.");
                        }
                        break;

                    case 5:
                        System.out.println("Thank you for using ATM!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } else {
            System.out.println("Your account is locked!");
        }

        input.close();
    }
}