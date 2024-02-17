# README

## Documentation
 - Are there clear and correct Javadoc comments for the class, method, and/or attributes? Note that both public and private methods and attributes should have Javadoc comments.

## Code structure
- Does the code satisfy all provided specifications?

- Is the code consistently formatted? (Note: For this course, we use the results of the Format Document… command in Visual Studio Code as our correct formatting style.)

- Do all methods have a clear purpose?

- Is there any debugging code still present that should be commented out or otherwise modified so that it does not run in production mode?

- What repeated code is present that could become a single method? (This principle is known as DRY: Don’t repeat yourself.)

- Are there any “magic number” constants that should be redefined as final variables (as in Java; other languages will have a different keyword)?

- Is there any complexity that can be simplified by the use of multiple methods?

## Variables
- Are all variables (both attributes and other local variables) have reasonable types and identifiers?

- Does each variable have a single purpose in its scope?

- Whenever the code assigns a value to a variable, does the code ensure type consistency? For example, does the code use casting appropriately?

- Are there variables that can be removed from the code because they are redundant or unused?

## Arithmetic operations
- Are there any places that floating-point numbers are compared for equality? If so, how can those comparisons be rewritten to be more robust?

- Are divisions tested for divide-by-zero?

## Loops and conditional statements
- Are there any errors in the nesting of loops and conditional statements?

- In an if-else chain or switch statement, are the most common conditions tested first?

- Does each if-else chain or switch statement address all possible cases? (Note the importance of the final else and default blocks.)

- Can readability and robustness be improved by converting an if-else statement to a switch?

- Do loops have proper index initialization statements?
Are loop termination conditions guaranteed to return true when the program runs?

- Are there statements that can be moved outside of the loop (because they only need to run once) or conditional statement (because they run no matter what the result of the conditional statement is)?

## General programming practice
- Are indexes tested against array bounds?

- Are all return values assigned and returned correctly?

- Do methods avoid the use of print statements and instead return values?

- Does each statement operate on the correct data?

- Does the code provide reasonable results for a wide range of test cases, especially including any potential edge cases?


### The ScrabbleSet class
Should have attributes that allow the object to store the following information. Do not initialize any of these attributes when you declare them. That will be done in a constructor.

 - A list of Tile objects for the letters and the blank tile. The blank tile should be represented by a space, ' '.
 
 **Contains an ArrayList object named "tiles" that stores all 27 types of tiles.**
 - A list that provides a count of each letter in the Scrabble set.

Use arrays or ArrayList objects for each attribute; do not use any other kind of data structures.

### You will need two constructors.

 - One constructor should take one parameter, the language for the Scrabble set. At this time, you only need to implement building a Scrabble set for standard English. You can find the count of each tile in Wikipedia, among other places. (This Scrabble set has 100 tiles.)
 - One constructor should take no parameters and build a Scrabble set with each letter having a random value for the count, subject to the following conditions.
 - The total number of tiles must be exactly 100.
 - Each letter (and the blank) must have at least one tile associated with it.
 - The points assigned to each letter should not be modified.
 - You can add other reasonable rules, such as a maximum count that no letter can exceed.

### You will need at least the following two methods

 - A toString method that provides a well-formatted String representation of the object.
 - A method that takes one String parameter which will contain a word. The method will return the number of points for the word in Scrabble based on the letter counts in the ScrabbleSet object and the point values for each Tile object.

As a first step, just use the letter tiles and ignore the blank tiles.
If a word is invalid, either because it has non-letter characters or because it has more instances of any single letter than is present for that letter in the Scrabble set, the method should return 0.
