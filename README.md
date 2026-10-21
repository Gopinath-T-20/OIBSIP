# 🎯 Number Guessing Game

**Oasis Infobyte Internship — Java Development Track — Task 2**

## 📋 Objective
A console-based Java game where the computer generates a random number between 1 and 100, and the user tries to guess it within a limited number of attempts, receiving "Too High" / "Too Low" hints after each guess.

## 🛠️ Tech Stack
- Java (Core)
- `java.util.Random` — random number generation
- `java.util.Scanner` — reading user input

## ✨ Features
- Random number generated in the range 1–100 at the start of each round
- User prompted to enter guesses via console input
- Feedback after every guess: **"Too High!"**, **"Too Low!"**, or **"Correct!"**
- Live attempt counter showing remaining attempts
- Maximum of 7 attempts per round — game ends with a "You Lost!" message revealing the number if the limit is reached
- "Play Again?" prompt after every round (yes/no)
- Round summary displayed after each round: `Round X — guessed in Y attempts`
- Graceful handling of invalid (non-numeric) input

## ▶️ How to Run
1. Clone/download this repository
2. Navigate to the `NumberGuessingGame.java` file
3. Compile:
   ```
   javac NumberGuessingGame.java
   ```
4. Run:
   ```
   java NumberGuessingGame
   ```
5. Follow the on-screen prompts to guess the number

## 🖼️ Sample Output
```
Guess a number (1-100): 50
Too High!
Attempts left: 6
Guess a number (1-100): 25
Too Low!
Attempts left: 5
Guess a number (1-100): 37
Correct! 🎉
Round 1 — guessed in 3 attempts.
Play Again? (yes/no): no
Thanks for playing! Goodbye 👋
```

## 📚 What I Learned
- Working with Java's `Random` and `Scanner` classes
- Control flow using `while` and `do-while` loops
- Conditional logic with `if-else` chains
- Basic input validation and exception handling

## 🙏 Acknowledgment
This project was built as part of the **Oasis Infobyte AICTE Internship Program** (Java Development track).

#oasisinfobyte #java #internship
