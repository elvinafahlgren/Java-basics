package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The TicTacToe Game
 *  See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *
 *  This is exercising functional decomposition and testing
 *  - Any non trivial method should be tested (in test() method far below)
 *  - IO methods never tested.
 *
 *  NOTE: Just use an array for the board (we print it to look square, see plotBoard())
 *
 */
public class Ex9TicTacToe {

    public static void main(String[] args) {
        new Ex9TicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';        // This is so that we easy can change the value in one place

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("fia", 'O');
        Player current = null;         // For now
        Player winner = null;
        char[] board = createBoard();  // alt. { EMPTY, EMPTY, ... }

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        // TODO Add game logic here (use smallest step and functional decomposition)
        for(int i = 0; i < 9; i++){

            if(i % 2 == 0){
                current = p1;
            }
            else{
                current = p2;
            }
            int selection = getPlayerSelection(current);
            while(checkSelection(board, selection) == false) {
                out.println("Bad move, insert again");
                selection = getPlayerSelection(current);
            }
            board = insertSelection(board, selection, current);
            plotBoard(board);

            if(winnerCheck(board)){
                winner = current;
                break;
            }
        }

        out.println("Game over!");
        plotBoard(board);

        if (winner != null) {
            out.println("Winner is " + winner.name);
        } else {
            out.println("Draw");
        }
    }


    // ---------- Methods below this ----------------

    // TODO More methods

    char[] createBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
        return board;
    }

    char[] insertSelection(char[] board, int selection, Player player){
        board[selection] = player.mark;
        return board;
    }

    boolean checkSelection(char[] board, int selection){
        if(board[selection] == EMPTY){
            return true;
        }
        return false;
    }

    boolean winnerCheck(char[] board){
        for (int i = 0; i < board.length; i += 3) {
            if (board[i] == board[i + 1] && board[i] == board[i + 2] && board[i] != EMPTY) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i + 3] && board[i] == board[i + 6] && board[i] != EMPTY) {
                return true;
            }
        }

        if (board[0] == board[4] && board[0] == board[8] && board[0] != EMPTY) {
            return true;
        }

        else if (board[2] == board[4] && board[2] == board[6] && board[2] != EMPTY) {
            return true;
        }
        return false;
    }

    int getPlayerSelection(Player player) {
        int selection;
        while (true) {
            out.println("Player is " + player.name + "(" + player.mark + ")");
            out.print("Select position to put mark (0-8) > ");
            selection = sc.nextInt();
            if (0 <= selection && selection <= 8) {
                break;
            }
            out.println("Bad choice (0-8 allowed)");
        }
        return selection;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark;
        Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }
    }

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        char[] b = createBoard();
        out.println(b.length == 9);

        // TODO More tests

        exit(0);
    }
}