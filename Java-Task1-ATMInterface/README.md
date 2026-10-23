# ATM Interface (Java)

A console-based ATM simulation built in Java using Object-Oriented Programming.
This is **Task 2** of the Oasis Infobyte Java Development Internship (OIBSIP).

## Features

- Login with User ID and PIN (3 attempts allowed)
- Transaction history
- Withdraw money
- Deposit money
- Transfer money between accounts
- Check balance
- Input validation (invalid amount, insufficient balance, wrong receiver ID, non-numeric input)

## Project Structure

| File | Purpose |
|------|---------|
| `Main.java` | Entry point of the program |
| `ATM.java` | Menu and user interaction |
| `Account.java` | Account data, deposit, withdraw and transfer logic |
| `Transaction.java` | Stores details of each transaction |
| `Bank.java` | Stores accounts, handles login and transfers |

## How to Run

Make sure JDK is installed. From the **parent folder** of `ATMInterface`:

```
javac ATMInterface/*.java
java ATMInterface.Main
```

## Demo Login

| User ID | PIN |
|---------|-----|
| user1 | 1234 |
| user2 | 5678 |

## Screenshots

### Login
![Login](screenshots/login.png)

### Deposit and Withdraw
![Deposit and Withdraw](screenshots/deposit-withdraw.png)

### Transfer
![Transfer](screenshots/transfer.png)

### Error Handling
![Error Handling](screenshots/errors.png)

### Transaction History
![Transaction History](screenshots/history.png)

## Concepts Used

- Classes and objects
- Encapsulation
- ArrayList and HashMap
- Exception handling
- Switch case and loops
- Date and time formatting

## Author

**Gopinath T**