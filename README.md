# SCRABBLESET CODE REVIEW (all review is in bold text)

### Attributes
Allow the object to store the following information:

 - A list of Tile objects for the letters and the blank tile--it should be represented by a space, ' '.
 - A list that provides a count of each letter in the Scrabble set.

 **Contains an ArrayList object named "tiles" that stores all 27 types of tiles. However, there is not a separate list for objects and count, but rather one list with TileInSet object which are constructed to have both the tile type and count contained within it. This format means that there doesn't need to be two array variables to store the different types of info, making the program more efficient and less complicated. Therefore, tiles still checks off both specifications.**

Use arrays or ArrayList objects for each attribute; do not use any other kind of data structures.

**The code correctly uses an ArrayList object.**

### Constructors

 - One constructor should take one parameter, the language for the Scrabble set. At this time, you only need to implement building a Scrabble set for standard English. You can find the count of each tile in Wikipedia, among other places. (This Scrabble set has 100 tiles.)

 **The first defined ScrabbleSet constructor, scrabbleSet(language) takes a String "language" parameter, and builds an English ScrabbleSet accordingly. However, it doesn't specify that the set it builds is specifically for English nor does it provide an alternative output if the parameter is a language either than English.**

 A 1 9
B 3 2
C 3 2
D 2 4
E 1 12

A 1 9
B 3 2
C 3 2
D 2 4
E 1 12

**For example, the above lines of code are the results of printing out a Spanish set first, and then an English set. Both are the same, even though that is incorrect; furthermore, there is no error message returned for the Spanish set (even though that should be done). However, the constructor does have code that prints out an error message if the number of total tiles does not add up to 100. Because no error message was printed out, the constructor satisfies the 100 total tiles specification.**
 - One constructor should take no parameters and build a Scrabble set with each letter having a random value for the count, subject to the following conditions.
    - The total number of tiles must be exactly 100. (1)
    - Each letter (and the blank) must have at least one tile associated with it. (2)
    - The points assigned to each letter should not be modified. (3)

**The second constructor, scrabbleSet(), takes no parameters. It does not modify the number of points for each tile, checking off condition 3. When printing out the components of a random ScrabbleSet object, this is an sample output:**

A 1 5
B 3 2
C 3 4
D 2 2
E 1 4
F 4 4
G 2 3
H 4 2
I 1 2
J 8 4
K 5 5
L 1 3
M 3 3
N 1 2
O 1 6
P 3 3
Q 10 3
R 1 8
S 1 8
T 1 3
U 1 3
V 4 1
W 4 3
X 8 8
Y 4 3
Z 10 5
' '  0 1

**It prints in the format Tile, Point, Count. For all tile objects in the set, there is at least one tile of each type, as shown in the sample out. The constructor does this by implementing a for loop that loops from i = 0 to i = 72 (not sure what the significance of 72 holds). This satisfies condition 2. To check whether the set has exactly 100 tiles, a for loop is implemented that adds together the total tileCount of each tile object and stores it in a "totalTiles" variable. If totalTiles does not equal 100, an error message will print. Because no error message is printed in the sample output, the total number of tiles adds up to a 100 (verified by adding up all the tileCounts). This satisfies conditions 1. There does not appear to be code that sets a max amount of each type of tile.**

### Methods

 - A toString method that provides a well-formatted String representation of the object.

 **There is a toString() method present that returns a ScrabbleSet as shown above in the discussion of the constructors. It is returned in the form tile, point value, tile count. While it does return all components of a ScrabbleSet, it does so in an unclear manner. It is hard for another user to tell what "A 1 5" means without a proper understanding of the program. A better toString() method would label each component specifically with "Tile" or "Point Value." This could be achieved by modifying the "result" variable defined in the toString() method to include labels for each item.**

 - A method that takes one String parameter which will contain a word. The method will return the number of points for the word in Scrabble based on the letter counts in the ScrabbleSet object and the point values for each Tile object.
    - As a first step, just use the letter tiles and ignore the blank tiles.
    - If a word is invalid, either because it has non-letter characters or because it has more instances of any single letter than is present for that letter in the Scrabble set, the method should return 0.

    **This method is listed as getWordValue() which takes a String "word" parameter. The return value is type int, which is the score of the word based on the ScrabbleSet. A sample output for a few test words is shown below:**

   Word value for cat: 5

   Word value for dog: 5

   Word value for a: 1

   Word value for zoo: 12

   Word value for zzz: 0 (Error: Not enough tiles for word.)

   Word value for cr' 'ate:7

   Word value for smørgasbord:0 (Error: Invalid word.)

   **The first 4 words are completely valid/normal words. They print out a correct score for all of them. The next three words are special cases. The String "zzz" is not a word, but contains 3 zs, which is  more than is present in a normal English ScrabbleSet. Based on this, the method correctly returns 0, as there are three Zs in the String which is greater than the 1 Z available in the Scrabbleset. Next, is the word "cr ate." It is essentially the word crate but with a space (or blank tile) added in the middle. The getWordValue() method correctly identifies the blank tile as having a 0 value while continuing to correctly evalute the points of the other tiles, and therefore correctly returns an value of 7. Finally, the word smørgasbord. It has a non letter character, ø, present in it. Due to this character, the method correctly returns a score of 0.**

   ### Other specifications from the checklist
- What repeated code is present that could become a single method? (This principle is known as DRY: Don’t repeat yourself.)

**In both scrabbleSet() constructors, there is a new line of code that individually adds new tile objects to the scrabbleSet (all 27. so 27 different lines of code). This could be potentially simplified by using a for loop which creates new tile objects based on information stored in different lists (example: a list of ABCDE... and a list of point values) and then adds those tile objects to the scrabbleSet (which would be fewer lines of code and easier to understand)**

- Are there any “magic number” constants that should be redefined as final variables (as in Java; other languages will have a different keyword)?  

**Because each TileInSet object is constructed with a set type and point value which doesn't and shouldn't change according to the specifications, each  could potentially be stored in a final variable. The only thing that would change would be the count of each tile, but that is not part of the TileInSet constructor and therefore would not impact the finality of each TileInSet object created.**

- Are all variables (both attributes and other local variables) have reasonable types and identifiers? Does each variable have a single purpose in its scope? Are there variables that can be removed from the code because they are redundant or unused?

**All variables created for both the ScrabbleSet class and the TileInSet class are used and have reasonable types. For example, the tiles are stored in an ArrayList (could also be stored in arrays or lists) and the "count" and "used" variables in the TileInSet are integer values to track the number of the tiles used and the number of tiles present in the ScrabbleSet. No variables are redundant and each have their own purpose. The only thing unnecessary in the code are two methods defined in the TileInSet class that are never used: getTile() and  and setTile(). While getTile() could be used reasonably, setTile() is overall useless for the purpose of the project because the tile type and point values never change.**

- Are there any errors in the nesting of loops and conditional statements? In an if-else chain or switch statement, are the most common conditions tested first?

**The first for loops and if-else statements show up in the constructors for ScrabbleSet objects. The for loop in the non-random constructor counts up the total number of tiles in the set and the if-else statement evaluates whether it is exactly 100 tiles. This bit of code for this constructor is likely a check and doesn't need to be present in the actual code because if it is a default ScrabbleSet, then the number of tiles will always be 100. However, for the random constructor, the for and if loop serve the same purpose and are actually needed to check if the number of tiles is 100.**

**The next for loops appear in the toString() and getWordValue() methods. The toString() loop just goes through the ScrabbleSet and puts each tile object into a string method with format "type, value, count." The most complex loop appears in the getWordValue() method. First, the used value of each tile is set to 0. Next, a found variable is created which is initially false (if the letter hasn't been found). Then, for each tile in the tiles array, the program evaluates whether that letter is present in the word and if it is, sets found to True. The next if loop after that then checks if the count of the tile exceeds the count present in the ScrabbleSet. For most words, this should not be the case, so the case where the count does not exceed the number present is tested first, while the case where the coutn does exceed is tested next. After that, the case where a character in the word is not found is tested. Because a fewer number of words have non-English characters in the English language, it is accordingly tested last.**

- Can readability and robustness be improved by converting an if-else statement to a switch?
**For getWordValue(), there could be a switch statement with cases such as word.charAt(i) == tile.tile.getLetter(), tile.getUsed() < tile.getCount(), and !found. For each of these cases, the code associated with them would be what would occur. Therefore, the default case would be "Error: Invalid word."**

- Do methods avoid the use of print statements and instead return values? Are all return values assigned and returned correctly?
**The two methods of ScrabbleSet both use return statements. toString returns a String object named result while getWordValue returns a integer score called WordValue. For each method this is the most reasonable return type and it is correctly returned, although the toString method could be edited for clarity.**


- Does the code provide reasonable results for a wide range of test cases, especially including any potential edge cases?
**According to the sample output above which tested different words, the code provides reasonable results.**




