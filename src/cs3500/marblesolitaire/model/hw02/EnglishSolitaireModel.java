package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Class that represents the creation of a Slotstate English Solitaire Model and other methods
 * related to the gameplay of English Marble Solitaire Game.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * First Constructor that represents the default English Solitaire Model.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Second Constructor that represents the default English Solitaire Model with a movable
   * starting empty slot.
   *
   * @param sRow the row value of the starting empty slot
   * @param sCol the column value of the starting empty slot
   * @throws IllegalArgumentException throws exception when inputted empty slot is placed in
   *                                  an invalid slot or off the board
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Third Constructor that creates an English Solitaire Model of various sizes
   * based on odd numbered "arm thickness".
   *
   * @param armThickness the number of marbles in the top row
   *                     (or bottom row, or left or right columns)
   * @throws IllegalArgumentException throws exception when inputted armThickness is even
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (3 * armThickness - 2) / 2, (3 * armThickness - 2) / 2);
  }

  /**
   * Fourth Constructor that creates an English Solitaire Model of various sizes based on
   * arm thickness with a movable default empty slot.
   *
   * @param armThickness the number of marbles in the top row
   *                     (or bottom row, or left or right columns)
   * @param sRow         the row value of the starting empty slot
   * @param sCol         the column value of the starting empty slot
   * @throws IllegalArgumentException exception is thrown when arm thickness is even.
   *                                  Exception is also thrown when the empty slot
   *                                  is placed in an invalid slot or off the board.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * Finds/checks if the current slot is invalid or not.
   *
   * @param armThickness arm thickness of each side of the model
   * @param row          row coordinate
   * @param row          column coordinate
   * @return true if slot is invalid and false if slot is not invalid
   */
  @Override
  protected boolean isInvalid(int armThickness, int row, int col) {
    return ((2 * armThickness - 1 <= row || row <= armThickness - 2)
            && (2 * armThickness - 1 <= col || col <= armThickness - 2))
            || row < 0 || row > armThickness * 3 - 3 || col < 0 || col > armThickness * 3 - 3;
  }
}