package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Utilities to input/output player data for a command line game
 *
 *  See:
 *  - UseAConstructor
 *  - ObjectArrMeth
 *
 */
public class Ex1ReadPlayers {
    public static void main(String[] args) {
        new Ex1ReadPlayers().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        Player[] players = inputPlayers();
        outPlayers(players);
    }

    // This class captures the concept of a Player
    class Player {
        String name;   // A Player has a name and...
        int points;    // ... and points

        // TODO Add a constructor
        Player(String n, int p){
            this.name = n;          //this används för att sätta name till n, inte bara för en input
            this.points = p;

        }
    }

    // ---------- Methods -------------------

     Player[] inputPlayers() {
        // TODO
         out.print("How many players? > ");
         Player[] players = new Player[sc.nextInt()];
         sc.nextLine();

         for(int i = 0; i < players.length; i++) {
             out.print("Name for player " + (i + 1) + " > ");
             players[i] = new Player(sc.nextLine(), 0);
         }

         return players;
    }

    void outPlayers(Player[] players){
       // TODO
        for(int i = 0; i < players.length; i++) {
            out.println("Name " + players[i].name + " points " + players[i].points);
        }
    }


}
