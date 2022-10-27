package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

/**
 * Class represents the conversion from the model of the board to the String text view of the board.
 */
public class MarbleSolitaireTextView extends AbstractTextView {


  /**
   * Represents the MarbleSolitaireTextView Constructor that converts a model into a view.
   *
   * @param board input a void slotstate board
   * @throws IllegalArgumentException when the inputted board isn't valid
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board) throws IllegalArgumentException {
    super(board, System.out);
  }

  /**
   * Represents the MarbleSolitaireTextView Constructor that converts a model into a view.
   *
   * @param board      a model of the board
   * @param appendable object that converts the model into the view
   * @throws IllegalArgumentException if either arguments are null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState board, Appendable appendable)
          throws IllegalArgumentException {
    super(board, appendable);
  }

  /**
   * Converts the SlotState board into a string board.
   *
   * @return the string board of an EnglishSolitaire Model.
   */
  @Override
  public String toString() {

    if (this.board.getBoardSize() == 1) {
      return "_";
    }

    StringBuilder textView = new StringBuilder();

    for (int i = 0; i < this.board.getBoardSize(); i++) {
      boolean lastLine = i == this.board.getBoardSize() - 1;

      boolean nonInvalidStarted = false;

      for (int j = 0; j < this.board.getBoardSize(); j++) {
        MarbleSolitaireModelState.SlotState curr = this.board.getSlotAt(i, j);
        if (curr == Marble) {
          textView.append("O");
          nonInvalidStarted = true;
        } else if (curr == Empty) {
          textView.append("_");
          nonInvalidStarted = true;
        } else if (curr == Invalid && !nonInvalidStarted) {
          textView.append(" ");
        }
        //want to go to the next line if we reached the end of the board
        //want to go to the next line if the next is invalid and we are done with the marbles
        boolean edgeSlot = j == this.board.getBoardSize() - 1;

        if (edgeSlot || (nonInvalidStarted && isNextInvalid(i, j) && !lastLine)) {
          textView.append("\n");
          break;
        } else if (lastLine && nonInvalidStarted && isNextInvalid(i, j)) {
          break;
        } else {
          textView.append(" ");
        }
      }
    }
    return textView.toString();
  }
}