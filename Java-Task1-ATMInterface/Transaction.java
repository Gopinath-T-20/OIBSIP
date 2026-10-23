package ATMInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime time;

    public Transaction(String type, double amount) {
        this.type =type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    @Override 
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return time.format(fmt) + " | " + type + " | Rs." + amount;
    }
}
