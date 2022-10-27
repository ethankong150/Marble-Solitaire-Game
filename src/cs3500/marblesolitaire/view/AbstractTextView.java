package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;

/**
 * Represents the class that abstracts constructors and methods of the English, European
 * and Triangle textview classes.
 */
public abstract class AbstractTextView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState board;
  protected Appendable appendable;

  /**
   * Represents the abstract constructor of the other 3 textview classes.
   *
   * @param board      the model
   * @param appendable the appendable
   * @throws IllegalArgumentException when corrupted appendable is given
   */
  public AbstractTextView(MarbleSolitaireModelState board, Appendable appendable)
          throws IllegalArgumentException {
    if (board == null || appendable == null) {
      throw new IllegalArgumentException("You can't input null objects!");
    }
    this.board = board;
    this.appendable = appendable;
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  public void renderBoard() throws IOException {
    this.appendable.append(this.toString());
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }

  /**
   * Checks if the Slotstate next to the inputted slot is Invalid or not. "Next slot" is the
   * slot directly to the right of the inputted slot (column value + 1).
   *
   * @param row row value of a slot
   * @param col column value of a slot
   * @return if the "next" slot is invalid or not.
   */
  protected boolean isNextInvalid(int row, int col) {

    return this.board.getSlotAt(row, col + 1) == Invalid;
  }
}
