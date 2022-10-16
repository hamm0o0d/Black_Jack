package copyblackjack;

import java.util.Scanner;

public class BlackJack {

    static Game game = new Game();

    public static void main(String[] args) {
        // GUI gui = new GUI();
        game.generate_cards();
        game.set_player();
        //  gui.runGUI(game.cards, game.player[0].player_cards, game.player[1].player_cards, game.player[2].player_cards, game.player[3].player_cards);

        for (int i = 0; i < 4; i++) {
            System.out.println("Player" + (i + 1) + " turn :");
            while (true) {
                game.update_max();
                //  System.out.println("max :: "+game.max);
                //System.out.println("current score: " + game.player[i].getScore());
                if (i == 3) {
                    if (game.getCounter() == 1 && game.getIndex() == i) {
                        game.dealer_win = true;
                        System.out.println("The winner is : Dealer");
                        break;
                    }
                }
                System.out.println("Hit or Stand :");
                Scanner scan = new Scanner(System.in);
                String s = scan.next();

                if (s.equals("Hit") || s.equals("hit")) {

                    Card card = game.draw_cards();
                    game.player[i].player_cards[game.player[i].getCards_counter()] = card;
                    if (i <= 2) {
                        // gui.updatePlayerHand(card, i);
                    } else if (i == 3) {
                        //   gui.updateDealerHand(card, game.cards);
                    }
                    game.player[i].add_Score(game.player[i].player_cards[game.player[i].getCards_counter()].getValue());
                    // System.out.println(game.player[i].getScore());
                    game.player[i].add_Counter();
                    if (!(game.player[i].isLose())) {
                        game.update_max();
                    }
                    if (game.player[i].isLose()) {
                        System.out.println("BUSTED Score :: " + game.player[i].getScore());
                        System.out.println("BUSTED");
                        break;
                    } else if (game.player[i].isBlackjack()) {
                        System.out.println("BLACKJACK");
                        break;
                    }
                } else if (s.equals("Stand") || s.equals("stand")) {
                    break;
                } else {
                    System.out.println("invalid input try again ...");
                }
            }
        }
        if (game.dealer_win == false) {
            if (game.getCounter() == 1) {
                System.out.println("The winner is : " + game.player[game.getIndex()].getName());
            } else {
                System.out.println("PUSH");
            }

        }
    }
}
