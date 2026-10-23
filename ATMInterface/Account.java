package ATMInterface;

import java.util.ArrayList;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> history;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public boolean deposit (double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        history.add(new Transaction("Deposit", amount));
        return true;
    }

    public boolean withdraw (double amount) {
        if(amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        history.add(new Transaction("Withdraw", amount));
        return true;
    }

    public boolean transferOut(double amount, String toUserId) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        history.add(new Transaction("Transfer Out to " + toUserId, amount));
        return true;
    }

    public void transferIn(double amount, String fromUserId) {
        balance += amount;
        history.add(new Transaction("Transfer In from " + fromUserId, amount));
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }
}
