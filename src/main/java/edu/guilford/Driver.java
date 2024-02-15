package edu.guilford;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        //test the toString method 
        Tile tile = new Tile('A', 1);
        System.out.println(tile.toString());

        //test the getWordValue method
        ScrabbleSet scrabbleSet = new ScrabbleSet();
        System.out.println(scrabbleSet.getWordValue("cat"));
        System.out.println(scrabbleSet.getWordValue("dog"));
        System.out.println(scrabbleSet.getWordValue("a"));
        System.out.println(scrabbleSet.getWordValue("zoo"));
        System.out.println(scrabbleSet.getWordValue("zzz"));
    }

}
