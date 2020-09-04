package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * The Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * This is exercising smallest step programming (no methods needed)
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 */
public class Ex7RPS {

    public static void main(String[] args) {
        new Ex7RPS().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds

        // All code here ... (no method calls)

        out.println("Welcome to Rock, Paper and Scissors");

        // TODO Write the game here. Use smallest step then surround with loop!!!!

        for (int i = 0; i <= maxRounds; i++){
            out.print("Select 1, 2 or 3 (for R, P or S) > ");
            human = sc.nextInt();
            computer = rand.nextInt((3)) + 1;

            out.println("Computer choose " + computer);

            if ( (human == 1 && computer == 3) || (human == 2 && computer == 1) || (human == 3 && computer == 2) ){
                out.println("You won!");
                total++;
            }
            else if ( (computer == 1 && human == 3) || (computer == 2 && human == 1) || (computer == 3 && human == 2) ){
                out.println("You lose:(");

                if (total - 1 >= 0){
                    total--;
                }
            }
            else if ( human == computer){
                out.println("A draw.");
            }

            out.println("Result: " + total);
        }


        out.println("Game over! ");

        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}
