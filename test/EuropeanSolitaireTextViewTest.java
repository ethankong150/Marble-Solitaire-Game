import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Class that represents the conversion of the model to a view
 * and other methods related to the controller.
 */

public class EuropeanSolitaireTextViewTest {

  EuropeanSolitaireModel defaultModel;
  MarbleSolitaireTextView defaultModelView;

  EuropeanSolitaireModel europeanThickness5;
  MarbleSolitaireTextView europeanThickness5View;

  EuropeanSolitaireModel movedEmpty;
  MarbleSolitaireTextView movedEmptyView;

  EuropeanSolitaireModel movedEmptyThickness5;
  MarbleSolitaireTextView movedEmptyThickness5View;

  @Before
  public void setUp() {

    //European default constructor:
    this.defaultModel = new EuropeanSolitaireModel();
    this.defaultModelView = new MarbleSolitaireTextView(this.defaultModel);

    //European Second Constructor:
    this.europeanThickness5 = new EuropeanSolitaireModel(5);
    this.europeanThickness5View = new MarbleSolitaireTextView(this.europeanThickness5);

    //European Third Constructor:
    this.movedEmpty = new EuropeanSolitaireModel(4, 4);
    this.movedEmptyView = new MarbleSolitaireTextView(this.movedEmpty);

    //European Fourth Constructor
    this.movedEmptyThickness5 = new EuropeanSolitaireModel(5, 2, 3);
    this.movedEmptyThickness5View = new MarbleSolitaireTextView(this.movedEmptyThickness5);

  }

  @Test
  public void testDefaultEuropeanConstructorToString() {

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", defaultModelView.toString());
  }

  @Test
  public void testSecondEuropeanConstructorToString() {

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", europeanThickness5View.toString());
  }

  @Test
  public void testThirdEuropeanConstructorToString() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ O O\n" +
            "  O O O O O\n" +
            "    O O O", movedEmptyView.toString());
  }

  @Test
  public void testFourthEuropeanConstructorToString() {
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O _ O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", movedEmptyThickness5View.toString());
  }

  @Test
  public void testRenderBoard() {
    Appendable testAp = new StringBuilder();
    MarbleSolitaireView testDefaultBoard =
            new MarbleSolitaireTextView(defaultModel, testAp);

    Appendable testAp2 = new StringBuilder();
    MarbleSolitaireView testThickness5 =
            new MarbleSolitaireTextView(europeanThickness5, testAp2);

    Appendable testAp3 = new StringBuilder();
    MarbleSolitaireView testMovedEmpty =
            new MarbleSolitaireTextView(movedEmpty, testAp3);

    Appendable testAp4 = new StringBuilder();
    MarbleSolitaireView testMovedEmptyThickness5 =
            new MarbleSolitaireTextView(movedEmptyThickness5, testAp4);

    Appendable testAp5 = new StringBuilder();
    try {
      testDefaultBoard.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    defaultModel.move(5, 3, 3, 3);
    try {
      testDefaultBoard.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "  O O _ O O\n" +
              "    O O O", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    //adding other boards ontop of another rendered board
    try {
      testThickness5.renderBoard();
      assertEquals("        O O O O O\n" +
              "      O O O O O O O\n" +
              "    O O O O O O O O O\n" +
              "  O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O _ O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "  O O O O O O O O O O O\n" +
              "    O O O O O O O O O\n" +
              "      O O O O O O O\n" +
              "        O O O O O", testAp2.toString());
    } catch (IOException e) {
      // do nothing
    }

    try {
      testMovedEmpty.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "  O O O O O\n" +
              "    O O O", testAp3.toString());

    } catch (IOException e) {
      // do nothing
    }

    try {
      testMovedEmptyThickness5.renderBoard();
      assertEquals("        O O O O O\n" +
              "      O O O O O O O\n" +
              "    O _ O O O O O O O\n" +
              "  O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "  O O O O O O O O O O O\n" +
              "    O O O O O O O O O\n" +
              "      O O O O O O O\n" +
              "        O O O O O", testAp4.toString());
    } catch (IOException e) {
      // do nothing
    }
  }

  @Test
  public void testRenderMessage() {
    Appendable testAp = new StringBuilder();
    MarbleSolitaireView testMessageView =
            new MarbleSolitaireTextView(defaultModel, testAp);
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
}
