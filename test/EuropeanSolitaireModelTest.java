import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class represents the tests surrounding the creation of the European model and the methods
 * surrounding it.
 */

public class EuropeanSolitaireModelTest {

  EuropeanSolitaireModel defaultModel;
  EuropeanSolitaireModel thickness5Model;
  EuropeanSolitaireModel thickness1Model;
  EuropeanSolitaireModel movedEmptyModel;
  EuropeanSolitaireModel movedEmptyThickness5Model;

  @Before
  public void setUp() {
    this.defaultModel = new EuropeanSolitaireModel();
    this.thickness5Model = new EuropeanSolitaireModel(5);
    this.thickness1Model = new EuropeanSolitaireModel(1);
    this.movedEmptyModel = new EuropeanSolitaireModel(1, 1);
    this.movedEmptyThickness5Model = new EuropeanSolitaireModel(5, 8, 9);
  }

  @Test
  public void testDefaultModel() {
    assertEquals(Invalid, this.defaultModel.getSlotAt(0, 0));
    assertEquals(Invalid, this.defaultModel.getSlotAt(1, 0));
    assertEquals(Invalid, this.defaultModel.getSlotAt(0, 1));

    assertEquals(Invalid, this.defaultModel.getSlotAt(0, 5));
    assertEquals(Invalid, this.defaultModel.getSlotAt(1, 6));
    assertEquals(Invalid, this.defaultModel.getSlotAt(0, 6));

    assertEquals(Invalid, this.defaultModel.getSlotAt(5, 0));
    assertEquals(Invalid, this.defaultModel.getSlotAt(6, 0));
    assertEquals(Invalid, this.defaultModel.getSlotAt(6, 1));

    assertEquals(Invalid, this.defaultModel.getSlotAt(5, 6));
    assertEquals(Invalid, this.defaultModel.getSlotAt(6, 5));
    assertEquals(Invalid, this.defaultModel.getSlotAt(6, 6));

    assertEquals(Empty, this.defaultModel.getSlotAt(3, 3));

    assertEquals(Marble, this.defaultModel.getSlotAt(1, 1));
    assertEquals(Marble, this.defaultModel.getSlotAt(0, 2));
    assertEquals(Marble, this.defaultModel.getSlotAt(2, 0));
    assertEquals(Marble, this.defaultModel.getSlotAt(0, 4));
    assertEquals(Marble, this.defaultModel.getSlotAt(1, 5));
    assertEquals(Marble, this.defaultModel.getSlotAt(2, 6));
    assertEquals(Marble, this.defaultModel.getSlotAt(4, 6));
    assertEquals(Marble, this.defaultModel.getSlotAt(5, 5));
    assertEquals(Marble, this.defaultModel.getSlotAt(6, 4));
    assertEquals(Marble, this.defaultModel.getSlotAt(4, 0));
    assertEquals(Marble, this.defaultModel.getSlotAt(5, 1));
    assertEquals(Marble, this.defaultModel.getSlotAt(6, 2));
  }

  @Test
  public void testSecondConstructor() {
    assertEquals(Empty, this.thickness5Model.getSlotAt(6, 6));

    //invalids in each corner
    assertEquals(Invalid, this.thickness5Model.getSlotAt(0, 0));
    assertEquals(Invalid, this.thickness5Model.getSlotAt(2, 1));
    assertEquals(Invalid, this.thickness5Model.getSlotAt(10, 1));
    assertEquals(Invalid, this.thickness5Model.getSlotAt(0, 9));
    assertEquals(Invalid, this.thickness5Model.getSlotAt(10, 11));

    assertEquals(Marble, this.thickness5Model.getSlotAt(8, 1));
    assertEquals(Marble, this.thickness5Model.getSlotAt(3, 8));
    assertEquals(Marble, this.thickness5Model.getSlotAt(10, 9));
    assertEquals(Marble, this.thickness5Model.getSlotAt(2, 2));

  }

  @Test
  public void testThickness1() {

    assertEquals(Empty, thickness1Model.getSlotAt(0, 0));
  }

  @Test
  public void testThirdConstructor() {

    assertEquals(Empty, this.movedEmptyModel.getSlotAt(1, 1));

    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(0, 0));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(1, 0));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(0, 1));

    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(0, 5));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(1, 6));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(0, 6));

    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(5, 0));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(6, 0));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(6, 1));

    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(5, 6));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(6, 5));
    assertEquals(Invalid, this.movedEmptyModel.getSlotAt(6, 6));

    assertEquals(Marble, this.movedEmptyModel.getSlotAt(0, 2));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(2, 0));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(0, 4));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(1, 5));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(2, 6));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(4, 6));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(5, 5));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(6, 4));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(4, 0));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(5, 1));
    assertEquals(Marble, this.movedEmptyModel.getSlotAt(6, 2));
  }

  @Test
  public void testFourthConstructor() {

    assertEquals(Empty, this.movedEmptyThickness5Model.getSlotAt(8, 9));

    //invalids in each corner
    assertEquals(Invalid, this.movedEmptyThickness5Model.getSlotAt(0, 0));
    assertEquals(Invalid, this.movedEmptyThickness5Model.getSlotAt(2, 1));
    assertEquals(Invalid, this.movedEmptyThickness5Model.getSlotAt(10, 1));
    assertEquals(Invalid, this.movedEmptyThickness5Model.getSlotAt(0, 9));
    assertEquals(Invalid, this.movedEmptyThickness5Model.getSlotAt(10, 11));

    assertEquals(Marble, this.movedEmptyThickness5Model.getSlotAt(8, 1));
    assertEquals(Marble, this.movedEmptyThickness5Model.getSlotAt(3, 8));
    assertEquals(Marble, this.movedEmptyThickness5Model.getSlotAt(10, 9));
    assertEquals(Marble, this.movedEmptyThickness5Model.getSlotAt(2, 2));
  }

  @Test
  public void testConstructorInvalidEmptyCell() {

    //default size constructor
    try {
      EuropeanSolitaireModel e1 = new EuropeanSolitaireModel(0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EuropeanSolitaireModel e2 = new EuropeanSolitaireModel(5, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EuropeanSolitaireModel e3 = new EuropeanSolitaireModel(6, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EuropeanSolitaireModel e4 = new EuropeanSolitaireModel(0, 5);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }


    try {
      EuropeanSolitaireModel e5 = new EuropeanSolitaireModel(1, 2, 5);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //off board
    try {
      EuropeanSolitaireModel e6 = new EuropeanSolitaireModel(-1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }


  }

  @Test
  public void testConstructorThicknessException() {
    try {
      EuropeanSolitaireModel e1 = new EuropeanSolitaireModel(0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EuropeanSolitaireModel e2 = new EuropeanSolitaireModel(4);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EuropeanSolitaireModel e3 = new EuropeanSolitaireModel(-3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testIllegalMoveException() {

    //diagonal move
    try {
      thickness5Model.move(8, 8, 6, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //moving 3 slots
    try {
      defaultModel.move(3, 6, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //moving 2 slots in one direction, and one more slot in another direction
    try {
      defaultModel.move(5, 4, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //moving 2 slots into an invalid slot
    try {
      defaultModel.move(4, 6, 6, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //trying to move onto a marble
    try {
      defaultModel.move(4, 6, 4, 4);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //valid move here
    try {
      defaultModel.move(5, 3, 3, 3);

    } catch (IllegalArgumentException e) {
      fail();
    }


    EuropeanSolitaireModel jumpingMarble = new EuropeanSolitaireModel();
    jumpingMarble.move(5, 3, 3, 3);
    //there are no marbles at (4,3) or (5,3)

    //trying to jump over empty slot into an empty slot
    try {
      jumpingMarble.move(6, 3, 4, 3);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //trying to jump from an empty slot
    try {
      jumpingMarble.move(5, 3, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //big jump
    try {
      defaultModel.move(4, 0, 4, 6);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //random jump
    try {
      defaultModel.move(4, 0, 6, 6);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //moving off the board with a legal 2 slot movement
    try {
      defaultModel.move(4, 6, 4, 8);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //starting off board
    try {
      defaultModel.move(3, -2, 3, 0);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //moving one slot
    try {
      defaultModel.move(3, 2, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testMove() {
    //moving right
    EuropeanSolitaireModel testMoveModel = new EuropeanSolitaireModel();
    assertEquals(Empty, testMoveModel.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel.getSlotAt(3, 2));
    assertEquals(Marble, testMoveModel.getSlotAt(3, 1));

    testMoveModel.move(3, 1, 3, 3);

    assertEquals(Marble, testMoveModel.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel.getSlotAt(3, 2));
    assertEquals(Empty, testMoveModel.getSlotAt(3, 1));

    //moving left
    EuropeanSolitaireModel testMoveModel2 = new EuropeanSolitaireModel();
    assertEquals(Empty, testMoveModel2.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel2.getSlotAt(3, 4));
    assertEquals(Marble, testMoveModel2.getSlotAt(3, 5));

    testMoveModel2.move(3, 5, 3, 3);

    assertEquals(Marble, testMoveModel2.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel2.getSlotAt(3, 4));
    assertEquals(Empty, testMoveModel2.getSlotAt(3, 5));

    //moving down
    EuropeanSolitaireModel testMoveModel3 = new EuropeanSolitaireModel();
    assertEquals(Empty, testMoveModel3.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel3.getSlotAt(2, 3));
    assertEquals(Marble, testMoveModel3.getSlotAt(1, 3));

    testMoveModel3.move(1, 3, 3, 3);

    assertEquals(Marble, testMoveModel3.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel3.getSlotAt(2, 3));
    assertEquals(Empty, testMoveModel3.getSlotAt(1, 3));

    //moving up
    EuropeanSolitaireModel testMoveModel4 = new EuropeanSolitaireModel();
    assertEquals(Empty, testMoveModel4.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel4.getSlotAt(4, 3));
    assertEquals(Marble, testMoveModel4.getSlotAt(5, 3));

    testMoveModel4.move(5, 3, 3, 3);

    assertEquals(Marble, testMoveModel4.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel4.getSlotAt(4, 3));
    assertEquals(Empty, testMoveModel4.getSlotAt(5, 3));


    //moving into the new corners
    EuropeanSolitaireModel testMoveModel5 = new EuropeanSolitaireModel(1, 1);
    assertEquals(Empty, testMoveModel5.getSlotAt(1, 1));
    testMoveModel5.move(3, 1, 1, 1);
    assertEquals(Marble, testMoveModel5.getSlotAt(1, 1));

    //moving out from the new corners
    EuropeanSolitaireModel testMoveModel6 = new EuropeanSolitaireModel(1,3);
    assertEquals(Empty, testMoveModel6.getSlotAt(1,3));
    testMoveModel6.move(1,1,1,3);
    assertEquals(Empty, testMoveModel6.getSlotAt(1,1));
    assertEquals(Empty, testMoveModel6.getSlotAt(1,2));
    assertEquals(Marble, testMoveModel6.getSlotAt(1,3));

  }

  @Test
  public void testIsGameOver() {
    EuropeanSolitaireModel test = new EuropeanSolitaireModel();
    assertEquals(false, test.isGameOver());

    test.move(5, 3, 3, 3);

    assertEquals(false, test.isGameOver());

    test.move(2, 3, 4, 3);

    assertEquals(false, test.isGameOver());

    assertEquals(true, thickness1Model.isGameOver());
  }

  @Test
  public void testGetScore() {

    EuropeanSolitaireModel testModel = new EuropeanSolitaireModel();

    assertEquals(36, testModel.getScore());

    testModel.move(5, 3, 3, 3);

    assertEquals(35, testModel.getScore());

    testModel.move(2, 3, 4, 3);

    assertEquals(34, testModel.getScore());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(Invalid, this.defaultModel.getSlotAt(6, 6));
    assertEquals(Empty, this.defaultModel.getSlotAt(3, 3));
    assertEquals(Marble, this.defaultModel.getSlotAt(1, 1));
  }

  @Test
  public void testGetSlotAtException() {
    try {
      this.defaultModel.getSlotAt(-1, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      this.defaultModel.getSlotAt(1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      this.defaultModel.getSlotAt(-1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(1, this.thickness1Model.getBoardSize());
    assertEquals(7, this.defaultModel.getBoardSize());
    assertEquals(13, this.thickness5Model.getBoardSize());

  }
}