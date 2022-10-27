package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;

/**
 * Class that represents the abstracted versions of each of the triangle, european and english
 * models and the methods related to the playability of the game in each of the respective boards.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected int sRow;
  protected int sCol;
  protected int armThickness;
  protected SlotState[][] boardState;

  /**
   * Represents the abstracted constructor of a model for the 3 models.
   *
   * @param armThickness thickness of arm for european and english boards
   *                     and the dimension of a triangle board
   * @param sRow         starting row for empty slot
   * @param sCol         starting column for empty slot
   * @throws IllegalArgumentException when starting slot is out of bounds and when the dimension
   *                                  or arm thickness is wrong
   */
  public AbstractSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    if (isInvalid(armThickness, sRow, sCol) || offBoard(armThickness, sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    validArmThicknessOrDimension(armThickness);

    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;

    buildBoard();
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */

  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (!validMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("You can't make this move!");
    }
    int midOfRow = (fromRow + toRow) / 2;
    int midOfCol = (fromCol + toCol) / 2;

    this.boardState[fromRow][fromCol] = Empty;
    this.boardState[midOfRow][midOfCol] = Empty;
    this.boardState[toRow][toCol] = Marble;
  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (getSlotAt(i, j) == Marble) {
          if ((i + 2 < getBoardSize() && validMove(i, j, i + 2, j))
                  ||
                  (i - 2 >= 0 && validMove(i, j, i - 2, j))
                  ||
                  (j + 2 < getBoardSize() && validMove(i, j, i, j + 2))
                  ||
                  (j - 2 >= 0
                          &&
                          validMove(i, j, i, j - 2))
                  ||
                  //the new Triangle diagonal moves which will fail for English and European
                  (i - 2 >= 0 && j - 2 >= 0 && validMove(i, j, i - 2, j - 2))
                  ||
                  (i + 2 < getBoardSize() && j + 2 < getBoardSize() &&
                          validMove(i, j, i + 2, j + 2))) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */

  public int getBoardSize() {
    return 3 * this.armThickness - 2;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */

  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row >= getBoardSize() || col >= getBoardSize() || row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid slot");
    }
    return boardState[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  public int getScore() {
    int count = 0;
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {

        if (this.boardState[i][j] == Marble) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Builds the 'non-physical' void/SlotState version board.
   */
  protected void buildBoard() {
    int boardSize = getBoardSize();
    this.boardState = new SlotState[boardSize][boardSize];
    if (armThickness == 1) {
      this.boardState[0][0] = Empty;
    } else {
      for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {
          if (isInvalid(armThickness, i, j)) {
            this.boardState[i][j] = Invalid;
          } else if (i == sRow && j == sCol) {
            this.boardState[i][j] = Empty;
          } else {
            this.boardState[i][j] = Marble;
          }
        }
      }
    }
  }

  /**
   * Checks if the attempted move is legal or not. This means that the starting position is a
   * marble, the jumped slot is a marble and if the ending position is empty. Furthermore, this
   * method checks if the attempted move is only moving 2 slots in the vertical direction
   * or in the horizontal direction (but not both).
   *
   * @param fromRow the row value of the starting position
   * @param fromCol the col value of the starting position
   * @param toRow   the row value of the potential final position
   * @param toCol   the col value of the potential final position
   * @return if the move is valid or not
   */
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {

    int midRow = (fromRow + toRow) / 2;
    int midCol = (fromCol + toCol) / 2;

    return (getSlotAt(fromRow, fromCol) == Marble && getSlotAt(midRow, midCol) == Marble &&
            getSlotAt(toRow, toCol) == Empty &&
            (!(Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2)
                    && (Math.abs(fromRow - toRow) == 2 || Math.abs(fromCol - toCol) == 2)
                    && (fromRow - toRow == 0 || fromCol - toCol == 0)));
  }

  /**
   * Finds/checks if the current slot is invalid or not.
   *
   * @param row row coordinate
   * @param col column coordinate
   * @return true if slot is invalid and false if slot is not invalid
   */
  protected abstract boolean isInvalid(int armThickness, int row, int col);

  /**
   * Checks if the given slot is off the board.
   *
   * @param armThickness the arm thickness of a board
   * @param row          the row coordinate
   * @param col          the column coordinate
   * @return true if the slot is off the board and false if the slot is on the board
   */
  protected boolean offBoard(int armThickness, int row, int col) {
    return row < 0 || col < 0 || row > 3 * armThickness * 3 - 2 || col > 3 * armThickness * 3 - 2;
  }

  /**
   * Checks if the dimension or arm thickness is valid or not.
   *
   * @param armThickness the arm thickness of an english or european model or the dimension of a
   *                     triangle model
   * @return true if the arm thickness or dimension is valid and false if not.
   */
  protected void validArmThicknessOrDimension(int armThickness) {
    if (armThickness % 2 <= 0) {
      throw new IllegalArgumentException("Input a positive odd armThickness");
    }
  }
}
