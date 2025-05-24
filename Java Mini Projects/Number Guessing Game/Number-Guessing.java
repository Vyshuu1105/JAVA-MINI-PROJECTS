import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberGame {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 1000;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GuessNumberGame game = new GuessNumberGame();

    boolean playAgain = true;

    while (playAgain) {

      game.startGame(scanner); 
      System.out.print("Do you want to play again? (y/n): ");
      String choice = scanner.next().trim().toLowerCase();
      playAgain = choice.equals("y"); 

    }

    System.out.println("Thanks for playing! Goodbye..");
    scanner.close();

  }

  public void startGame(Scanner scanner) {
    boolean isUserGuessCorrect = false;
    int numberOfGuesses = 0;
    int computerNumber = getNumberByComputer();

    while (!isUserGuessCorrect) {
      int userNumber = getUserGuessedNumber(scanner);
      numberOfGuesses++;

      if (userNumber > computerNumber) {

        System.out.println("Too high! Try again.");

      } else if (userNumber < computerNumber) {

        System.out.println("Too low! Try again.");

      } else {

        System.out.println("Congratulations! You guessed the correct number.");
        isUserGuessCorrect = true;

      }
    }

    System.out.println("You found the number in " + numberOfGuesses + " guesses.");
  }

  public int getNumberByComputer() {

    return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);

  }

  public int getUserGuessedNumber(Scanner scanner) {

    int userNumber;
    while (true) {

      System.out.print("Please guess the number (" + MIN_NUMBER + " to " + MAX_NUMBER + "): ");
      if (scanner.hasNextInt()) {

        userNumber = scanner.nextInt();

        if (userNumber >= MIN_NUMBER && userNumber <= MAX_NUMBER) {
          break;

        } else {

          System.out.println("Enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER);

        }
      } else {

        System.out.println("Invalid input. Please enter a valid number.");
        scanner.next(); 

      }
    }

    return userNumber;

  }
}
