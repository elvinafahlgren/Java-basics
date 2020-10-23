//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package exercises;

import java.util.Scanner;

public class Ex1ReadPlayers {
    final Scanner sc;

    public Ex1ReadPlayers() {
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        (new Ex1ReadPlayers()).program();
    }

    void program() {
        Ex1ReadPlayers.Player[] players = this.inputPlayers();
        this.outPlayers(players);
    }

    Ex1ReadPlayers.Player[] inputPlayers() {
        System.out.print("How many players? > ");
        Ex1ReadPlayers.Player[] players = new Ex1ReadPlayers.Player[this.sc.nextInt()];
        this.sc.nextLine();

        for(int i = 0; i < players.length; ++i) {
            System.out.print("Name for player " + (i + 1) + " > ");
            players[i] = new Ex1ReadPlayers.Player(this.sc.nextLine(), 0);
        }

        return players;
    }

    void outPlayers(Ex1ReadPlayers.Player[] players) {
        for(int i = 0; i < players.length; ++i) {
            String var10001 = players[i].name;
            System.out.println("Name " + var10001 + " points " + players[i].points);
        }

    }

    class Player {
        String name;
        int points;

        Player(String n, int p) {
            this.name = n;
            this.points = p;
        }
    }
}
