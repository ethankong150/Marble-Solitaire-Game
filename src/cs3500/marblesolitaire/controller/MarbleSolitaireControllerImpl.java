package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Class represents the controller of the game, and ensuring that the model and ultimately the view
 * changes with the legal inputted moves.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable input;
  private boolean isGameRunning;
  private List<String> gameMoves;

  /**
   * Constructor that represents the controller of MarbleSolitaire game
   * and takes in the model and view of the game.
   *
   * @param model the model of the game
   * @param view  the string text view of the game
   * @param input the scanner that takes in inputs from the user in the game
   * @throws IllegalArgumentException if any inputted objects are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable input) throws
          IllegalArgumentException {

    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("You need valid inputs!");
    }

    this.model = model;
    this.view = view;
    this.input = input;
    this.isGameRunning = false;
    this.gameMoves = new ArrayList<>();
  }

  /**
   * Allows user to play MarbleSolitaire Game and initiates
   * the game/view in the console to be played.
   *
   * @throws IllegalStateException if there's an error rendering the appending the new states of
   *                               the board and/or message or if an illegal move is attempted
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scan = new Scanner(this.input);
    isGameRunning = true;

    while (isGameRunning) {

      this.renderBoardAndMessage();

      //handles the inputs and quitting
      addInputs(scan);

      //once the inputs are handled, we attempt to make the desired move
      if (gameMoves.size() == 4) {
        this.moveHandler();
      }

      if (this.model.isGameOver()) {
        isGameRunning = false;
      }
    }
  }

  /**
   * Adds inputs to the gameMoves arraylist object until it's full (4 items in list).
   *
   * @param scan Brings the scanner object and the potential already scanned inputs
   * @throws IllegalStateException when there's not enough inputs for the gameMoves field to
   *                               fill up to the 4 items.
   */
  private void addInputs(Scanner scan) throws IllegalStateException {

    while (gameMoves.size() < 4) {
      if (!scan.hasNext()) {
        try {
          this.view.renderMessage("You need to add more valid inputs!");
        } catch (IOException e) {
          throw new IllegalStateException("Can't render message");
        }
        throw new IllegalStateException();
      } else {
        String curr = scan.next();
        if (curr.equalsIgnoreCase("Q")) {
          isGameRunning = false;
          quitGame();
          break;
        } else if (isNumeric(curr) && Integer.valueOf(curr) > 0) {
          gameMoves.add(curr);
        }
      }
    }
  }

  /**
   * Renders the board and message into the destination as string, where the board is above
   * the score.
   *
   * @throws IllegalStateException throws exception when given a corrupted appendable
   */
  private void renderBoardAndMessage() throws IllegalStateException {
    try {
      this.view.renderBoard();
      this.view.renderMessage("\nScore: " + this.model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Can't render board or message!");
    }
  }

  /**
   * Allows the user to end the game whenever they want. This handles the quitting game state
   * and ending the game.
   */
  private void quitGame() {
    this.displayMessage("\nGame quit!\nState of game when quit:\n");
    this.renderBoardAndMessage();
    isGameRunning = false;
  }

  /**
   * Renders a message onto the board.
   *
   * @param text the desired message to be placed onto the board
   * @throws IllegalStateException if the message can't be appended to the appendable
   */
  private void displayMessage(String text) throws IllegalStateException {
    try {
      this.view.renderMessage(text);
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }

  /**
   * Checks if a string is a number.
   *
   * @param strNum string that might be a number
   * @return if string is a number
   */
  private static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  /**
   * Handles potential valid inputs for a move and adjusts the model if move is valid.
   * Also ends game if the move results in a no more valid moves left.
   */
  private void moveHandler() {
    if (this.gameMoves.get(0).equalsIgnoreCase("q") ||
            this.gameMoves.get(1).equalsIgnoreCase("q") ||
            this.gameMoves.get(2).equalsIgnoreCase("q") ||
            this.gameMoves.get(3).equalsIgnoreCase("q")) {
      this.quitGame();
      isGameRunning = false;
    } else {
      int fromRow = Integer.valueOf(this.gameMoves.get(0)) - 1;
      int fromCol = Integer.valueOf(this.gameMoves.get(1)) - 1;
      int toRow = Integer.valueOf(this.gameMoves.get(2)) - 1;
      int toCol = Integer.valueOf(this.gameMoves.get(3)) - 1;

      try {
        this.model.move(fromRow, fromCol, toRow, toCol);
        this.gameMoves = new ArrayList<>();
      } catch (IllegalArgumentException e) {
        if (isGameRunning) {
          this.displayMessage("Invalid move. Play again. \n");
          this.gameMoves = new ArrayList<>();
        }
      }
      if (this.model.isGameOver()) {
        this.gameIsOver();
        this.gameMoves = new ArrayList<>();
      }
    }
  }

  /**
   * Handles the rendering of the final game screen and ends the game properly.
   *
   * @throws IllegalStateException if unable to append message to the appendable
   */
  private void gameIsOver() throws IllegalStateException {
    try {
      this.view.renderMessage("Game over!\n");
      this.renderBoardAndMessage();
      isGameRunning = false;
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }
}