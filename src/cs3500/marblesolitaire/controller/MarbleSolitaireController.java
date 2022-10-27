package cs3500.marblesolitaire.controller;

/**
 * This interface represents the operations surrounding the controller of the MarbleSolitaire Game.
 */

public interface MarbleSolitaireController {


  /**
   * Method should play a new game of Marble Solitaire.
   *
   * @throws IllegalArgumentException when the controller is unable to
   *                                  successfully read input or transmit output
   */
  void playGame() throws IllegalArgumentException;
}