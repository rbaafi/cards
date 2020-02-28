package edu.cnm.deepdive.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hand {

  private List<Card> cards;
  private List<Card> dealt;


  public void Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

}
