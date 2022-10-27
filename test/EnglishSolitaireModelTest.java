import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class that represents tests for methods and the creation of English Solitaire Models.
 */

public class EnglishSolitaireModelTest {
  EnglishSolitaireModel model1;
  EnglishSolitaireModel model2;
  EnglishSolitaireModel model3;
  EnglishSolitaireModel modelThickness1;
  EnglishSolitaireModel model4;
  EnglishSolitaireModel model5;
  EnglishSolitaireModel model6;
  EnglishSolitaireModel model7;
  EnglishSolitaireModel model8;
  EnglishSolitaireModel model9;
  EnglishSolitaireModel model10;
  EnglishSolitaireModel model2Thickness1;

  /**
   * Represents various variations of English Solitaire Models using the four constructors.
   */
  @Before
  public void setUp() {

    //first constructor (default)
    this.model1 = new EnglishSolitaireModel();

    //second constructor (moving the starting empty slot)
    //default size
    this.model2 = new EnglishSolitaireModel(3, 3);
    this.model3 = new EnglishSolitaireModel(5, 3);


    //third constructor (adjustable arm thickness with the empty slot in the middle
    this.modelThickness1 = new EnglishSolitaireModel(1);
    this.model4 = new EnglishSolitaireModel(3);
    this.model5 = new EnglishSolitaireModel(5);
    this.model6 = new EnglishSolitaireModel(7);

    //fourth constructor (adjustable arm thickness with movable starting empty slot)

    this.model7 = new EnglishSolitaireModel(3, 3, 3);
    this.model8 = new EnglishSolitaireModel(3, 6, 3);
    this.model9 = new EnglishSolitaireModel(5, 6, 6);
    this.model10 = new EnglishSolitaireModel(5, 6, 3);
    this.model2Thickness1 = new EnglishSolitaireModel(1, 0, 0);

  }

  @Test
  public void testFirstConstructor() {
    assertEquals(Invalid, model1.getSlotAt(0, 0));
    assertEquals(Invalid, model1.getSlotAt(0, 1));
    assertEquals(Invalid, model1.getSlotAt(1, 0));
    assertEquals(Invalid, model1.getSlotAt(1, 1));
    assertEquals(Invalid, model1.getSlotAt(5, 0));
    assertEquals(Invalid, model1.getSlotAt(5, 1));
    assertEquals(Invalid, model1.getSlotAt(6, 0));
    assertEquals(Invalid, model1.getSlotAt(6, 1));
    assertEquals(Invalid, model1.getSlotAt(0, 5));
    assertEquals(Invalid, model1.getSlotAt(0, 6));
    assertEquals(Invalid, model1.getSlotAt(1, 5));
    assertEquals(Invalid, model1.getSlotAt(1, 6));
    assertEquals(Invalid, model1.getSlotAt(5, 5));
    assertEquals(Invalid, model1.getSlotAt(5, 6));
    assertEquals(Invalid, model1.getSlotAt(6, 5));
    assertEquals(Invalid, model1.getSlotAt(6, 6));
    assertEquals(Marble, model1.getSlotAt(0, 2));
    assertEquals(Marble, model1.getSlotAt(0, 3));
    assertEquals(Marble, model1.getSlotAt(0, 4));
    assertEquals(Marble, model1.getSlotAt(1, 2));
    assertEquals(Marble, model1.getSlotAt(1, 3));
    assertEquals(Marble, model1.getSlotAt(1, 4));

    for (int i = 0; i < model1.getBoardSize(); i++) {
      assertEquals(Marble, model1.getSlotAt(2, i));
    }
    for (int i = 0; i < model1.getBoardSize() / 2; i++) {
      assertEquals(Marble, model1.getSlotAt(3, i));
    }

    assertEquals(Empty, model1.getSlotAt(3, 3));

    for (int i = model1.getBoardSize() / 2 + 1; i < model1.getBoardSize(); i++) {
      assertEquals(Marble, model1.getSlotAt(3, i));
    }
    for (int i = 0; i < model1.getBoardSize(); i++) {
      assertEquals(Marble, model1.getSlotAt(4, i));
    }

    assertEquals(Marble, model1.getSlotAt(5, 2));
    assertEquals(Marble, model1.getSlotAt(5, 3));
    assertEquals(Marble, model1.getSlotAt(5, 4));
    assertEquals(Marble, model1.getSlotAt(6, 2));
    assertEquals(Marble, model1.getSlotAt(6, 3));
    assertEquals(Marble, model1.getSlotAt(6, 4));

  }

  @Test
  public void testSecondConstructor() {
    assertEquals(Empty, model2.getSlotAt(3, 3));
    assertEquals(Invalid, model2.getSlotAt(0, 0));
    assertEquals(Invalid, model2.getSlotAt(6, 6));
    assertEquals(Invalid, model2.getSlotAt(6, 0));
    assertEquals(Invalid, model2.getSlotAt(0, 6));
    assertEquals(Marble, model2.getSlotAt(0, 3));
    assertEquals(Marble, model2.getSlotAt(3, 6));
    assertEquals(Empty, model3.getSlotAt(5, 3));
    assertEquals(Invalid, model3.getSlotAt(0, 0));
    assertEquals(Invalid, model3.getSlotAt(6, 6));
    assertEquals(Invalid, model3.getSlotAt(6, 0));
    assertEquals(Invalid, model3.getSlotAt(0, 6));
    assertEquals(Marble, model3.getSlotAt(0, 3));
    assertEquals(Marble, model3.getSlotAt(3, 3));
    assertEquals(Marble, model3.getSlotAt(3, 6));
  }

  @Test
  public void testSecondConstructorExceptions() {
    //attempting to place empty slots in invalid spots
    try {
      EnglishSolitaireModel bottomRight = new EnglishSolitaireModel(6, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel topLeft = new EnglishSolitaireModel(0, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel topRight = new EnglishSolitaireModel(0, 5);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel bottomLeft = new EnglishSolitaireModel(6, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //off board

    try {
      EnglishSolitaireModel offBoardC = new EnglishSolitaireModel(-5, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EnglishSolitaireModel offBoardC2 = new EnglishSolitaireModel(2, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EnglishSolitaireModel offBoardC3 = new EnglishSolitaireModel(50, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EnglishSolitaireModel offBoardC4 = new EnglishSolitaireModel(-29, -30);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testThirdConstructor() {
    //empty slots in the middle for various armThickness's

    for (int i = 1; i < 7; i++) {
      EnglishSolitaireModel modelTest = new EnglishSolitaireModel(2 * i + 1);
      assertEquals(Empty,
              modelTest.getSlotAt(((2 * i + 1) * 3 - 2) / 2, ((2 * i + 1) * 3 - 2) / 2));
    }
    //armThickness = 1
    assertEquals(Empty, modelThickness1.getSlotAt(0, 0));

    //armThickness = 3
    assertEquals(Marble, model4.getSlotAt(0, 2));
    assertEquals(Marble, model4.getSlotAt(0, 3));
    assertEquals(Marble, model4.getSlotAt(0, 4));
    assertEquals(Marble, model4.getSlotAt(6, 2));
    assertEquals(Marble, model4.getSlotAt(6, 3));
    assertEquals(Marble, model4.getSlotAt(6, 4));
    assertEquals(Marble, model4.getSlotAt(2, 6));
    assertEquals(Marble, model4.getSlotAt(3, 6));
    assertEquals(Marble, model4.getSlotAt(4, 6));
    assertEquals(Marble, model4.getSlotAt(2, 0));
    assertEquals(Marble, model4.getSlotAt(3, 0));
    assertEquals(Marble, model4.getSlotAt(4, 0));
    assertEquals(Invalid, model4.getSlotAt(0, 0));
    assertEquals(Invalid, model4.getSlotAt(0, 1));
    assertEquals(Invalid, model4.getSlotAt(6, 6));
    assertEquals(Invalid, model4.getSlotAt(0, 6));
    assertEquals(Invalid, model4.getSlotAt(6, 0));

    assertEquals(Marble, model5.getSlotAt(0, 4));
    assertEquals(Marble, model5.getSlotAt(0, 8));
    assertEquals(Marble, model5.getSlotAt(12, 4));
    assertEquals(Marble, model5.getSlotAt(12, 8));
    assertEquals(Marble, model5.getSlotAt(4, 0));
    assertEquals(Marble, model5.getSlotAt(8, 0));
    assertEquals(Marble, model5.getSlotAt(4, 12));
    assertEquals(Marble, model5.getSlotAt(8, 12));
    assertEquals(Invalid, model5.getSlotAt(0, 0));
    assertEquals(Invalid, model5.getSlotAt(0, 1));
    assertEquals(Invalid, model5.getSlotAt(12, 12));
    assertEquals(Invalid, model5.getSlotAt(0, 12));
    assertEquals(Invalid, model5.getSlotAt(12, 0));

    assertEquals(Marble, model6.getSlotAt(9, 0));
    assertEquals(Marble, model6.getSlotAt(9, 18));
    assertEquals(Marble, model6.getSlotAt(0, 9));
    assertEquals(Marble, model6.getSlotAt(18, 9));
    assertEquals(Invalid, model6.getSlotAt(0, 0));
    assertEquals(Invalid, model6.getSlotAt(18, 0));
    assertEquals(Invalid, model6.getSlotAt(0, 18));
    assertEquals(Invalid, model6.getSlotAt(18, 18));

  }

  @Test
  public void testThirdConstructorException() {
    try {
      EnglishSolitaireModel evenThickness2 = new EnglishSolitaireModel(2);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel evenThickness4 = new EnglishSolitaireModel(4);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel evenThickness6 = new EnglishSolitaireModel(6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //thickness 1 is valid
    try {
      EnglishSolitaireModel thickness1 = new EnglishSolitaireModel(1);

    } catch (IllegalArgumentException e) {
      fail();
    }

    //negative thickness test
    try {
      EnglishSolitaireModel negativeOddThickness = new EnglishSolitaireModel(-3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testFourthConstructor() {

    //default board with fourth constructor
    assertEquals(Empty, model7.getSlotAt(3, 3));
    assertEquals(Marble, model7.getSlotAt(4, 4));
    assertEquals(Marble, model7.getSlotAt(0, 2));
    assertEquals(Marble, model7.getSlotAt(2, 0));
    assertEquals(Invalid, model7.getSlotAt(0, 6));
    assertEquals(Invalid, model7.getSlotAt(0, 0));
    assertEquals(Invalid, model7.getSlotAt(6, 0));
    assertEquals(Invalid, model7.getSlotAt(0, 6));
    assertEquals(Invalid, model7.getSlotAt(6, 6));

    //thickness 1 + only valid starting empty slot
    assertEquals(Empty, model2Thickness1.getSlotAt(0, 0));

    //thickness 3 + empty slot (6,3)
    assertEquals(Empty, model8.getSlotAt(6, 3));
    assertEquals(Marble, model8.getSlotAt(3, 3));
    assertEquals(Marble, model8.getSlotAt(4, 4));
    assertEquals(Marble, model8.getSlotAt(6, 2));
    assertEquals(Invalid, model8.getSlotAt(0, 6));
    assertEquals(Invalid, model8.getSlotAt(0, 0));
    assertEquals(Invalid, model8.getSlotAt(6, 0));
    assertEquals(Invalid, model8.getSlotAt(0, 6));
    assertEquals(Invalid, model8.getSlotAt(6, 6));

    //thickness 5 + empty slot(6,6)
    assertEquals(Empty, model9.getSlotAt(6, 6));
    assertEquals(Marble, model9.getSlotAt(0, 6));
    assertEquals(Marble, model9.getSlotAt(12, 6));
    assertEquals(Marble, model9.getSlotAt(4, 7));
    assertEquals(Invalid, model9.getSlotAt(3, 3));
    assertEquals(Invalid, model9.getSlotAt(0, 0));
    assertEquals(Invalid, model9.getSlotAt(0, 12));
    assertEquals(Invalid, model9.getSlotAt(12, 0));
    assertEquals(Invalid, model9.getSlotAt(12, 12));

    //thickness 5 + empty slot (6,3)
    assertEquals(Empty, model10.getSlotAt(6, 3));
    assertEquals(Marble, model10.getSlotAt(6, 6));
    assertEquals(Marble, model10.getSlotAt(6, 12));
    assertEquals(Marble, model10.getSlotAt(12, 6));
    assertEquals(Marble, model10.getSlotAt(0, 6));
    assertEquals(Invalid, model10.getSlotAt(0, 0));
    assertEquals(Invalid, model10.getSlotAt(0, 12));
    assertEquals(Invalid, model10.getSlotAt(12, 0));
    assertEquals(Invalid, model10.getSlotAt(12, 12));
    assertEquals(Invalid, model10.getSlotAt(3, 3));
  }

  @Test
  public void testFourthConstructorException() {
    //tests for even thickness
    try {
      EnglishSolitaireModel evenThickness2 =
              new EnglishSolitaireModel(2, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel evenThickness4 =
              new EnglishSolitaireModel(4, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel evenThickness6 =
              new EnglishSolitaireModel(6, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    //valid thickness 1 board
    try {
      EnglishSolitaireModel thickness1 = new EnglishSolitaireModel(1, 0, 0);
      //do nothing
    } catch (IllegalArgumentException e) {
      fail();
    }
    //tests for placing empty slots in all corner of invalid slots
    try {
      EnglishSolitaireModel invalidTopLeftCell =
              new EnglishSolitaireModel(3, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel invalidBottomLeftCell =
              new EnglishSolitaireModel(3, 6, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel invalidTopRightCell =
              new EnglishSolitaireModel(3, 0, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel invalidBottomRightCell =
              new EnglishSolitaireModel(3, 6, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel invalidTopLeftCell =
              new EnglishSolitaireModel(5, 0, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EnglishSolitaireModel invalidTopRightCell2 =
              new EnglishSolitaireModel(5, 0, 12);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      EnglishSolitaireModel invalidBottomRightCell2 =
              new EnglishSolitaireModel(5, 12, 12);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel invalidBottomLeftCell2 =
              new EnglishSolitaireModel(5, 12, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //tests for placing empty slot off the board
    try {
      EnglishSolitaireModel offBoard =
              new EnglishSolitaireModel(3, 5, 10);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      EnglishSolitaireModel offBoard2 =
              new EnglishSolitaireModel(5, 0, 20);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //one coordinate is within bounds, one is out of bounds
    try {
      EnglishSolitaireModel offBoard3 =
              new EnglishSolitaireModel(5, -5000, 5);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //one coordinate is within bounds, one is out of bounds
    try {
      EnglishSolitaireModel offBoard4 =
              new EnglishSolitaireModel(5, 3, -10000);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //both coordinates are off board
    try {
      EnglishSolitaireModel offBoard5 =
              new EnglishSolitaireModel(5, 1000, -1000);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //thickness 1 and placing empty slot off board
    try {
      EnglishSolitaireModel offBoardThickness1 =
              new EnglishSolitaireModel(1, 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //negative thickness
    try {
      EnglishSolitaireModel negativeThickness2 =
              new EnglishSolitaireModel(-3, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

  }

  @Test
  public void testMove() {
    //moving right
    EnglishSolitaireModel testMoveModel = new EnglishSolitaireModel();
    assertEquals(Empty, testMoveModel.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel.getSlotAt(3, 2));
    assertEquals(Marble, testMoveModel.getSlotAt(3, 1));

    testMoveModel.move(3, 1, 3, 3);

    assertEquals(Marble, testMoveModel.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel.getSlotAt(3, 2));
    assertEquals(Empty, testMoveModel.getSlotAt(3, 1));

    //moving left
    EnglishSolitaireModel testMoveModel2 = new EnglishSolitaireModel();
    assertEquals(Empty, testMoveModel2.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel2.getSlotAt(3, 4));
    assertEquals(Marble, testMoveModel2.getSlotAt(3, 5));

    testMoveModel2.move(3, 5, 3, 3);

    assertEquals(Marble, testMoveModel2.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel2.getSlotAt(3, 4));
    assertEquals(Empty, testMoveModel2.getSlotAt(3, 5));

    //moving down
    EnglishSolitaireModel testMoveModel3 = new EnglishSolitaireModel();
    assertEquals(Empty, testMoveModel3.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel3.getSlotAt(2, 3));
    assertEquals(Marble, testMoveModel3.getSlotAt(1, 3));

    testMoveModel3.move(1, 3, 3, 3);

    assertEquals(Marble, testMoveModel3.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel3.getSlotAt(2, 3));
    assertEquals(Empty, testMoveModel3.getSlotAt(1, 3));

    //moving up
    EnglishSolitaireModel testMoveModel4 = new EnglishSolitaireModel();
    assertEquals(Empty, testMoveModel4.getSlotAt(3, 3));
    assertEquals(Marble, testMoveModel4.getSlotAt(4, 3));
    assertEquals(Marble, testMoveModel4.getSlotAt(5, 3));

    testMoveModel4.move(5, 3, 3, 3);

    assertEquals(Marble, testMoveModel4.getSlotAt(3, 3));
    assertEquals(Empty, testMoveModel4.getSlotAt(4, 3));
    assertEquals(Empty, testMoveModel4.getSlotAt(5, 3));
  }

  @Test
  public void testMoveTestException() {

    //diagonal move
    try {
      model5.move(5, 5, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //moving 3 slots
    try {
      model1.move(2, 5, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //moving 2 slots in one direction, and one more slot in another direction
    try {
      model1.move(5, 4, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //moving 2 slots into an invalid slot
    try {
      model1.move(4, 6, 6, 6);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //trying to move onto a marble
    try {
      model1.move(4, 6, 4, 4);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    //valid move here
    try {
      model1.move(5, 3, 3, 3);

    } catch (IllegalArgumentException e) {
      fail();
    }


    EnglishSolitaireModel jumpingMarble = new EnglishSolitaireModel();
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
      model1.move(4, 0, 4, 6);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //random jump
    try {
      model1.move(4, 0, 6, 6);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //moving off the board with a legal 2 slot movement
    try {
      model1.move(4, 6, 4, 8);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }

    //starting off board
    try {
      model1.move(-6, 6, -4, 6);
      fail();
    } catch (IllegalArgumentException e) {
      //don't do anything
    }
  }

  @Test
  public void testIsGameOver() {
    EnglishSolitaireModel isGameOverBoard = new EnglishSolitaireModel();

    assertEquals(false, isGameOverBoard.isGameOver());

    isGameOverBoard.move(3, 5, 3, 3);

    assertEquals(false, isGameOverBoard.isGameOver());

    isGameOverBoard.move(1, 4, 3, 4);
    isGameOverBoard.move(2, 6, 2, 4);
    isGameOverBoard.move(4, 6, 2, 6);
    isGameOverBoard.move(2, 3, 2, 5);
    isGameOverBoard.move(2, 6, 2, 4);
    isGameOverBoard.move(2, 1, 2, 3);
    isGameOverBoard.move(0, 2, 2, 2);
    isGameOverBoard.move(0, 4, 0, 2);
    isGameOverBoard.move(3, 2, 1, 2);
    isGameOverBoard.move(0, 2, 2, 2);
    isGameOverBoard.move(5, 2, 3, 2);
    isGameOverBoard.move(4, 0, 4, 2);
    isGameOverBoard.move(2, 0, 4, 0);
    isGameOverBoard.move(4, 3, 4, 1);
    isGameOverBoard.move(4, 0, 4, 2);
    isGameOverBoard.move(4, 5, 4, 3);
    isGameOverBoard.move(6, 4, 4, 4);
    isGameOverBoard.move(6, 2, 6, 4);
    isGameOverBoard.move(3, 4, 5, 4);
    isGameOverBoard.move(6, 4, 4, 4);
    assertEquals(false, isGameOverBoard.isGameOver());
    //this is the special part
    isGameOverBoard.move(3, 2, 1, 2);
    isGameOverBoard.move(1, 2, 1, 4);
    isGameOverBoard.move(1, 4, 3, 4);
    isGameOverBoard.move(3, 4, 5, 4);
    isGameOverBoard.move(5, 4, 5, 2);
    isGameOverBoard.move(5, 2, 3, 2);
    isGameOverBoard.move(3, 3, 1, 3);
    isGameOverBoard.move(3, 1, 3, 3);
    isGameOverBoard.move(4, 3, 2, 3);
    isGameOverBoard.move(1, 3, 3, 3);

    //game is over
    assertEquals(true, isGameOverBoard.isGameOver());

    //thickness 1 model with no marbles
    assertEquals(true, modelThickness1.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(1, modelThickness1.getBoardSize());
    assertEquals(7, model1.getBoardSize());
    assertEquals(7, model2.getBoardSize());
    assertEquals(7, model4.getBoardSize());
    assertEquals(13, model5.getBoardSize());
    assertEquals(19, model6.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {

    //constructor 1
    assertEquals(Invalid, model1.getSlotAt(0, 0));
    assertEquals(Invalid, model1.getSlotAt(1, 1));
    assertEquals(Invalid, model1.getSlotAt(5, 0));
    assertEquals(Invalid, model1.getSlotAt(6, 1));
    assertEquals(Invalid, model1.getSlotAt(0, 5));
    assertEquals(Invalid, model1.getSlotAt(1, 6));
    assertEquals(Invalid, model1.getSlotAt(6, 6));
    assertEquals(Marble, model1.getSlotAt(0, 2));
    assertEquals(Marble, model1.getSlotAt(1, 4));
    assertEquals(Empty, model1.getSlotAt(3, 3));
    assertEquals(Marble, model1.getSlotAt(6, 4));


    assertEquals(Empty, model3.getSlotAt(5, 3));
    assertEquals(Invalid, model3.getSlotAt(0, 0));
    assertEquals(Invalid, model3.getSlotAt(6, 6));
    assertEquals(Invalid, model3.getSlotAt(6, 0));
    assertEquals(Invalid, model3.getSlotAt(0, 6));
    assertEquals(Marble, model3.getSlotAt(0, 3));
    assertEquals(Marble, model3.getSlotAt(3, 3));
    assertEquals(Marble, model3.getSlotAt(3, 6));

    assertEquals(Empty, model10.getSlotAt(6, 3));
    assertEquals(Marble, model10.getSlotAt(6, 6));
    assertEquals(Marble, model10.getSlotAt(6, 12));
    assertEquals(Marble, model10.getSlotAt(12, 6));
    assertEquals(Marble, model10.getSlotAt(0, 6));
    assertEquals(Invalid, model10.getSlotAt(0, 0));
    assertEquals(Invalid, model10.getSlotAt(0, 12));
    assertEquals(Invalid, model10.getSlotAt(12, 0));
    assertEquals(Invalid, model10.getSlotAt(12, 12));
    assertEquals(Invalid, model10.getSlotAt(3, 3));

    //third constructor thickness 1
    assertEquals(Empty, modelThickness1.getSlotAt(0, 0));

    //fourth constructor thickness 1
    assertEquals(Empty, model2Thickness1.getSlotAt(0, 0));
  }

  @Test
  public void testGetSlotAtTestException() {

    try {
      model1.getSlotAt(-1000, -1000);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      model1.getSlotAt(1000, -1000);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      model1.getSlotAt(-1000, 1000);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      model1.getSlotAt(1000, 1000);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      model1.getSlotAt(3, 1000);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      model1.getSlotAt(1000, 3);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      model1.getSlotAt(3, 3);
      //do nothing
    } catch (IllegalArgumentException e) {
      fail();
    }

    //thickness 1, trying to see if there's any slots around the 1 slot
    try {
      modelThickness1.getSlotAt(1, 1);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }
    try {
      modelThickness1.getSlotAt(0, 1);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }
    try {
      modelThickness1.getSlotAt(1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      modelThickness1.getSlotAt(-1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

  }

  @Test
  public void testGetScore() {

    EnglishSolitaireModel testGetScore = new EnglishSolitaireModel();
    assertEquals(32, testGetScore.getScore());
    testGetScore.move(3, 5, 3, 3);
    assertEquals(31, testGetScore.getScore());
    testGetScore.move(5, 4, 3, 4);
    assertEquals(30, testGetScore.getScore());
    testGetScore.move(3, 3, 3, 5);

    EnglishSolitaireModel testGetScore1 = new EnglishSolitaireModel(2, 2);
    assertEquals(32, testGetScore1.getScore());
    testGetScore1.move(0, 2, 2, 2);
    assertEquals(31, testGetScore1.getScore());

    assertEquals(0, modelThickness1.getScore());

    EnglishSolitaireModel testGetScore2 = new EnglishSolitaireModel(5);
    assertEquals(104, testGetScore2.getScore());
    testGetScore2.move(6, 4, 6, 6);
    assertEquals(103, testGetScore2.getScore());

  }

}