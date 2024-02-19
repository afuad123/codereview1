package edu.guilford;

import java.util.ArrayList;
import java.util.Random;
/**
 * This is a class definition file for the "ScrabbleSet" class which defines a ScrabbleSet object.
 * @see Tile
 * @see TileInSet
 */
public class ScrabbleSet {
    //ATTRIBUTES
    /**
     * An ArrayList type attribute of TileInSet objects for the tiles in the set
     */
    private ArrayList<TileInSet> tiles = new ArrayList<TileInSet>();
    /**
     * A Random type attribute for generating random numbers
     */
    private Random rand = new Random();

    //CONSTRUCTORS
    /**
     * Makes a constructor that takes a language as a parameter and defines tiles with values and count accordingly
     * @param language the language to set the ScrabbleSet to
     */
    public ScrabbleSet(String language) {

        tiles.add(new TileInSet(new Tile('A', 1), 9));
        tiles.add(new TileInSet(new Tile('B', 3), 2));
        tiles.add(new TileInSet(new Tile('C', 3), 2));
        tiles.add(new TileInSet(new Tile('D', 2), 4));
        tiles.add(new TileInSet(new Tile('E', 1), 12));
        tiles.add(new TileInSet(new Tile('F', 4), 2));
        tiles.add(new TileInSet(new Tile('G', 2), 3));
        tiles.add(new TileInSet(new Tile('H', 4), 2));
        tiles.add(new TileInSet(new Tile('I', 1), 9));
        tiles.add(new TileInSet(new Tile('J', 8), 1));
        tiles.add(new TileInSet(new Tile('K', 5), 1));
        tiles.add(new TileInSet(new Tile('L', 1), 4));
        tiles.add(new TileInSet(new Tile('M', 3), 2));
        tiles.add(new TileInSet(new Tile('N', 1), 6));
        tiles.add(new TileInSet(new Tile('O', 1), 8));
        tiles.add(new TileInSet(new Tile('P', 3), 2));
        tiles.add(new TileInSet(new Tile('Q', 10), 1));
        tiles.add(new TileInSet(new Tile('R', 1), 6));
        tiles.add(new TileInSet(new Tile('S', 1), 4));
        tiles.add(new TileInSet(new Tile('T', 1), 6));
        tiles.add(new TileInSet(new Tile('U', 1), 4));
        tiles.add(new TileInSet(new Tile('V', 4), 2));
        tiles.add(new TileInSet(new Tile('W', 4), 2));
        tiles.add(new TileInSet(new Tile('X', 8), 1));
        tiles.add(new TileInSet(new Tile('Y', 4), 2));
        tiles.add(new TileInSet(new Tile('Z', 10), 1));
        tiles.add(new TileInSet(new Tile(' ', 0), 2));

        int totalTiles = 0;
        for (TileInSet tile : tiles) {
            totalTiles += tile.count;
        }
        if (totalTiles != 100) {
            System.out.println("Error: Number of tiles does not add up to 100.");
        }

    }

    public ScrabbleSet() {
        tiles.add(new TileInSet(new Tile('A', 1), 1));
        tiles.add(new TileInSet(new Tile('B', 3), 1));
        tiles.add(new TileInSet(new Tile('C', 3), 1));
        tiles.add(new TileInSet(new Tile('D', 2), 1));
        tiles.add(new TileInSet(new Tile('E', 1), 1));
        tiles.add(new TileInSet(new Tile('F', 4), 1));
        tiles.add(new TileInSet(new Tile('G', 2), 1));
        tiles.add(new TileInSet(new Tile('H', 4), 1));
        tiles.add(new TileInSet(new Tile('I', 1), 1));
        tiles.add(new TileInSet(new Tile('J', 8), 1));
        tiles.add(new TileInSet(new Tile('K', 5), 1));
        tiles.add(new TileInSet(new Tile('L', 1), 1));
        tiles.add(new TileInSet(new Tile('M', 3), 1));
        tiles.add(new TileInSet(new Tile('N', 1), 1));
        tiles.add(new TileInSet(new Tile('O', 1), 1));
        tiles.add(new TileInSet(new Tile('P', 3), 1));
        tiles.add(new TileInSet(new Tile('Q', 10), 1));
        tiles.add(new TileInSet(new Tile('R', 1), 1));
        tiles.add(new TileInSet(new Tile('S', 1), 1));
        tiles.add(new TileInSet(new Tile('T', 1), 1));
        tiles.add(new TileInSet(new Tile('U', 1), 1));
        tiles.add(new TileInSet(new Tile('V', 4), 1));
        tiles.add(new TileInSet(new Tile('W', 4), 1));
        tiles.add(new TileInSet(new Tile('X', 8), 1));
        tiles.add(new TileInSet(new Tile('Y', 4), 1));
        tiles.add(new TileInSet(new Tile('Z', 10), 1));
        tiles.add(new TileInSet(new Tile(' ', 0), 1));

        for (int i = 0; i < 73; i++) {
            int addChar = rand.nextInt(26);
            tiles.get(addChar).setCount(tiles.get(addChar).getCount() + 1);

        }
        int totalTiles = 0;
        for (TileInSet tile : tiles) {
            totalTiles += tile.count;
        }
        if (totalTiles != 100) {
            System.out.println("Error: Number of tiles does not add up to 100.");
        }

    }
    //METHODS
    /**
     * Makes a method that returns a string representation of the ScrabbleSet
     * @return a string representation of the ScrabbleSet
     */
    public String toString() {
        String result = "";
        for (TileInSet tile : tiles) {
            result += tile.tile.getLetter() + " " + tile.tile.getValue() + " " + tile.count + "\n";
        }
        return result;
    }
    /**
     * Makes a method that takes a word as a parameter and returns the value of the word
     * @param word the word to get the value of, as a string
     * @return the value of the word in points
     */
    public int getWordValue(String word) {
        int wordValue = 0;
        word = word.toUpperCase();

        for (TileInSet tile : tiles) {
            tile.setUsed(0);
        }

        for (int i = 0; i < word.length(); i++) {
            boolean found = false;
            for (TileInSet tile : tiles) {
                if (word.charAt(i) == tile.tile.getLetter()) {
                    found = true;
                    if (tile.getUsed() < tile.getCount()) {
                        tile.setUsed(tile.getUsed() + 1);
                        wordValue += tile.tile.getValue();
                    } else {
                        System.out.println("Error: Not enough tiles for word.");
                        return 0;
                    }
                }
            }
            if (!found) {
                System.out.println("Error: Invalid word.");
                return 0;
            }
        }
        return wordValue;
    }

    private class TileInSet {
        //ATTRIBUTES
        /**
         * A Tile type attribute for the tile
         */
        private Tile tile;
        /**
         * An integer attribute for the count of the tile (how many tiles of that type are in the set)
         */
        private int count;
        /** 
         * An integer attribute for the number of tiles of one type of letter used
         */
        private int used;

        //CONSTRUCTORS
        /**
         * Makes a constructor that takes a tile and a count as parameters to create a TileInSet object
         * @param tile the tile to set the TileInSet to
         * @param count the count to set the TileInSet to (how many tiles of that type are in the set)
         */
        public TileInSet(Tile tile, int count) {
            this.tile = tile;
            this.count = count;
            this.used = 0;
        }

        //GETTERS AND SETTERS
        /**
         * Makes a getter for the tile attribute
         * @return the tile
         */
        public Tile getTile() {
            return tile;
        }
        /**
         * Makes a setter for the tile attribute
         * @param tile the tile to set
         */
        public void setTile(Tile tile) {
            this.tile = tile;
        }
        /**
         * Makes a getter for the count attribute
         * @return the count
         */
        public int getCount() {
            return count;
        }
        /**
         * Makes a setter for the count attribute
         * @param count the count to set
         */
        public void setCount(int count) {
            this.count = count;
        }

        /**
         * Makes a getter for the used attribute
         * @return the number of used tiles
         */
       
        public int getUsed() {
            return used;
        }
        /**
         * Makes a setter for the used attribute
         * @param used the number of used tiles to set
         */
        public void setUsed(int used) {
            this.used = used;
        }

    }

}