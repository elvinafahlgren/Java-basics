import java.util.*;

/*
        Solution to question 7 here.
 */

import java.util.Random;

public class Q7 {

    public static void main(String[] args) {
        new Q7().program();
    }

    final Random rand = new Random();

    private void program() {


    }


    class Tile {
        char letter;
        int points;

    }

    class Board {
        boolean put(Tile tile, int row, int col) {
            return true;  // For now don't care.
        }

    }

    class Bag {
        private final List<Tile> tiles;

        Bag(List<Tile> tiles) {
            this.tiles = tiles;
        }

        private boolean isEmpty(){
            if(tiles.size() > 0)
                return false;
            return true;
        }

        public Tile getTile(){
            if(isEmpty())
                return null;
            Tile randTile = tiles.get(rand.nextInt(tiles.size() - 1));
            tiles.remove(randTile);
            return randTile;
        }

    }

    class Rack {
        private final List<Tile> tiles = new ArrayList<>();
        private final int maxTiles = 7;

        public boolean addTile(Tile tile){
            if(tiles.size() == maxTiles)
                return false;
            return tiles.add(tile);
        }

        public Tile remove(int i){
            if(i >= 0 && i <= tiles.size() - 1){
                Tile tile = tiles.get(i);
                tiles.remove(tile);
                return tile;
            }
            return null;
        }

    }

    class Player {
        private final String name;
        private final Rack rack = new Rack();

        Player(String name) {
            this.name = name;
        }

        Rack getRack(){
            return rack;
        }
    }

    class Scrabble {
        private final List<Player> players = new ArrayList<>();
        private final Board board = new Board();
        private Player currentPlayer;
        private final List<Tile> tiles = new ArrayList<>();
        private final Bag bag = new Bag(tiles);

        private boolean addToRack(){
            Tile tile = bag.getTile();
            if(tile == null)
                return false;

            return currentPlayer.getRack().addTile(tile);
        }

        private boolean putOnBoard(int index, int row, int col){
            Tile tile = currentPlayer.getRack().remove(index);
            if(tile == null)
                return false;

            return board.put(tile, row, col); //stämmer inte riktigt
        }



    }


}
