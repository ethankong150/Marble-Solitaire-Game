import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class that represents tests for methods and the creation of Marble Solitaire Text Models in
 * string form.
 */
public class MarbleSolitaireTextViewTest {

  MarbleSolitaireTextView model1;
  MarbleSolitaireTextView model2;
  MarbleSolitaireTextView model3;
  MarbleSolitaireTextView model4;
  MarbleSolitaireTextView model5;
  MarbleSolitaireTextView model6;
  MarbleSolitaireTextView modelThickness;
  MarbleSolitaireTextView model7;
  MarbleSolitaireTextView model8;
  MarbleSolitaireTextView model9;
  MarbleSolitaireTextView model10;
  MarbleSolitaireTextView modelThickness2;
  EnglishSolitaireModel voidModel1;
  EnglishSolitaireModel voidModel2;
  EnglishSolitaireModel voidModel3;
  EnglishSolitaireModel voidModel4;
  EnglishSolitaireModel voidModel5;
  EnglishSolitaireModel voidModel6;
  EnglishSolitaireModel voidModelThickness;
  EnglishSolitaireModel voidModel7;
  EnglishSolitaireModel voidModel8;
  EnglishSolitaireModel voidModel9;
  EnglishSolitaireModel voidModel10;
  EnglishSolitaireModel voidModelThickness2;


  /**
   * Represents the setup of various types of marble solitaire boards in string form.
   */

  @Before
  public void setUp() {

    //first constructor (default)
    this.voidModel1 = new EnglishSolitaireModel();
    this.model1 = new MarbleSolitaireTextView(this.voidModel1);

    //second constructor (moving the starting empty slot)
    //default size
    this.voidModel2 = new EnglishSolitaireModel(3, 3);
    this.voidModel3 = new EnglishSolitaireModel(5, 3);
    this.model2 = new MarbleSolitaireTextView(this.voidModel2);
    this.model3 = new MarbleSolitaireTextView(this.voidModel3);

    //third constructor (adjustable arm thickness with the empty slot in the middle
    this.voidModel4 = new EnglishSolitaireModel(3);
    this.voidModel5 = new EnglishSolitaireModel(5);
    this.voidModel6 = new EnglishSolitaireModel(7);
    this.voidModelThickness = new EnglishSolitaireModel(1);
    this.model4 = new MarbleSolitaireTextView(this.voidModel4);
    this.model5 = new MarbleSolitaireTextView(this.voidModel5);
    this.model6 = new MarbleSolitaireTextView(this.voidModel6);
    this.modelThickness = new MarbleSolitaireTextView(this.voidModelThickness);

    //fourth constructor (adjustable arm thickness with movable starting empty slot)
    this.voidModel7 = new EnglishSolitaireModel(3, 3, 3);
    this.voidModel8 = new EnglishSolitaireModel(3, 6, 3);
    this.voidModel9 = new EnglishSolitaireModel(5, 6, 6);
    this.voidModel10 = new EnglishSolitaireModel(5, 6, 3);
    this.voidModelThickness2 = new EnglishSolitaireModel(1, 0, 0);
    this.model7 = new MarbleSolitaireTextView(this.voidModel7);
    this.model8 = new MarbleSolitaireTextView(this.voidModel8);
    this.model9 = new MarbleSolitaireTextView(this.voidModel9);
    this.model10 = new MarbleSolitaireTextView(this.voidModel10);
    this.modelThickness2 = new MarbleSolitaireTextView(this.voidModelThickness2);

  }

  @Test
  public void testMarbleTextViewConstructorTestException() {
    try {
      new MarbleSolitaireTextView(null);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testEnglishSecondConstructor() {
    Appendable testAp = new StringBuilder();
    MarbleSolitaireView testDefaultBoard =
            new MarbleSolitaireTextView(voidModel1, testAp);

    try {
      testDefaultBoard.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }
  }

  @Test
  public void testSecondConstructorExceptions() {

    // valid input
    try {
      new MarbleSolitaireTextView(this.voidModel1, new StringBuilder());

    } catch (IllegalArgumentException e) {
      fail();
    }

    //null tests
    try {
      new MarbleSolitaireTextView(this.voidModel1, null);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      new MarbleSolitaireTextView(null, new StringBuilder());
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      new MarbleSolitaireTextView(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testToString() {

    //testing the board after a move
    EnglishSolitaireModel testModelMove = new EnglishSolitaireModel();
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", new MarbleSolitaireTextView(testModelMove).toString());
    testModelMove.move(3, 1, 3, 3);

    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", new MarbleSolitaireTextView(testModelMove).toString());


    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", model1.toString());


    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", model2.toString());
    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O _ O\n" +
                    "    O O O", model3.toString());

    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", model4.toString());

    assertEquals(
            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O", model5.toString());
    assertEquals(
            "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O _ O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O\n" +
                    "            O O O O O O O", model6.toString());

    assertEquals(
            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O _ O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O", model10.toString());

    assertEquals("_", modelThickness.toString());
    assertEquals("_", modelThickness2.toString());
  }

  @Test
  public void testRenderBoard() {
    Appendable testAp = new StringBuilder();
    MarbleSolitaireView testDefaultBoard =
            new MarbleSolitaireTextView(voidModel1, testAp);

    Appendable testAp2 = new StringBuilder();
    MarbleSolitaireView testMovedEmptyDefaultBoard =
            new MarbleSolitaireTextView(voidModel3, testAp2);

    Appendable testAp3 = new StringBuilder();
    MarbleSolitaireView testThickness5 =
            new MarbleSolitaireTextView(voidModel5, testAp3);

    Appendable testAp4 = new StringBuilder();
    MarbleSolitaireView testThickness5WithMovedEmpty =
            new MarbleSolitaireTextView(voidModel10, testAp4);

    Appendable testAp5 = new StringBuilder();
    try {
      testDefaultBoard.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    voidModel1.move(5, 3, 3, 3);
    try {
      testDefaultBoard.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    //adding other boards ontop of another rendered board
    try {
      testMovedEmptyDefaultBoard.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "    O _ O\n" +
              "    O O O", testAp2.toString());
    } catch (IOException e) {
      // do nothing
    }

    try {
      testThickness5.renderBoard();
      assertEquals("        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O _ O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O", testAp3.toString());

    } catch (IOException e) {
      // do nothing
    }

    try {
      testThickness5WithMovedEmpty.renderBoard();
      assertEquals("        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O _ O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O", testAp4.toString());
    } catch (IOException e) {
      // do nothing
    }
  }

  @Test
  public void testRenderBoardExceptions() {
    CorruptedAppendables ca1 = new CorruptedAppendables();

    MarbleSolitaireView testMessageViewException = new MarbleSolitaireTextView(voidModel1, ca1);
    try {
      testMessageViewException.renderBoard();
      fail();
    } catch (IOException e) {
      // do nothing
    }
  }

  @Test
  public void testRenderMessage() {

    Appendable testAp = new StringBuilder();
    MarbleSolitaireView testMessageView =
            new MarbleSolitaireTextView(voidModel1, testAp);
    try {
      testMessageView.renderMessage("Hi!");
      assertEquals("Hi!", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    try {
      testMessageView.renderMessage("Hello!");
      assertEquals("Hi!Hello!", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    try {
      testMessageView.renderMessage("");
      assertEquals("Hi!Hello!", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    try {
      testMessageView.renderMessage("\n!");
      assertEquals("Hi!Hello!\n!", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }
  }

  @Test
  public void testRenderMessageExceptions() {
    CorruptedAppendables ca1 = new CorruptedAppendables();

    MarbleSolitaireView testMessageViewException = new MarbleSolitaireTextView(voidModel2, ca1);
    try {
      testMessageViewException.renderMessage("Hi!");
      fail();
    } catch (IOException e) {
      //do nothing
    }
  }

}