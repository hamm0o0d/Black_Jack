package copyblackjack;

public class Player {
// 1.name
    private final String name;
    //2.score
    private int score = 0;
    //3.cards
    //why 11??????
    Card player_cards[] = new Card[11];
    //4.boolean blackjack
    private boolean blackjack = false;
      //5.boolean lose
    private boolean lose = false;
    
    private int cards_counter = 0;

    public Player(String name) {
        this.name = name;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public boolean isLose() {
        return lose;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public String getName() {
        return name;
    }

    public void add_Score(int score) {
        this.score += score;
        if (this.score == 21) {
            blackjack = true;
        } else if (this.score > 21) {
           Game.valid_score--;
            setLose(true);
        }

    }

    public int getScore() {
        return score;
    }

    public int getCards_counter() {
        return cards_counter;
    }

    public void add_Counter() {
        cards_counter++;
    }

}
