package edu.cnm.deepdive.model;

/**
 * Encapsulate a single playing card as a combination of {@Link Suit} and {@Link Rank}. Instance
 * of this class contains values.
 * @author ro417
 */


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck implements Comparator<Card> {

  private List<Card> cards;
  private List<Card> dealt;

  /**
   * suit{@Link Suit} value of card.
   * Rank{@Rank Rank} value of card.
   */


  public Deck(){
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

  /**
   * Suit{@Link Suit} value of cards being sorted out.
   */


  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  public void shuffle(Random rng) {
    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    cards.addAll(dealt);
    dealt.clear();
  }


  public int remaining() {
    return cards.size();
  }

  public int dealt() {
    return dealt.size();
  }
  /**Rank{@Link Rank} value of cards being sorted out.
   * */


  @Override
  public String toString() {
    return cards.toString();
  }

  public static void main(String[] args) {
    Deck deck = new Deck();
    System.out.println(deck);
    deck.shuffle(new SecureRandom());
    System.out.println(deck);
  }

  public void sort(boolean gather) {
    if (gather) {
      gather();
    }
    cards.sort(this);
  }

  @Override
  public int compare(Card card1, Card card2) {
    return Comparator.comparing(Card::getSuit).thenComparing(Card::getRank).compare(card1, card2);
  }
}
