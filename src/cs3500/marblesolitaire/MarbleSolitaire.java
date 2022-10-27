package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.AbstractTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static java.lang.Integer.valueOf;

/**
 * Represents the class that allows one to play the game.
 */
public final class MarbleSolitaire {

  /**
   * The methods that allows one to the play the game.
   *
   * @param args that create the type of board to play
   */
  public static void main(String[] args) {
    String type = args[0];
    int size = -1;
    int holeRow = -1;
    int holeCol = -1;
    AbstractSolitaireModel model = null;
    AbstractTextView view = null;


    for (int i = 1; i < args.length; i++) {
      if (args[i].equals("-size")) {
        size = valueOf(args[i + 1]);
      } else if (args[i].equals("-hole")) {
        holeRow = valueOf(args[i + 1]);
        holeCol = valueOf(args[i + 2]);
      }
    }

    if (type.equals("european") || type.equals("english")) {
      if (size == -1) {
        size = 3;
      }

      if (holeRow == -1 || holeCol == -1) {
        holeRow = (3 * size - 2) / 2;
        holeCol = (3 * size - 2) / 2;
      }
    }

    if (type.equals("triangle")) {
      if (size == -1) {
        size = 5;
      }

      if (holeRow == -1 || holeCol == -1) {
        holeRow = 0;
        holeCol = 0;
      }
    }
    if (type.equals("european")) {
      model = new EuropeanSolitaireModel(size, holeRow, holeCol);
      view = new MarbleSolitaireTextView(model);
    } else if (type.equals("english")) {
      model = new EnglishSolitaireModel(size, holeRow, holeCol);
      view = new MarbleSolitaireTextView(model);
    } else if (type.equals("triangle")) {
      model = new TriangleSolitaireModel(size, holeRow, holeCol);
      view = new TriangleSolitaireTextView(model);
    }

    InputStreamReader readable = new InputStreamReader(System.in);

    MarbleSolitaireControllerImpl play = new MarbleSolitaireControllerImpl(model, view, readable);
    play.playGame();
  }
}
