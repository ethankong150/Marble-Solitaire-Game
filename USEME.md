# User Guide:

 1. Navigate to the edit run configuration. 
 
 2. Under the "build and run" section, ensure the entry point says "cs3500.marblesolitaire.MarbleSolitaire".
 
 3. Just below, is the Program Argument section where the game configurations will be added. 
       - There are currently three main configurations: Triangle, English, and European.
       - To select the respective configurations enter either "triangle", "english", or "european".
       
 4. Afterwards enter arguments for the size of the board
       - Size example: "-size 5" 
       
 5. Finally, enter coordinates for the starting empty hole. 
       - Hole example: "-hole 4 4" 
       
 Note: There are spaces between each "argument" and size and hole arguments are not required.
 
 Together, the program argument can look like: "european -size 3 -hole 4 4" or "triangle -size 4 -hole 0 0" or "english -hole 4 2 -size 7"
 
 [Example](https://imgur.com/a/OJ2A96l)
 
 "O"'s represent marbles and "_" represents empty slots.
 
 To play the game, one must enter coordinates of a marble to move from and coordinates of an empty slot to move to.
 Moves must be 2 slots apart: An example of a legal move: "6 4 4 4" - 6 4 being the row coordinate and column coordinate of marble to move
 and 4 4 being the row coordinate and column coordinate of the empty slot to move the marble to.
 
 Keep making moves until there is either no more legal moves left or that there is only one marble left!
