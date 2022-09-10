package com.careerdevs.bankaccount;
// checking account
public class CheckingAccount extends Account {

    // Default Transaction Fee
    private static double FEE = 2.5;

    // default contructor
    public CheckingAccount() {
        super();
    }

    // parameter constructor to initialize CheckingAccount with a custom Account
    // Number and a Custom Transaction Fee.
    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    // abstract
    /**
     * Function to deposit funds into the account as long as the amount parameter is
     * > 0
     * Apply Transaction fee for the CheckingAccount
     *
     * @param amount value to be deposited
     */
    public void deposit(double amount) {
        // first check amount
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            // apply transaction fee
            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);
        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    /**
     * Function to withdraw funds from the Account as long as
     * 1. Amount to withdraw must be > 0
     * 2. Amount to withdraw must be <= balance
     *@param amount value to be withdrawn
     */

    public void withdraw(double amount) {

        // same check
        if (amount > 0) {
            // check sufficient balance
            if ((amount+FEE) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f appliedt%n", FEE);
                System.out.printf("Current Balance is: %.2f%n", balance);

            } else {
                System.out.println("Negative amount cannot be withdrawn!");
            }

        }
    }
}
