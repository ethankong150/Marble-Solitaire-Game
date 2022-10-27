import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class that represents the creation of the Triangle model and the methods surrounding
 * the playability of the game.
 */

public class TriangleSolitaireModelTest {

  TriangleSolitaireModel defaultModel;

  TriangleSolitaireModel dimension7;

  TriangleSolitaireModel movedEmpty;

  TriangleSolitaireModel movedEmptyDimension6;
  TriangleSolitaireModel movedEmptyDimension2;

  TriangleSolitaireModel dimension1;

  @Before
  public void setUp() {
    this.defaultModel = new TriangleSolitaireModel();
    this.dimension7 = new TriangleSolitaireModel(7);
    this.movedEmpty = new TriangleSolitaireModel(3, 2);
    this.movedEmptyDimension6 = new TriangleSolitaireModel(6, 5, 3);
    this.movedEmptyDimension2 = new TriangleSolitaireModel(2, 0, 0);
    this.dimension1 = new TriangleSolitaireModel(1);
  }

  @Test
  public void testFirstConstructor() {
    assertEquals(Empty, this.defaultModel.getSlotAt(0, 0));

    assertEquals(Invalid, this.defaultModel.getSlotAt(0, 1));
    assertEquals(Invalid, this.defaultModel.getSlotAt(1, 2));
    assertEquals(Invalid, this.defaultModel.getSlotAt(2, 3));
    assertEquals(Invalid, this.defaultModel.getSlotAt(3, 4));

    assertEquals(Marble, this.defaultModel.getSlotAt(1, 0));
    assertEquals(Marble, this.defaultModel.getSlotAt(1, 1));
    assertEquals(Marble, this.defaultModel.getSlotAt(2, 0));
    assertEquals(Marble, this.defaultModel.getSlotAt(2, 1));
    assertEquals(Marble, this.defaultModel.getSlotAt(2, 2));
    assertEquals(Marble, this.defaultModel.getSlotAt(3, 0));
    assertEquals(Marble, this.defaultModel.getSlotAt(3, 1));
    assertEquals(Marble, this.defaultModel.getSlotAt(3, 2));
    assertEquals(Marble, this.defaultModel.getSlotAt(3, 3));
    assertEquals(Marble, this.defaultModel.getSlotAt(4, 0));
    assertEquals(Marble, this.defaultModel.getSlotAt(4, 1));
    assertEquals(Marble, this.defaultModel.getSlotAt(4, 2));
    assertEquals(Marble, this.defaultModel.getSlotAt(4, 3));
    assertEquals(Marble, this.defaultModel.getSlotAt(4, 4));

  }

  @Test
  public void testSecondConstructor() {
    assertEquals(Empty, this.dimension7.getSlotAt(0, 0));

    assertEquals(Invalid, this.dimension7.getSlotAt(0, 1));
    assertEquals(Invalid, this.dimension7.getSlotAt(1, 2));
    assertEquals(Invalid, this.dimension7.getSlotAt(2, 3));
    assertEquals(Invalid, this.dimension7.getSlotAt(3, 4));
    assertEquals(Invalid, this.dimension7.getSlotAt(4, 5));
    assertEquals(Invalid, this.dimension7.getSlotAt(5, 6));

    assertEquals(Marble, this.dimension7.getSlotAt(1, 0));
    assertEquals(Marble, this.dimension7.getSlotAt(1, 1));
    assertEquals(Marble, this.dimension7.getSlotAt(2, 0));
    assertEquals(Marble, this.dimension7.getSlotAt(2, 1));
    assertEquals(Marble, this.dimension7.getSlotAt(2, 2));
    assertEquals(Marble, this.dimension7.getSlotAt(3, 0));
    assertEquals(Marble, this.dimension7.getSlotAt(3, 1));
    assertEquals(Marble, this.dimension7.getSlotAt(3, 2));
    assertEquals(Marble, this.dimension7.getSlotAt(3, 3));
    assertEquals(Marble, this.dimension7.getSlotAt(4, 0));
    assertEquals(Marble, this.dimension7.getSlotAt(4, 1));
    assertEquals(Marble, this.dimension7.getSlotAt(4, 2));
    assertEquals(Marble, this.dimension7.getSlotAt(4, 3));
    assertEquals(Marble, this.dimension7.getSlotAt(4, 4));
    assertEquals(Marble, this.dimension7.getSlotAt(5, 0));
    assertEquals(Marble, this.dimension7.getSlotAt(5, 1));
    assertEquals(Marble, this.dimension7.getSlotAt(5, 2));
    assertEquals(Marble, this.dimension7.getSlotAt(5, 3));
    assertEquals(Marble, this.dimension7.getSlotAt(5, 4));
    assertEquals(Marble, this.dimension7.getSlotAt(5, 5));
    assertEquals(Marble, this.dimension7.getSlotAt(6, 0));
    assertEquals(Marble, this.dimension7.getSlotAt(6, 1));
    assertEquals(Marble, this.dimension7.getSlotAt(6, 2));
    assertEquals(Marble, this.dimension7.getSlotAt(6, 3));
    assertEquals(Marble, this.dimension7.getSlotAt(6, 4));
    assertEquals(Marble, this.dimension7.getSlotAt(6, 5));
    assertEquals(Marble, this.dimension7.getSlotAt(6, 6));
  }

  @Test
  public void testThirdConstructor() {
    assertEquals(Empty, this.movedEmpty.getSlotAt(3, 2));

    assertEquals(Invalid, this.movedEmpty.getSlotAt(0, 1));
    assertEquals(Invalid, this.movedEmpty.getSlotAt(1, 2));
    assertEquals(Invalid, this.movedEmpty.getSlotAt(2, 3));
    assertEquals(Invalid, this.movedEmpty.getSlotAt(3, 4));

    assertEquals(Marble, this.movedEmpty.getSlotAt(0, 0));
    assertEquals(Marble, this.movedEmpty.getSlotAt(1, 0));
    assertEquals(Marble, this.movedEmpty.getSlotAt(1, 1));
    assertEquals(Marble, this.movedEmpty.getSlotAt(2, 0));
    assertEquals(Marble, this.movedEmpty.getSlotAt(2, 1));
    assertEquals(Marble, this.movedEmpty.getSlotAt(2, 2));
    assertEquals(Marble, this.movedEmpty.getSlotAt(3, 0));
    assertEquals(Marble, this.movedEmpty.getSlotAt(3, 1));
    assertEquals(Marble, this.movedEmpty.getSlotAt(3, 3));
    assertEquals(Marble, this.movedEmpty.getSlotAt(4, 0));
    assertEquals(Marble, this.movedEmpty.getSlotAt(4, 1));
    assertEquals(Marble, this.movedEmpty.getSlotAt(4, 2));
    assertEquals(Marble, this.movedEmpty.getSlotAt(4, 3));
    assertEquals(Marble, this.movedEmpty.getSlotAt(4, 4));
  }

  @Test
  public void testFourthConstructor() {
    assertEquals(Empty, this.movedEmptyDimension6.getSlotAt(5, 3));

    assertEquals(Invalid, this.movedEmptyDimension6.getSlotAt(0, 1));
    assertEquals(Invalid, this.movedEmptyDimension6.getSlotAt(1, 2));
    assertEquals(Invalid, this.movedEmptyDimension6.getSlotAt(2, 3));
    assertEquals(Invalid, this.movedEmptyDimension6.getSlotAt(3, 4));
    assertEquals(Invalid, this.movedEmptyDimension6.getSlotAt(4, 5));

    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(0, 0));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(1, 0));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(1, 1));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(2, 0));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(2, 1));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(2, 2));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(3, 0));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(3, 1));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(3, 2));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(3, 3));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(4, 0));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(4, 1));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(4, 2));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(4, 3));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(4, 4));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(5, 0));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(5, 1));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(5, 2));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(5, 4));
    assertEquals(Marble, this.movedEmptyDimension6.getSlotAt(5, 5));

    assertEquals(Empty, this.movedEmptyDimension2.getSlotAt(0, 0));
  }

  @Test
  public void testDimension1() {
    assertEquals(Empty, dimension1.getSlotAt(0, 0));
  }

  @Test
  public void testConstructorInvalidEmptySlotsException() {
    //invalid slot
    try {
      TriangleSolitaireModel fail = new TriangleSolitaireModel(0, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //outside of the board
    try {
      TriangleSolitaireModel fail2 = new TriangleSolitaireModel(-1, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //outside of the board
    try {
      TriangleSolitaireModel fail3 = new TriangleSolitaireModel(-1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //outside of the board
    try {
      TriangleSolitaireModel fail4 = new TriangleSolitaireModel(1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //invalid slot
    try {
      TriangleSolitaireModel fail5 = new TriangleSolitaireModel(4, 5);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testFourthConstructorInvalidEmptySlotsExceptions() {
    try {
      TriangleSolitaireModel wrong = new TriangleSolitaireModel(5, -1, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      TriangleSolitaireModel wrong2 = new TriangleSolitaireModel(5, 1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      TriangleSolitaireModel wrong3 = new TriangleSolitaireModel(5, -1, -3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testConstructorDimensionException() {
    try {
      TriangleSolitaireModel fail = new TriangleSolitaireModel(-1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      TriangleSolitaireModel fail2 = new TriangleSolitaireModel(0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      TriangleSolitaireModel fail3 = new TriangleSolitaireModel(-145345);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testMoveUpLeft() {

    TriangleSolitaireModel testDefault = new TriangleSolitaireModel();

    assertEquals(Empty, testDefault.getSlotAt(0, 0));
    assertEquals(Marble, testDefault.getSlotAt(1, 1));
    assertEquals(Marble, testDefault.getSlotAt(2, 2));

    testDefault.move(2, 2, 0, 0);

    assertEquals(Marble, testDefault.getSlotAt(0, 0));
    assertEquals(Empty, testDefault.getSlotAt(1, 1));
    assertEquals(Empty, testDefault.getSlotAt(2, 2));

  }

  @Test
  public void testMoveUpRight() {
    TriangleSolitaireModel testDefault2 = new TriangleSolitaireModel();

    assertEquals(Empty, testDefault2.getSlotAt(0, 0));
    assertEquals(Marble, testDefault2.getSlotAt(1, 0));
    assertEquals(Marble, testDefault2.getSlotAt(2, 0));

    testDefault2.move(2, 0, 0, 0);

    assertEquals(Marble, testDefault2.getSlotAt(0, 0));
    assertEquals(Empty, testDefault2.getSlotAt(1, 0));
    assertEquals(Empty, testDefault2.getSlotAt(2, 0));
  }

  @Test
  public void testMoveHorizontalLeft() {

    TriangleSolitaireModel testMovedEmpty = new TriangleSolitaireModel(2, 0);

    assertEquals(Empty, testMovedEmpty.getSlotAt(2, 0));
    assertEquals(Marble, testMovedEmpty.getSlotAt(2, 1));
    assertEquals(Marble, testMovedEmpty.getSlotAt(2, 2));

    testMovedEmpty.move(2, 2, 2, 0);

    assertEquals(Marble, testMovedEmpty.getSlotAt(2, 0));
    assertEquals(Empty, testMovedEmpty.getSlotAt(2, 1));
    assertEquals(Empty, testMovedEmpty.getSlotAt(2, 2));


  }

  @Test
  public void testMoveHorizontalRight() {
    TriangleSolitaireModel testMovedEmpty2 = new TriangleSolitaireModel(2, 2);

    assertEquals(Empty, testMovedEmpty2.getSlotAt(2, 2));
    assertEquals(Marble, testMovedEmpty2.getSlotAt(2, 1));
    assertEquals(Marble, testMovedEmpty2.getSlotAt(2, 0));

    testMovedEmpty2.move(2, 0, 2, 2);

    assertEquals(Marble, testMovedEmpty2.getSlotAt(2, 02));
    assertEquals(Empty, testMovedEmpty2.getSlotAt(2, 1));
    assertEquals(Empty, testMovedEmpty2.getSlotAt(2, 0));
  }

  @Test
  public void testMoveDownLeft() {

    TriangleSolitaireModel testMovedEmpty3 = new TriangleSolitaireModel(2, 0);

    assertEquals(Empty, testMovedEmpty3.getSlotAt(2, 0));
    assertEquals(Marble, testMovedEmpty3.getSlotAt(1, 0));
    assertEquals(Marble, testMovedEmpty3.getSlotAt(0, 0));

    testMovedEmpty3.move(0, 0, 2, 0);

    assertEquals(Marble, testMovedEmpty3.getSlotAt(2, 0));
    assertEquals(Empty, testMovedEmpty3.getSlotAt(1, 0));
    assertEquals(Empty, testMovedEmpty3.getSlotAt(0, 0));
  }

  @Test
  public void testMoveDownRight() {
    TriangleSolitaireModel testMovedEmpty4 = new TriangleSolitaireModel(2, 2);

    assertEquals(Empty, testMovedEmpty4.getSlotAt(2, 2));
    assertEquals(Marble, testMovedEmpty4.getSlotAt(1, 1));
    assertEquals(Marble, testMovedEmpty4.getSlotAt(0, 0));

    testMovedEmpty4.move(0, 0, 2, 2);

    assertEquals(Marble, testMovedEmpty4.getSlotAt(2, 2));
    assertEquals(Empty, testMovedEmpty4.getSlotAt(1, 1));
    assertEquals(Empty, testMovedEmpty4.getSlotAt(0, 0));
  }

  @Test
  public void testMoveExceptions() {

    //jumping onto another marble
    try {
      defaultModel.move(3, 3, 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //jumping 3 spaces
    try {
      defaultModel.move(3, 3, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //jumping vertically up
    try {
      defaultModel.move(2, 1, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //jumping vertically down
    TriangleSolitaireModel testVertical = new TriangleSolitaireModel(2, 1);

    try {
      testVertical.move(0, 0, 2, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    //jumping horizontally 1 slot
    TriangleSolitaireModel testHorizontal1Slot = new TriangleSolitaireModel(2, 1);
    try {
      testHorizontal1Slot.move(2, 0, 2, 1);
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //random jump
    try {
      defaultModel.move(5, 3, 0, 0);
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //jumping off the board (negatives)
    try {
      defaultModel.move(2, 0, 2, -2);
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //jumping from off the board onto the board
    try {
      defaultModel.move(-2, 0, 0, 0);
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //jumping onto invalids
    try {
      defaultModel.move(2, 2, 2, 4);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    //jumping from invalids to the board
    try {
      defaultModel.move(0, 2, 0, 0);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    //jumping from an empty to a marble
    try {
      defaultModel.move(0, 0, 2, 2);
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    //jumping over an empty onto an empty

    TriangleSolitaireModel testEmpty = new TriangleSolitaireModel(1, 1);
    testEmpty.move(3, 1, 1, 1);

    try {
      testEmpty.move(4, 1, 2, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testIsGameOver() {

    TriangleSolitaireModel testGameOver = new TriangleSolitaireModel(3);
    assertEquals(false, testGameOver.isGameOver());
    testGameOver.move(2, 0, 0, 0);
    assertEquals(false, testGameOver.isGameOver());
    testGameOver.move(2, 2, 2, 0);
    assertEquals(false, testGameOver.isGameOver());
    testGameOver.move(0, 0, 2, 2);
    assertEquals(true, testGameOver.isGameOver());

    assertEquals(false, defaultModel.isGameOver());

  }

  @Test
  public void testGetScore() {

    TriangleSolitaireModel testMovingScore = new TriangleSolitaireModel();
    assertEquals(14, testMovingScore.getScore());

    testMovingScore.move(2, 0, 0, 0);

    assertEquals(13, testMovingScore.getScore());

    assertEquals(0, dimension1.getScore());
    assertEquals(27, dimension7.getScore());

  }

  @Test
  public void testGetBoardSize() {
    assertEquals(5, defaultModel.getBoardSize());
    assertEquals(7, dimension7.getBoardSize());
    assertEquals(6, movedEmptyDimension6.getBoardSize());
    assertEquals(1, dimension1.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {

    assertEquals(Empty, defaultModel.getSlotAt(0, 0));
    assertEquals(Invalid, defaultModel.getSlotAt(0, 1));
    assertEquals(Marble, defaultModel.getSlotAt(1, 0));
  }

  @Test
  public void testGetSlotAtException() {
    try {
      defaultModel.getSlotAt(5, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      defaultModel.getSlotAt(0, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }
}
