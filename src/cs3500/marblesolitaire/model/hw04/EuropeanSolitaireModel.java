package cs3500.marblesolitaire.model.hw04;

/**
 * Class that represents the creation of European Solitaire model and the methods related
 * to the playability of the game with this board.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  public EuropeanSolitaireModel(int armThickness) {
    this(armThickness, (3 * armThickness - 2) / 2, (3 * armThickness - 2) / 2);
  }

  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructor of a European Solitaire model.
   *
   * @param sRow         starting row for empty slot
   * @param sCol         starting column for empty slot
   * @param armThickness thickness of each arm of the model
   * @throws IllegalArgumentException when thickness is even or not a natural number
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * Checks if the current slot is invalid or not.
   *
   * @param armThickness arm thickness of each arm of the model
   * @param row          row coordinate
   * @param col          column coordinate
   * @return true if the slot is invalid and false if the slot is not invalid
   */
  protected boolean isInvalid(int armThickness, int row, int col) {

    return  //top left
            ((row < armThickness - col - 1 && col < armThickness - row - 1) ||
                    //top right
                    (row < col - armThickness - 1 && col > 2 * armThickness + row - 2) ||
                    //bottom left
                    (row > 2 * armThickness + col - 2 && col < row - armThickness - 1) ||
                    //bottom right
                    (row > 2 * armThickness - 2 + (armThickness * 3 - 3 - col) &&
                            col > 2 * armThickness - 2 + (armThickness * 3 - 3 - row)));
  }
}
