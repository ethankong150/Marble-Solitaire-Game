package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

/**
 * Class that represents the conversion of a Triangle model into a view and the methods
 * that make the view usable by the controller.
 */
public class TriangleSolitaireTextView extends AbstractTextView {

  /**
   * Represents the constructor of a TriangleSolitaire View.
   *
   * @param board the model
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState board) {
    super(board, System.out);
    if (board == null) {
      throw new IllegalArgumentException("Input a valid board!");
    }
  }

  /**
   * Represents the constructor of a TriangleSolitaire View used mainly for testing.
   *
   * @param board      the model
   * @param appendable the appendable used in the game
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState board, Appendable appendable) {
    super(board, appendable);
    if (board == null || appendable == null) {
      throw new IllegalArgumentException("You can't input null objects!");
    }
  }


  /**
   * Converts the model into a string.
   *
   * @return the view
   */
  @Override
  public String toString() {

    StringBuilder textView = new StringBuilder();
    boolean lastSlot;


    for (int i = 0; i < this.board.getBoardSize(); i++) {
      int count = this.board.getBoardSize() - i - 1;
      for (int j = 0; j < this.board.getBoardSize(); j++) {
        while (count != 0) {
          textView.append(" ");
          count--;
        }
        lastSlot = (i == this.board.getBoardSize() - 1 && j == this.board.getBoardSize() - 1);

        if (this.board.getSlotAt(i, j) == Marble) {
          textView.append("O");
        } else if (this.board.getSlotAt(i, j) == Empty) {
          textView.append("_");
        }

        if (i != this.board.getBoardSize() - 1 && this.isNextInvalid(i, j)) {
          textView.append("\n");
          break;
        } else if (!lastSlot) {
          textView.append(" ");
        }
      }
    }

    return textView.toString();
  }
}

