package com.careerdevs.bankaccount;

import java.util.Scanner;

public class AccountDriver {

    // entry point of program
    public void main(String [] args) {
        Scanner keyboard = new Scanner(System.in);

        // Create array of Accounts
        Account accounts [] = new Account[10];
        int numAccounts = 0;

        int choice;
        do {
            choice = menu(keyboard);
            System.out.println();
            if(choice == 1) {
                accounts[numAccounts++] = createAccount(keyboard);
            } else if (choice == 2) {
                doDeposit(accounts, numAccounts, keyboard);
            } else if (choice == 3) {
                doWithdraw(accounts, numAccounts, keyboard);
            } else if (choice == 4) {
                applyInterest(accounts, numAccounts, keyboard);
            } else {
                System.out.println("GoodBye!");
            }
            System.out.println();
        } while(choice != 5);
    }

    // account choice
    // @param keyboard
    // @return
    public static int accountMenu(Scanner keyboard) {
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 2);
        return choice;
    }

    public static int searchAccount(Account accounts[], int count, int accountNumber) {
        for(int i=0; i<count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    // Function to perform Deposit on a selected account
    public static void doDeposit(Account accounts [], int count, Scanner keyboard) {
        // get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // amount
            System.out.print("Please enter Deposit Amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exists with Accountnumber: " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {
        // get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count,accountNumber);

        if(index >= 0) {
            // amount
            System.out.print("Please enter Withdraw Amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].withdraw(amount);
        } else {
            System.out.println("No account exists with Accountnumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts [], int count, Scanner keyboard) {
        // get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count,accountNumber);

        if(index >= 0) {

            // must be instance of savings account

            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No account exists with Accountnumber: " + accountNumber);
        }
    }

    // function to create a new account
    public static Account createAccount(Scanner keyboard) {

        Account account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print("Enter Account Number: ");
        accountNumber = keyboard.nextInt();

        if(choice == 1) { // checking account
            System.out.print("Enter Transaction Fee: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else { // savings account
            System.out.print("Please enter Interest Rate: ");
            double ir = keyboard.nextDouble();
            account = new SavingsAccount(accountNumber, ir);
        }
        return account;
    }

    // Menu to display options and get the user's selection
    // @param keyboard
    // @return choice
    public int menu(Scanner keyboard) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 5);
        return choice;
    }
}
