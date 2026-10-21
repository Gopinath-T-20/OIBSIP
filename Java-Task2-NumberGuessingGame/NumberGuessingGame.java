import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String playAgain;
        int roundNumber = 0;

        do {
            roundNumber++;
            int targetNumber = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Guess a number (1-100): ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Correct!");
                    System.out.println("Round " + roundNumber + " - guessed in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (guess > targetNumber) {
                    System.out.println("Too High!");
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Too Low!");
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You Lost! The number was: " + targetNumber);
                System.out.println("Round " + roundNumber + " - not guessed within " + maxAttempts + " attempts.");
            }

            System.out.print("Play Again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Goodbye");
    }
}
