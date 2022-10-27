import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class represents all the tests that surround the gameplay of Marble Solitaire and its controller,
 * namely inputting values to the game and ensuring the game can quit and end properly.
 */

public class MarbleSolitaireControllerImplTest {

  Appendable a1;
  Appendable a2;
  Appendable a3;
  Appendable a4;
  Appendable a5;
  Appendable a6;
  Appendable a7;
  Appendable a8;
  Appendable a9;
  Appendable a10;
  Appendable a11;
  Appendable a12;
  Appendable a13;
  Appendable a14;
  Appendable a15;

  MarbleSolitaireModel m1;
  MarbleSolitaireModel m2;
  MarbleSolitaireModel m3;
  MarbleSolitaireModel m4;
  MarbleSolitaireModel m5;

  @Before
  public void setUp() {
    this.a1 = new StringBuilder();
    this.a2 = new StringBuilder();
    this.a3 = new StringBuilder();
    this.a4 = new StringBuilder();
    this.a5 = new StringBuilder();
    this.a6 = new StringBuilder();
    this.a7 = new StringBuilder();
    this.a8 = new StringBuilder();
    this.a9 = new StringBuilder();
    this.a10 = new StringBuilder();
    this.a11 = new StringBuilder();
    this.a12 = new StringBuilder();
    this.a13 = new StringBuilder();
    this.a14 = new StringBuilder();
    this.a15 = new StringBuilder();
    this.m1 = new EnglishSolitaireModel();
    this.m2 = new EnglishSolitaireModel(4, 4);
    this.m3 = new EnglishSolitaireModel(5);
    this.m4 = new EnglishSolitaireModel(3, 2, 4);
    this.m5 = new EnglishSolitaireModel(5, 6, 9);
  }

  @Test
  public void testConstructor() {

    Readable testStart = new StringReader("");

    //normal game
    MarbleSolitaireTextView m1View = new MarbleSolitaireTextView(m1, a1);
    MarbleSolitaireControllerImpl test1 =
            new MarbleSolitaireControllerImpl(m1, m1View, testStart);


    MarbleSolitaireTextView m2View = new MarbleSolitaireTextView(m2, a3);
    MarbleSolitaireControllerImpl test2 =
            new MarbleSolitaireControllerImpl(m2, m2View, testStart);

    MarbleSolitaireTextView m3View = new MarbleSolitaireTextView(m3, a2);
    MarbleSolitaireControllerImpl test3 =
            new MarbleSolitaireControllerImpl(m3, m3View, testStart);

    MarbleSolitaireTextView m4View = new MarbleSolitaireTextView(m4, a4);
    MarbleSolitaireControllerImpl test4 =
            new MarbleSolitaireControllerImpl(m4, m4View, testStart);

    MarbleSolitaireTextView m5View = new MarbleSolitaireTextView(m5, a5);
    MarbleSolitaireControllerImpl test5 =
            new MarbleSolitaireControllerImpl(m5, m5View, testStart);

    //default model
    try {
      test1.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a1.toString());
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a1.toString());
    }

    //default model with moving empty slot
    try {
      test2.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a3.toString());
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a3.toString());
    }

    //different armThickness
    try {
      test3.playGame();
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
              "        O O O O O\n" +
              "Score: 104\n" +
              "You need to add more valid inputs!", this.a2.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    //changing thickness + moving empty slot
    try {
      test4.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O _ O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a4.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    //changing armThickness and moving empty slot
    try {
      test5.playGame();
      assertEquals("        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O _ O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "O O O O O O O O O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "        O O O O O\n" +
              "Score: 104\n" +
              "You need to add more valid inputs!", this.a5.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  @Test
  public void testConstructorExceptions() {

    MarbleSolitaireTextView m1View = new MarbleSolitaireTextView(this.m1, this.a1);

    try {
      new MarbleSolitaireControllerImpl(null, null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      new MarbleSolitaireControllerImpl(this.m1, null, new StringReader("hi"));
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      new MarbleSolitaireControllerImpl(null, m1View, new StringReader("hi"));
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }

    try {
      new MarbleSolitaireControllerImpl(this.m1, m1View, null);
      fail();
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  @Test
  public void testLegalMoves() {
    StringReader moveUp = new StringReader("6 4 4 4");
    StringReader moveDown = new StringReader("2 4 4 4");
    StringReader moveLeft = new StringReader("4 6 4 4");
    StringReader moveRight = new StringReader("4 2 4 4");

    MarbleSolitaireModel model1 = new EnglishSolitaireModel();
    MarbleSolitaireModel model2 = new EnglishSolitaireModel();
    MarbleSolitaireModel model3 = new EnglishSolitaireModel();
    MarbleSolitaireModel model4 = new EnglishSolitaireModel();

    MarbleSolitaireTextView m1View = new MarbleSolitaireTextView(model1, a1);
    MarbleSolitaireControllerImpl test1 =
            new MarbleSolitaireControllerImpl(model1, m1View, moveUp);

    MarbleSolitaireTextView m2View = new MarbleSolitaireTextView(model2, a2);
    MarbleSolitaireControllerImpl test2 =
            new MarbleSolitaireControllerImpl(model2, m2View, moveDown);

    MarbleSolitaireTextView m3View = new MarbleSolitaireTextView(model3, a3);
    MarbleSolitaireControllerImpl test3 =
            new MarbleSolitaireControllerImpl(model3, m3View, moveLeft);

    MarbleSolitaireTextView m4View = new MarbleSolitaireTextView(model4, a4);
    MarbleSolitaireControllerImpl test4 =
            new MarbleSolitaireControllerImpl(model4, m4View, moveRight);

    try {
      test1.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n", this.a1.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      test2.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O _ O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 31\n", this.a2.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      test3.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 31\n", this.a3.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      test4.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O _ _ O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 31\n", this.a4.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }


  }

  @Test
  public void testIllegalMoves() {

    //testing a move longer than 2
    Readable illegalMove1 = new StringReader("7 4 4 4");

    //testing a move that jumps over a marble onto another marble
    Readable illegalMove2 = new StringReader("7 4 5 4");

    //testing a move into invalid slots
    Readable illegalMove3 = new StringReader("2 3 2 1");

    //trying to move from an invalid slot onto the board
    Readable illegalMove4 = new StringReader("1 1 3 1");

    //trying to move diagonally
    Readable illegalMove7 = new StringReader("5 3 4 4");

    //trying to random move
    Readable illegalMove8 = new StringReader("5 1 3 7");

    //moving 2 slots in a horizontal direction and 2 slots in the vertical direction
    Readable illegalMove9 = new StringReader("9 5 7 7");

    //trying to jump over an empty slot onto a marble
    Readable illegalMove10 = new StringReader("5 4 3 4");

    //trying to jump from an empty slot
    Readable illegalMove11 = new StringReader("4 4 6 4");


    MarbleSolitaireTextView m1View = new MarbleSolitaireTextView(m1, a1);
    MarbleSolitaireControllerImpl test1 =
            new MarbleSolitaireControllerImpl(m1, m1View, illegalMove1);

    MarbleSolitaireTextView m2View = new MarbleSolitaireTextView(m1, a2);
    MarbleSolitaireControllerImpl test2 =
            new MarbleSolitaireControllerImpl(m1, m2View, illegalMove2);

    MarbleSolitaireTextView m3View = new MarbleSolitaireTextView(m1, a3);
    MarbleSolitaireControllerImpl test3 =
            new MarbleSolitaireControllerImpl(m1, m3View, illegalMove3);

    MarbleSolitaireTextView m4View = new MarbleSolitaireTextView(m1, a4);
    MarbleSolitaireControllerImpl test4 =
            new MarbleSolitaireControllerImpl(m1, m4View, illegalMove4);

    MarbleSolitaireTextView m7View = new MarbleSolitaireTextView(m1, a7);
    MarbleSolitaireControllerImpl test7 =
            new MarbleSolitaireControllerImpl(m1, m7View, illegalMove7);

    MarbleSolitaireTextView m8View = new MarbleSolitaireTextView(m1, a8);
    MarbleSolitaireControllerImpl test8 =
            new MarbleSolitaireControllerImpl(m1, m8View, illegalMove8);

    MarbleSolitaireTextView m9View = new MarbleSolitaireTextView(m1, a9);
    MarbleSolitaireControllerImpl test9 =
            new MarbleSolitaireControllerImpl(m3, m9View, illegalMove9);

    MarbleSolitaireTextView m10View = new MarbleSolitaireTextView(m1, a10);
    MarbleSolitaireControllerImpl test10 =
            new MarbleSolitaireControllerImpl(m1, m10View, illegalMove10);

    MarbleSolitaireTextView m11View = new MarbleSolitaireTextView(m1, a11);
    MarbleSolitaireControllerImpl test11 =
            new MarbleSolitaireControllerImpl(m1, m11View, illegalMove11);


    //moving more than 2 slots
    try {
      test1.playGame();

    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a1.toString());
    }

    //moving onto another marble
    try {
      test2.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a2.toString());
    }

    try {
      test3.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a3.toString());
    }

    try {
      test4.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a4.toString());
    }


    try {
      test7.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a7.toString());
    }

    try {
      test8.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a8.toString());
    }

    try {
      test9.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 104\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 104\n" +
              "You need to add more valid inputs!", this.a9.toString());
    }
  }

  @Test
  public void testIllegalMoveThenLegalMove() {

    Readable illegalThenLegal = new StringReader("6 4 4 3 6 4 4 4");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl illegalThenLegalGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, illegalThenLegal);

    try {
      illegalThenLegalGame.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "Invalid move. Play again. \n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "You need to add more valid inputs!", a1.toString());
    }
  }

  @Test
  public void testFilteringRandomInputs() {

    Readable randomLetters = new StringReader("6 r r s f h 4 4 4");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl randomLettersGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, randomLetters);

    //random letters everywhere with random spaces and a full move
    MarbleSolitaireModel defaultModel2 = new EnglishSolitaireModel();
    Readable randomLetters2 = new StringReader("r    r 6     s 4 f 4 h 4 h h    ");
    MarbleSolitaireTextView defaultTextView2 = new MarbleSolitaireTextView(defaultModel2, a2);
    MarbleSolitaireControllerImpl randomLettersGame2 =
            new MarbleSolitaireControllerImpl(defaultModel2, defaultTextView2, randomLetters2);


    //tests no attempted move and random stuff
    MarbleSolitaireModel defaultModel3 = new EnglishSolitaireModel();
    Readable randomLetters3 = new StringReader("r    r      s  f  h  h h    ");
    MarbleSolitaireTextView defaultTextView3 = new MarbleSolitaireTextView(defaultModel3, a3);
    MarbleSolitaireControllerImpl randomLettersGame3 =
            new MarbleSolitaireControllerImpl(defaultModel3, defaultTextView3, randomLetters3);

    //tests not a full move with random spaces and letters
    MarbleSolitaireModel defaultModel4 = new EnglishSolitaireModel();
    Readable randomLetters4 = new StringReader("r    r   5 5  s  f  h 2 h h    ");
    MarbleSolitaireTextView defaultTextView4 = new MarbleSolitaireTextView(defaultModel4, a4);
    MarbleSolitaireControllerImpl randomLettersGame4 =
            new MarbleSolitaireControllerImpl(defaultModel4, defaultTextView4, randomLetters4);


    //random negative numbers, random letters, spaces and a full move with additional positive
    //numbers
    MarbleSolitaireModel defaultModel5 = new EnglishSolitaireModel();
    Readable randomLetters5 = new StringReader("r  -3  r 0  6 4 -4 s  f  h 4 h h  -5  4 1 3 ");
    MarbleSolitaireTextView defaultTextView5 = new MarbleSolitaireTextView(defaultModel5, a5);
    MarbleSolitaireControllerImpl randomLettersGame5 =
            new MarbleSolitaireControllerImpl(defaultModel5, defaultTextView5, randomLetters5);
    try {
      randomLettersGame.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "You need to add more valid inputs!", this.a1.toString());
    }

    try {
      randomLettersGame2.playGame();

    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "You need to add more valid inputs!", this.a2.toString());
    }

    try {
      randomLettersGame3.playGame();

    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a3.toString());
    }

    try {
      randomLettersGame4.playGame();

    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a4.toString());
    }

    try {
      randomLettersGame5.playGame();

    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "You need to add more valid inputs!", this.a5.toString());
    }
  }

  @Test
  public void testLetterQCombinedWithOtherLetters() {

    //putting a "potential" quit game but making a valid move after
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    Readable randomLetters = new StringReader("qq45rege 6 4 4 4");
    MarbleSolitaireTextView defaultTextView1 = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl randomLettersGame5 =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView1, randomLetters);

    //inputting a double letter including q
    Readable quitting5 = new StringReader("qq");
    MarbleSolitaireModel defaultModel5 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView5 = new MarbleSolitaireTextView(defaultModel5, a5);
    MarbleSolitaireControllerImpl quittingGame5 =
            new MarbleSolitaireControllerImpl(defaultModel5, defaultTextView5, quitting5);

    try {
      randomLettersGame5.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n", this.a1.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }


    try {
      quittingGame5.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a5.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  //tests quitting with "q" and "Q"
  @Test
  public void testQuitingGameInDifferentSlots() {

    //lowercase q
    Readable quitting = new StringReader("q");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl quittingGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, quitting);

    //capital Q
    Readable quitting8 = new StringReader("Q");
    MarbleSolitaireModel defaultModel8 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView8 = new MarbleSolitaireTextView(defaultModel8, a8);
    MarbleSolitaireControllerImpl quittingGame8 =
            new MarbleSolitaireControllerImpl(defaultModel8, defaultTextView8, quitting8);

    //q in another slot (fromCol)
    Readable quitting9 = new StringReader("3 q 3 3");
    MarbleSolitaireModel defaultModel9 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView9 = new MarbleSolitaireTextView(defaultModel9, a9);
    MarbleSolitaireControllerImpl quittingGame9 =
            new MarbleSolitaireControllerImpl(defaultModel9, defaultTextView9, quitting9);

    //q in another slot (toRow)
    Readable quitting10 = new StringReader("3 3 q 3");
    MarbleSolitaireModel defaultModel10 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView10 = new MarbleSolitaireTextView(defaultModel10, a10);
    MarbleSolitaireControllerImpl quittingGame10 =
            new MarbleSolitaireControllerImpl(defaultModel10, defaultTextView10, quitting10);

    //q in another slot (toCol)
    Readable quitting11 = new StringReader("3 3 3 q");
    MarbleSolitaireModel defaultModel11 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView11 = new MarbleSolitaireTextView(defaultModel11, a11);
    MarbleSolitaireControllerImpl quittingGame11 =
            new MarbleSolitaireControllerImpl(defaultModel11, defaultTextView11, quitting11);

    try {
      quittingGame.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a1.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      quittingGame8.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a8.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      quittingGame9.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a9.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      quittingGame10.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a10.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      quittingGame11.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a11.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  @Test
  public void testAttemptingMoveAfterQuit() {
    //trying to make a move after quitting
    Readable quitting2 = new StringReader("q 6 4 4 4");
    MarbleSolitaireModel defaultModel2 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView2 = new MarbleSolitaireTextView(defaultModel2, a2);
    MarbleSolitaireControllerImpl quittingGame2 =
            new MarbleSolitaireControllerImpl(defaultModel2, defaultTextView2, quitting2);
    try {
      quittingGame2.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n", this.a2.toString());
    } catch (IllegalStateException e) {
      //do nothing
    }


  }

  @Test
  public void testQuittingAfterValidMoves() {

    //one move before quitting
    Readable quitting3 = new StringReader("6 4 4 4 q");
    MarbleSolitaireModel defaultModel3 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView3 = new MarbleSolitaireTextView(defaultModel3, a3);
    MarbleSolitaireControllerImpl quittingGame3 =
            new MarbleSolitaireControllerImpl(defaultModel3, defaultTextView3, quitting3);

    //two moves before quitting
    Readable quitting4 = new StringReader("6 4 4 4 5 6 5 4 q");
    MarbleSolitaireModel defaultModel4 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView4 = new MarbleSolitaireTextView(defaultModel4, a4);
    MarbleSolitaireControllerImpl quittingGame4 =
            new MarbleSolitaireControllerImpl(defaultModel4, defaultTextView4, quitting4);

    //two moves before quitting and placing a move after
    Readable quitting6 = new StringReader("6 4 4 4 5 6 5 4 q 7 5 5 5");
    MarbleSolitaireModel defaultModel6 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView6 = new MarbleSolitaireTextView(defaultModel6, a6);
    MarbleSolitaireControllerImpl quittingGame6 =
            new MarbleSolitaireControllerImpl(defaultModel6, defaultTextView6, quitting6);

    //three moves before quitting
    Readable quitting7 = new StringReader("6 4 4 4 5 6 5 4 7 5 5 5 q");
    MarbleSolitaireModel defaultModel7 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView7 = new MarbleSolitaireTextView(defaultModel7, a7);
    MarbleSolitaireControllerImpl quittingGame7 =
            new MarbleSolitaireControllerImpl(defaultModel7, defaultTextView7, quitting7);


    try {
      quittingGame3.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n", this.a3.toString());
    } catch (IllegalStateException e) {
      //do nothing
    }

    try {
      quittingGame4.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n", this.a4.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      quittingGame6.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n", this.a6.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

    try {
      quittingGame7.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "Score: 29\n" +
              "\n" +
              "Game quit!\n" +
              "State of game when quit:\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "Score: 29\n", this.a7.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  @Test
  public void testRenderingExceptions() {
    Readable testReadable = new StringReader("");
    CorruptedAppendables ca = new CorruptedAppendables();
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireView testMessageViewException =
            new MarbleSolitaireTextView(defaultModel, ca);

    try {
      MarbleSolitaireControllerImpl testRenderingExceptionGame =
              new MarbleSolitaireControllerImpl(defaultModel, testMessageViewException,
                      testReadable);
      testRenderingExceptionGame.playGame();
      fail();
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testRunningOutOfInputs() {
    Readable runOut = new StringReader("6 4 4");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl runningOutOfInputsGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, runOut);

    Readable runOut2 = new StringReader("6 4 ");
    MarbleSolitaireModel defaultModel2 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView2 = new MarbleSolitaireTextView(defaultModel2, a2);
    MarbleSolitaireControllerImpl runningOutOfInputsGame2 =
            new MarbleSolitaireControllerImpl(defaultModel2, defaultTextView2, runOut2);

    Readable runOutAfterMove = new StringReader("6 4 4 4 5 6 5");
    MarbleSolitaireModel defaultModel3 = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView3 = new MarbleSolitaireTextView(defaultModel3, a3);
    MarbleSolitaireControllerImpl runningOutOfInputsGame3 =
            new MarbleSolitaireControllerImpl(defaultModel3, defaultTextView3, runOutAfterMove);

    try {
      runningOutOfInputsGame.playGame();

    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a1.toString());
    }

    try {
      runningOutOfInputsGame2.playGame();

    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "You need to add more valid inputs!", this.a2.toString());
    }
    try {
      runningOutOfInputsGame3.playGame();
    } catch (IllegalStateException e) {
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "You need to add more valid inputs!", this.a3.toString());
    }

  }

  @Test
  public void testWinEndGame() {
    Readable win = new StringReader("6 4 4 4 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 2 5 " +
            "4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3 6 3 " +
            "4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 3 4 3 2 3 2 5 2 5 2 5 4 5 4 5 6 5 6 3 6 3" +
            " 6 3 4 4 4 4 6 2 4 4 4 4 3 4 5 4 6 4 4");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl winGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, win);

    try {
      winGame.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "Score: 29\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ O\n" +
              "Score: 28\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    _ _ O\n" +
              "Score: 27\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 26\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O _ O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 25\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ _\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 24\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 23\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ _ O O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 22\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 21\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 20\n" +
              "    _ O O\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 19\n" +
              "    O _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 18\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 17\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 16\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 15\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "_ _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 14\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 13\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O O _ _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 12\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 11\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ O _ _ O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 10\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ O O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 9\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 8\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ _ _ O _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 7\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O O _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 6\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 5\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O _ _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 4\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ O O _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 3\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ _ _ O O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 2\n" +
              "Game over!\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 1\n", this.a1.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  @Test
  public void testQuittingAfterWin() {
    //quitting shouldn't do anything
    Readable win = new StringReader("6 4 4 4 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 2 5 " +
            "4 5 3 7 3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3 6 3 " +
            "4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 3 4 3 2 3 2 5 2 5 2 5 4 5 4 5 6 5 6 3 6 3" +
            " 6 3 4 4 4 4 6 2 4 4 4 4 3 4 5 4 6 4 4 q");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl winGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, win);

    try {
      winGame.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "Score: 29\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ O\n" +
              "Score: 28\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    _ _ O\n" +
              "Score: 27\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 26\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O _ O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 25\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ _\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 24\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 23\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ _ O O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 22\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 21\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 20\n" +
              "    _ O O\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 19\n" +
              "    O _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 18\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 17\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 16\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 15\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "_ _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 14\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 13\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O O _ _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 12\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 11\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ O _ _ O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 10\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ O O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 9\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 8\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ _ _ O _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 7\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O O _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 6\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 5\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O _ _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 4\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ O O _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 3\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ _ _ O O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 2\n" +
              "Game over!\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 1\n", this.a1.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }

  @Test
  public void testLosingEndGame() {
    Readable losing = new StringReader("6 4 4 4 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 2 " +
            "5 4 5 3 7  3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3 " +
            "6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 3 4 3 2 3 2 5 2 5 2 5 4 5 4 5 6 5 6 " +
            "3 6 3 6 3 4 4 4 4 6 2 4 4 4 4 4 4 2");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl losingGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, losing);
    try {
      losingGame.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "Score: 29\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ O\n" +
              "Score: 28\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    _ _ O\n" +
              "Score: 27\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 26\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O _ O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 25\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ _\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 24\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 23\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ _ O O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 22\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 21\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 20\n" +
              "    _ O O\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 19\n" +
              "    O _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 18\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 17\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 16\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 15\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "_ _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 14\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 13\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O O _ _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 12\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 11\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ O _ _ O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 10\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ O O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 9\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 8\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ _ _ O _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 7\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O O _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 6\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 5\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O _ _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 4\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ O O _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 3\n" +
              "Game over!\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ O _ _ _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 2\n", this.a1.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }

  }

  @Test
  public void testQuittingAfterLosing() {

    //shouldn't be able to quit after losing

    Readable losing = new StringReader("6 4 4 4 5 6 5 4 7 5 5 5 7 3 7 5 4 5 6 5 7 5 5 5 2 " +
            "5 4 5 3 7  3 5 5 7 3 7 3 4 3 6 3 7 3 5 3 2 3 4 1 3 3 3 1 5 1 3 4 3 2 3 1 3 3 3 " +
            "6 3 4 3 5 1 5 3 3 1 5 1 5 4 5 2 5 1 5 3 3 4 3 2 3 2 5 2 5 2 5 4 5 4 5 6 5 6 " +
            "3 6 3 6 3 4 4 4 4 6 2 4 4 4 4 4 4 2 q");
    MarbleSolitaireModel defaultModel = new EnglishSolitaireModel();
    MarbleSolitaireTextView defaultTextView = new MarbleSolitaireTextView(defaultModel, a1);
    MarbleSolitaireControllerImpl losingGame =
            new MarbleSolitaireControllerImpl(defaultModel, defaultTextView, losing);
    try {
      losingGame.playGame();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Score: 32\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 31\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    O O O\n" +
              "Score: 30\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "Score: 29\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ O\n" +
              "Score: 28\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O _ _ O\n" +
              "    O _ O\n" +
              "    _ _ O\n" +
              "Score: 27\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O _ O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 26\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O _ O O\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 25\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ _\n" +
              "O O O O O O O\n" +
              "O O O O O _ O\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 24\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O O O _ O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 23\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ _ O O\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 22\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O O O _ O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 21\n" +
              "    O O O\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 20\n" +
              "    _ O O\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 19\n" +
              "    O _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 18\n" +
              "    O _ _\n" +
              "    O O _\n" +
              "O _ _ O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 17\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O _ O O O _\n" +
              "O O O O O _ _\n" +
              "    O _ _\n" +
              "    _ _ _\n" +
              "Score: 16\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "O O _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 15\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "O _ O O O _ _\n" +
              "O O O O O O _\n" +
              "_ _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 14\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O _ O O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 13\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "O O _ _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 12\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ O O O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 11\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ O _ _ O _ _\n" +
              "_ O O O O O _\n" +
              "_ _ O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 10\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ O O _ O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 9\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ O O _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 8\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O _ _\n" +
              "_ _ O O O O _\n" +
              "_ _ _ _ _ O _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 7\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ _ O O _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 6\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O O O _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 5\n" +
              "    _ _ _\n" +
              "    _ O _\n" +
              "_ _ _ O _ _ _\n" +
              "_ _ O _ _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 4\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ _ O O _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 3\n" +
              "Game over!\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "_ _ _ _ _ _ _\n" +
              "_ O _ _ _ O _\n" +
              "_ _ _ _ _ _ _\n" +
              "    _ _ _\n" +
              "    _ _ _\n" +
              "Score: 2\n", this.a1.toString());
    } catch (IllegalStateException e) {
      // do nothing
    }
  }
}
