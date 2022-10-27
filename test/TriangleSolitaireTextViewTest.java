import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.AbstractTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Class that represents the conversion of a Triangle model into a view and other methods
 * that surround the rendering of the view that can be used by the controller.
 */

public class TriangleSolitaireTextViewTest {

  TriangleSolitaireModel defaultModel;
  TriangleSolitaireTextView defaultView;
  TriangleSolitaireModel movedEmpty;
  TriangleSolitaireTextView movedEmptyView;

  TriangleSolitaireModel dimension7;
  TriangleSolitaireTextView dimension7View;

  TriangleSolitaireModel movedEmptyDimension4;
  TriangleSolitaireTextView movedEmptyDimension4View;

  TriangleSolitaireModel movedEmptyDimension2;
  TriangleSolitaireTextView movedEmptyDimension2View;

  @Before
  public void setUp() {
    //first constructor
    this.defaultModel = new TriangleSolitaireModel();
    this.defaultView = new TriangleSolitaireTextView(defaultModel);

    //second constructor
    this.movedEmpty = new TriangleSolitaireModel(3, 3);
    this.movedEmptyView = new TriangleSolitaireTextView(movedEmpty);

    //third constructor
    this.dimension7 = new TriangleSolitaireModel(7);
    this.dimension7View = new TriangleSolitaireTextView(dimension7);

    //fourth constructor
    this.movedEmptyDimension4 = new TriangleSolitaireModel(4, 2, 1);
    this.movedEmptyDimension4View = new TriangleSolitaireTextView(movedEmptyDimension4);

    this.movedEmptyDimension2 = new TriangleSolitaireModel(2, 0, 0);
    this.movedEmptyDimension2View = new TriangleSolitaireTextView(this.movedEmptyDimension2);
  }

  @Test
  public void testDefaultConstructorToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", this.defaultView.toString());
  }

  @Test
  public void testSecondConstructorToString() {
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O O", this.movedEmptyView.toString());
  }

  @Test
  public void testThirdConstructorToString() {
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", this.dimension7View.toString());
  }

  @Test
  public void testFourthConstructorToString() {
    assertEquals("   O\n" +
            "  O O\n" +
            " O _ O\n" +
            "O O O O", this.movedEmptyDimension4View.toString());


    assertEquals(" _\n" +
            "O O", this.movedEmptyDimension2View.toString());
  }

  @Test
  public void testRenderBoard() {
    Appendable testAp = new StringBuilder();
    TriangleSolitaireTextView testDefaultBoard =
            new TriangleSolitaireTextView(defaultModel, testAp);

    Appendable testAp2 = new StringBuilder();
    AbstractTextView dimension7View =
            new TriangleSolitaireTextView(dimension7, testAp2);

    Appendable testAp3 = new StringBuilder();
    AbstractTextView testMovedEmpty =
            new TriangleSolitaireTextView(movedEmpty, testAp3);

    Appendable testAp4 = new StringBuilder();
    AbstractTextView movedEmptyDimension4View =
            new TriangleSolitaireTextView(movedEmptyDimension4, testAp4);

    Appendable testAp5 = new StringBuilder();
    try {
      testDefaultBoard.renderBoard();
      assertEquals("    _\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O O\n" +
              "O O O O O", testAp.toString());
    } catch (IOException e) {
      // do nothing
    }

    //adding other boards ontop of another rendered board
    try {
      dimension7View.renderBoard();
      assertEquals("      _\n" +
              "     O O\n" +
              "    O O O\n" +
              "   O O O O\n" +
              "  O O O O O\n" +
              " O O O O O O\n" +
              "O O O O O O O", testAp2.toString());
    } catch (IOException e) {
      // do nothing
    }

    try {
      testMovedEmpty.renderBoard();
      assertEquals("    O\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O _\n" +
              "O O O O O", testAp3.toString());

    } catch (IOException e) {
      // do nothing
    }

    try {
      movedEmptyDimension4View.renderBoard();
      assertEquals("   O\n" +
              "  O O\n" +
              " O _ O\n" +
              "O O O O", testAp4.toString());
    } catch (IOException e) {
      // do nothing
    }
  }

  @Test
  public void testRenderMessage() {
    Appendable testAp = new StringBuilder();
    TriangleSolitaireTextView testMessageView =
            new TriangleSolitaireTextView(defaultModel, testAp);
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
