package edu.cnm.deepdive.model;

/**
 * Encapsulates the suits of standard playing card. The enum includes a {@Link #} and
 * color methods, to return the immutable Unicode symbol and color color enum instance of any suits.
 */

public enum Suit {
  CLUBS, DIAMONDS, HEARTS, SPADES;

  private static final String[] symbols = {"\u2663", "\u2662", "\u2661", "\u2660"};
  private static final Color[] colors = {Color.BLACK, Color.RED, Color.RED, Color.BLACK};

  /**
   * Returns unicode playing card symbol for this suit.
   *
   * @return unicode symbol.
   */

  public String symbol() {
    return symbols[ordinal()];
  }

  /**
   * Returns{@Link Color} instance value for this suit.
   *
   * @return {@Link Color} value.
   */

  public Color color() {
    return colors[ordinal()];
  }

  /**
   * Encapsulate the two possible colors (red &amp; black) ofpaying card suits.
   */
  public enum Color {
    RED, BLACK;
  }

}
