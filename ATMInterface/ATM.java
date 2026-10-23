package ATMInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner sc;
    private Account currentAccount;

    public ATM(Bank bank) {
        this.bank = bank;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("===== WELCOME TO ATM =====");
        if (login()) {
            showMenu();
        }
        System.out.println("Thank you for using our ATM. Goodbye!");
        sc.close();
    }

    private boolean login() {
        int tries = 0;
        while (tries < 3) {
            System.out.print("Enter User ID: ");
            String id = sc.nextLine().trim();
            System.out.print("Enter PIN: ");
            String pin = sc.nextLine().trim();

            currentAccount = bank.login(id, pin);
            if (currentAccount != null) {
                System.out.println("Login successful!");
                return true;
            }
            tries++;
            System.out.println("Invalid User ID or PIN. Attempts left: " + (3 - tries));
        }
        System.out.println("Too many failed attempts. Card blocked!");
        return false;
    }

    private void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    showHistory();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    transfer();
                    break;
                case "5":
                    System.out.println("Current Balance: Rs." + currentAccount.getBalance());
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-6.");
            }
        }
    }

    private double readAmount() {
        System.out.print("Enter amount: ");
        try {
            return Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void showHistory() {
        ArrayList<Transaction> history = currentAccount.getHistory();
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("---- Transaction History ----");
        for (Transaction t : history) {
            System.out.println(t);
        }
    }

    private void withdraw() {
        double amount = readAmount();
        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful! Balance: Rs." + currentAccount.getBalance());
        } else {
            System.out.println("Failed! Invalid amount or insufficient balance.");
        }
    }

    private void deposit() {
        double amount = readAmount();
        if (currentAccount.deposit(amount)) {
            System.out.println("Deposit successful! Balance: Rs." + currentAccount.getBalance());
        } else {
            System.out.println("Failed! Please enter a valid amount.");
        }
    }

    private void transfer() {
        System.out.print("Enter receiver User ID: ");
        String toId = sc.nextLine().trim();
        double amount = readAmount();

        if (bank.transfer(currentAccount, toId, amount)) {
            System.out.println("Transfer successful! Balance: Rs." + currentAccount.getBalance());
        } else {
            System.out.println("Transfer failed! Check receiver ID, amount and balance.");
        }
    }
}