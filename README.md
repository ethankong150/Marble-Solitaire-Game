# Marble-Solitaire-Game

Overview: 

Marble Solitaire Game (English, European, and Triangle Variations)

Program is based off: https://www.mathsisfun.com/games/marbles.html

Marble solitaire or solitaire chess is a strategy game in which a player attempts to rid the game board of marbles
by jumping pieces into empty spaces and removing jumped marbles, similar to jumping pieces in checkers. 
The ultimate goal of the game is to be left with one remaining marble in the game board's center space.

In this program, the MVC design pattern was used to allow for different variations of the board (ie. English, European, and Triangle variation).

1. MarbleSolitaireController interface
    i. The marble solitaire controller interface contains the header for the playGame() method, which starts the program and run it. The playGame() method throws                IllegalStateException if the controller is unable to successfully read input or transmit output.
    ii. The controller reads user input and transmit messages to the output - this is implemented in the MarbleSolitaireControllerImpl
2. MarbleSolitaireModelState interface
    i. The marble solitaire model state interface includes methods (getSlotAt, getBoardSize, getScore) that represent properties of the model. This interface is only one        part of the model. 
    ii. This interface is extended by the MarbleSolitaireModel.
3. MarbleSolitaireModel interface
    i. The marble solitaire model interface includes methods related to the playability of the game (including move() and isGameOver())
    ii. This interface is the other part of the model design.
4. MarbleSolitaireView interface  
    i.This interface contains all the method headers (toString(), renderBoard(), renderMessage() ) needed to transmit the view.
    ii. This interface represents view portion of the MVC design pattern.
