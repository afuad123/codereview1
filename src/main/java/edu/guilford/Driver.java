package edu.guilford;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        //test the toString method for a tile object
        // Tile tile = new Tile('A', 1);
        // System.out.println(tile.toString());

        //test the getWordValue method
        ScrabbleSet scrabbleSet = new ScrabbleSet("English");   
        System.out.println("Word value for cat: " + scrabbleSet.getWordValue("cat"));
        System.out.println("Word value for dog: " + scrabbleSet.getWordValue("dog"));
        System.out.println("Word value for a: " + scrabbleSet.getWordValue("a"));
        System.out.println("Word value for zoo: " + scrabbleSet.getWordValue("zoo"));
        System.out.println("Word value for zzz: " + scrabbleSet.getWordValue("zzz"));
        System.out.println("Word value for cr''ate:" + scrabbleSet.getWordValue("cr ate"));
        System.out.println("Word value for smørgasbord:" + scrabbleSet.getWordValue("smørgasbord"));


        // //make a new ScrabbleSet
        // ScrabbleSet scrabbleSet = new ScrabbleSet("Spanish");
        // System.out.println(scrabbleSet.toString());
        // //print a break
        // System.out.println(" ");
        // //make an English scrabble set
        // ScrabbleSet scrabbleSet2 = new ScrabbleSet("English");
        // System.out.println(scrabbleSet2.toString());

        // //make a random scrabble set
        // ScrabbleSet scrabbleSet3 = new ScrabbleSet();
        // System.out.println(scrabbleSet3.toString());
    }

}
