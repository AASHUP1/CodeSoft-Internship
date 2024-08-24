import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random numberGenerator = new Random();

        int minimumValue = 1;
        int maximumValue = 100;
        int attemptsMade = 0;
        int totalScore = 0;
        int roundsPlayed = 0;

        boolean continuePlaying = true;

        while (continuePlaying) {
            int secretNumber = numberGenerator.nextInt(maximumValue - minimumValue + 1) + minimumValue;
            int remainingAttempts = 10;

            System.out.println("Hello Player, Welcome to the Guessing Game!");
            System.out.println("I'm thinking a random number between " + minimumValue + " and " + maximumValue + ".");
            System.out.println("You have " + remainingAttempts + " attempts to guess the number.");

            while (remainingAttempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = userInput.nextInt();

                attemptsMade++;
                remainingAttempts--;

                if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low! You have " + remainingAttempts + " attempts remaining.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Your guess is too high! You have " + remainingAttempts + " attempts remaining.");
                } else {
                    System.out.println(" Congratulations! You guessed the number in " + attemptsMade + " attempts.");
                    totalScore++;
                    break;
                }
            }

            if (remainingAttempts == 0) {
                System.out.println("Sorry, you didn't guess the number. The number was " + secretNumber + ".");
            }

            System.out.println("Your current score is " + totalScore + " out of " + (roundsPlayed + 1) + " rounds.");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = userInput.next().toLowerCase();

            if (playAgainInput.equals("yes")) {
                roundsPlayed++;
                attemptsMade = 0;
            } else {
                continuePlaying = false;
            }
        }

        System.out.println("Thanks for playing! Your final score is " + totalScore + " out of " + (roundsPlayed + 1) + " rounds.");
        userInput.close();
    }
}