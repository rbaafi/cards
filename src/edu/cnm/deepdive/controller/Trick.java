package edu.cnm.deepdive.controller;

/**
 * Encapsulates the suits of standard playing card. The enum includes a {@Link #} and
 * color methods, to return the immutable Unicode symbol and color color enum instance of any suits.
 */

import edu.cnm.deepdive.model.Card;
import edu.cnm.deepdive.model.Deck;
import edu.cnm.deepdive.model.Suit.Color;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Trick {

  private Deck deck;
  private List<Card> redPile;
  private List<Card> blackPile;
  private Random rng = new SecureRandom();

  public static void main(String[] args) {
    Trick trick = new Trick();
    trick.prepare();
    trick.split();
    trick.swap();
    trick.report();
  }

  /**
   * Swap{@Link Color} instance value for this suit.
   */


  private void prepare() {
    deck = new Deck();
    deck.shuffle(rng);
  }

  /** Preparing to shuffle {@Deck}
   */

  private void split() {
    redPile = new LinkedList<>();
    blackPile = new LinkedList<>();
    for (Card selector = deck.deal(); selector != null; selector = deck.deal()) {
      if (selector.getSuit().color() == Color.BLACK) {
        blackPile.add(deck.deal());
      } else {
        redPile.add(deck.deal());
      }
    }
  }

  /**
   * Split{@Link Color} instance value for this suit.
   *
   * Split {@Link Color} value.
   */


  private void swap() {
    int swapSize = rng.nextInt(1 + Math.min(blackPile.size(), redPile.size()));
    for (int i = 0; i < swapSize; i++) {
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }
  }

  private void report() {
    int redCount = 0;
    int blackCount = 0;
    for (Card c : redPile) {
      if (c.getSuit().color() == Color.RED) {
        redCount++;
      }
    }
    for (Card c : blackPile) {
      if (c.getSuit().color() == Color.BLACK) {
        blackCount++;
      }
    }
    System.out.printf("Red pile: %s. Red count: %d.%n", redPile, redCount);
    System.out.printf("Black pile: %s. Black count: %d.%n", blackPile, blackCount);
  }

}
