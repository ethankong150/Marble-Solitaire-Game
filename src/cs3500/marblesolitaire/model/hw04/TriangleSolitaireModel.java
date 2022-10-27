package cs3500.marblesolitaire.model.hw04;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

/**
 * Class that represents the creation of a Triangle Solitaire model and the methods
 * related to the playability of the game.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  public TriangleSolitaireModel(int armThickness) {
    this(armThickness, 0, 0);
  }

  public TriangleSolitaireModel(int sRow, int sCol) {
    this(5, sRow, sCol);
  }

  /**
   * Constructor of a Triangle solitaire model.
   *
   * @param sRow         the row of the empty slot
   * @param sCol         the column of the empty slot
   * @param armThickness the dimension of the model
   * @throws IllegalArgumentException when given slot coordinates are invalid or off the board
   *                                  or when dimension given isn't a natural number
   */

  public TriangleSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return this.armThickness;
  }


  /**
   * Checks if marble can make a move 2 slots horizontally, or diagonal moves in four directions
   * moving top left means moving horizontally left 2 slots and moving "vertically" up 2 slots,
   * moving top right means moving "vertically" up 2 slots, moving bottom left means
   * moving "vertically" down 2 slots, and moving bottom right means moving horizontally right
   * 2 slots and moving "vertically" down 2 slots.
   *
   * @param fromRow starting row value
   * @param fromCol starting column value
   * @param toRow   possible ending row value
   * @param toCol   possible ending column value
   * @return if the move is legal or not
   */
  @Override
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {

    int midRow = (fromRow + toRow) / 2;
    int midCol = (fromCol + toCol) / 2;
    return (getSlotAt(fromRow, fromCol) == Marble && getSlotAt(midRow, midCol) == Marble &&
            getSlotAt(toRow, toCol) == Empty &&
            //new moves V
            ((toRow - fromRow == 2 && toCol - fromCol == 2 ||
                    toRow - fromRow == -2 && toCol - fromCol == -2)
                    || ((Math.abs(fromRow - toRow) == 2 || Math.abs(fromCol - toCol) == 2)
                    && (fromRow - toRow == 0 || fromCol - toCol == 0))));
  }

  /**
   * Checks if the current slot is invalid or not.
   *
   * @param row row coordinate
   * @param col column coordinate
   * @return true if the slot is invalid and false if the slot is not invalid
   */
  protected boolean isInvalid(int armThickness, int row, int col) {
    return col > row && col < armThickness;
  }

  /**
   * Checks if a given slot is off the board.
   *
   * @param armThickness the arm thickness of a board
   * @param row          the row coordinate
   * @param col          the column coordinate
   * @return true if the slot is off the board and false if the slot is on the board
   */
  @Override
  protected boolean offBoard(int armThickness, int row, int col) {
    return row >= armThickness || col >= armThickness || row < 0 || col < 0;
  }

  @Override
  protected void validArmThicknessOrDimension(int armThickness) {
    if (armThickness <= 0) {
      throw new IllegalArgumentException("Return a natural number dimension!");
    }
  }
}


