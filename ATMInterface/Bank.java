package ATMInterface;

import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
        // Demo accounts (For Testing)
        addAccount(new Account("user1", "1234", 10000));
        addAccount(new Account("user2", "5678", 5000));
    }

    public void addAccount(Account account) {
        accounts.put(account.getUserId(), account);
    }

    public Account login(String userId, String pin) {
        Account acc = accounts.get(userId);
        if (acc != null && acc.checkPin(pin)) {
            return acc;
        }
        return null;
    }

    public boolean transfer(Account from, String toUserId, double amount) {
        Account to = accounts.get(toUserId);

        if (to == null) {
            return false;  
        }
        if (from.getUserId().equals(toUserId)) {
            return false;   // Self-transfer not applicale
        }
        if (!from.transferOut(amount, toUserId)) {
            return false;
        }
        to.transferIn(amount, from.getUserId());
        return true;
    }
}
