package exercises;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.exit;
import static java.lang.System.out;

/*
 *  Simulation of LCR game. See, https://en.wikipedia.org/wiki/LCR_(dice_game)
 */
public class Ex7LCRSimulation {

    public static void main(String[] args) {
        new Ex7LCRSimulation().program();
    }

    final Random rand = new Random();

    void program() {
        //test();        // < --- Uncomment to run tests ---
        //Player current;         // Current player for round
        boolean stop = false;

        // Hard coded data
        final Player[] players = {new Player("olle", 3),
                new Player("fia", 3), new Player("pelle", 3)};
        Player actual = players[0];
        out.println("Simulation starts");
        displayPlayers(players);

        // TODO Runt the simulation
        //current = getRandomPlayer(players);     // Set random player to start

        while (!stop){

            char[] result = new char[actual.chips];     // Char array length of amount of chips

            if(actual.chips > 0) {
                getResult(result);
            }
            displayState(actual, result, players);
        }

    }

    // ---- Logical methods -----------------

    // TODO
    Player getRandomPlayer(Player[] playerArr){
        return playerArr[rand.nextInt(playerArr.length)];
    }

    char[] getResult(char[] result){
        for(int i = 0, i < result.length; i++){

        }
    }

    int rollDice(){
        return rand.nextInt(6)+1;
    }

    // --- IO methods ------------------

    void displayState(Player actual, char[] result, Player[] players) {
        out.print(actual.name + " got ");
        out.println(Arrays.toString(result));
        displayPlayers(players);
    }

    void displayPlayers( Player[] players ){
         for (int i = 0; i < players.length; i++) {
            out.print(players[i].name + ":" + players[i].chips + " ");
        }
        out.println();
    }

    // ------- Class to hold player data -----------

    class Player {
        String name;
        int chips;

        public Player(String name, int chips) {
            this.name = name;
            this.chips = chips;
        }
    }

    // ********************** Testing *************************************''

    void test() {
        // Local hard coded test data
        Player[] players = {new Player("1", 1),
                new Player("2", 2), new Player("3", 3)};

        // TODO Testing

        exit(0);
    }
}
