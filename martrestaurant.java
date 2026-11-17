
// My roll number: 202510651

import java.util.Scanner;

public class martrestaurant {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 1. Variables and Constants

        final double DRINK_PRICE = 15.50;

        String customerName;
        int age;
        double mealPrice;
        int drinks;
        boolean isStudent;
        int serviceRating;

        double drinksCost;
        double subtotal;
        double discount = 0;
        double tip = 0;
        double finalBill;
        int wholeBill;

        // 2. Collect customer information

        System.out.println("===== SMART RESTAURANT =====");

        System.out.print("Enter customer name: ");
        customerName = input.nextLine();

        System.out.print("Enter customer age: ");
        age = input.nextInt();

        System.out.print("Enter meal price: ");
        mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        drinks = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1-5): ");
        serviceRating = input.nextInt();

        // 3. Validate service rating

        if (serviceRating < 1 || serviceRating > 5) {

            System.out.println("ERROR: Invalid service rating!");

        } else {

            // 4. Calculate drinks and subtotal

            drinksCost = drinks * DRINK_PRICE;

            subtotal = mealPrice + drinksCost;

            // 5. Calculate discount

            if (isStudent && age >= 60) {

                discount = subtotal * 0.10;

            } else if (isStudent) {

                discount = subtotal * 0.10;

            } else if (age >= 60) {

                discount = subtotal * 0.05;

            } else {

                discount = 0;
            }

            // 6. Calculate tip

            if (serviceRating == 4 || serviceRating == 5) {

                tip = (subtotal - discount) * 0.10;

            } else {

                tip = 0;
            }

            // 7. Calculate final bill

            finalBill = subtotal - discount + tip;

            // 8. Type casting

            wholeBill = (int) finalBill;

            // 9. Print receipt

            System.out.println("\n===== SMART RESTAURANT RECEIPT =====");

            System.out.println("Customer: " + customerName);

            System.out.printf("Meal Cost: $%.2f%n", mealPrice);

            System.out.printf("Drinks Cost: $%.2f%n", drinksCost);

            System.out.printf("Discount: $%.2f%n", discount);

            System.out.printf("Tip: $%.2f%n", tip);

            System.out.printf("Exact Final Bill: $%.2f%n", finalBill);

            System.out.println("Whole Amount: $" + wholeBill);

            System.out.println("Thank you for visiting!");

        }

        input.close();
    }
}
