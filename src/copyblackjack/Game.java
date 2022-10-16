package copyblackjack;

import java.util.Random;
import java.util.Scanner;

//لسه موضوع ال acciss modifiers
public class Game {
// 1.array of 4players

    Player player[] = new Player[4];
    //2.array of 52cards
    Card cards[] = new Card[52];
    //3.  !!!
    static int valid_score = 4;
    //mine
   private static int max ;
   private static int counter = 0;
   private static int index;

    public static int getCounter() {
        return counter;
    }

    public static int getIndex() {
        return index;
    }
   
boolean dealer_win=false;
    //4.
    void generate_cards() {
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (j < 9) {
                    cards[k] = new Card(i, j, j + 1);
                    k++;
                } else if (j >= 9) {
                    cards[k] = new Card(i, j, 10);
                    k++;
                }
            }

        }

    }
//5.

    Card draw_cards() {

        Random rand = new Random();
        while (true) {
            int rand_I = rand.nextInt(52);
            if (cards[rand_I] != null) {
                Card c = cards[rand_I];
                cards[rand_I] = null;
                return c;
            }
        }

    }
//6.

    void set_player() {
        for (int i = 0; i < 4; i++) {
            if (i <= 2) {
                Scanner scan = new Scanner(System.in);
                String name = scan.next();
                player[i] = new Player(name);
            } else if (i == 3) {
                String name = "Dealer";
                player[i] = new Player(name);

            }
            for (int j = 0; j < 2; j++) {
                player[i].player_cards[player[i].getCards_counter()] = draw_cards();
                player[i].add_Score(player[i].player_cards[player[i].getCards_counter()].getValue());
                player[i].add_Counter();
            }

        }
    }
//7.
//proplem
    void update_max() {
        max = 0;
        for (int i = 0; i < 4; i++) {

            if (player[i].getScore() > max && (player[i].getScore()<=21)) {
                index = i;
                counter = 1;
                max = player[i].getScore();
            } else if (player[i].getScore() == max) {
                counter++;
            }
            
        }
    }

}
