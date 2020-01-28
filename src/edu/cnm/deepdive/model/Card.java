package edu.cnm.deepdive.model;

import java.util.Objects;

/**
 * Encapsulate a single playing card as a combination of {@Link Suit} and {@Link Rank}. Instance
 * of this class are immutable
 * @author ro417
 */

public class Card {

  private final Suit suit;
  private final Rank rank;
  private final int hash;

  /**
   * Initializes the Card instances with the specified {@Link Suit} and {@Link Rank}.
   * @param suit{@Link Suit} value of card.
   * @param rank{@Rank Rank} value of card.
   */
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash(suit, rank);
  }

  /**
   * Return {@link Suit} of this Card intance.
   * @return
   */

  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns {@Link Rank} of this Card instance.
   */

  public Rank getRank() {
    return rank;
  }
  /**
   * Returns {@Link Suit} of this Card instance.
   */


  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }

  /**
   * Returns{@Link Color} instance value for this suit.
   *
   * @return {@Link Color} value.
   */


  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean comparison = false;
    if (obj == this) {
      comparison = true;
    } else if (obj instanceof Card && obj.hashCode() ==hash) {
      Card other = (Card) obj;
      if (suit == other.suit && rank == other.rank) {
        comparison = true;
      }
    }
    return comparison;
  }


}
