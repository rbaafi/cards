package edu.cnm.deepdive.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shoe {

  private List<Card> cards;
  private List<Card> dealt;
  private Random rng = new Random();

  public Iterable<Deck> decks(Random rng) {
    dealt = new LinkedList<>();
    cards = new ArrayList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
    while (cards != null) {
      Card card = cards.isEmpty() ? null : cards.remove(0);
      dealt.add(card);
      dealt.clear();
    }
    return decks(rng);
  }
  public void shuffle() {
    Collections.shuffle(cards, rng);
  }
  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

}
