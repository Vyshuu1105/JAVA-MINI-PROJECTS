import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();

        System.out.println("Enter your choice (Rock, Paper, Scissors): ");
        String player = sc.nextLine();
        String computer = choices[rand.nextInt(3)];

        System.out.println("Computer chose: " + computer);

        if (player.equalsIgnoreCase(computer)) {

            System.out.println("It's a tie!");

        } else if (

            (player.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
            (player.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
            (player.equalsIgnoreCase("Scissors") && computer.equals("Paper"))) {
            System.out.println("You win!");

        } else {

            System.out.println("You lose!");

        }
    }
}
