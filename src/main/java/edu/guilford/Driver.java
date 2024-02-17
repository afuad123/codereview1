package edu.guilford;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        //test the toString method 
        Tile tile = new Tile('A', 1);
        System.out.println(tile.toString());

        //test the getWordValue method
        // ScrabbleSet scrabbleSet = new ScrabbleSet();
        // System.out.println(scrabbleSet.getWordValue("cat"));
        // System.out.println(scrabbleSet.getWordValue("dog"));
        // System.out.println(scrabbleSet.getWordValue("a"));
        // System.out.println(scrabbleSet.getWordValue("zoo"));
        // System.out.println(scrabbleSet.getWordValue("zzz"));


        // //make a new ScrabbleSet
        // ScrabbleSet scrabbleSet = new ScrabbleSet("Spanish");
        // System.out.println(scrabbleSet.toString());
        // //print a break
        // System.out.println(" ");
        // //make an English scrabble set
        // ScrabbleSet scrabbleSet2 = new ScrabbleSet("English");
        // System.out.println(scrabbleSet2.toString());

        //make a random scrabble set
        ScrabbleSet scrabbleSet3 = new ScrabbleSet();
        System.out.println(scrabbleSet3.toString());
    }

}
