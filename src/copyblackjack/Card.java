
package copyblackjack;
//لسه موضوع الacciss modifiers

public class Card {
    //1.fields
    private final int suit;
     private final int rank;
      private final int value;
      

    //2.Parameterized constructor
    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    //3.copy constructor
public Card(Card card){
    suit=card.suit;
    rank=card.rank;
    value= card.value;
}
//4.getters
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
}
