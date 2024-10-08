import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                
                attempts++;
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Out of attempts. The correct number was: " + targetNumber);
            }
            
            System.out.println("Your current score: " + score);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing! Your final score: " + score);
            }
        }
        
        scanner.close();
    }
}
