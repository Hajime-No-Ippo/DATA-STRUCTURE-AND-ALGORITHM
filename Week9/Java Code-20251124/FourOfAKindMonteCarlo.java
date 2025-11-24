import java.util.*;

public class FourOfAKindMonteCarlo {


    public static void main(String[] args) {

        int N = 2000;  // number of simulations
        Random rnd = new Random();

        // Build deck
        ArrayList<Integer> deck = new ArrayList<>();
        for (int r = 1; r <= 13; r++) {
            for (int s = 1; s <= 4; s++) {
                deck.add(r);
            }
        }
        System.out.println(deck);
        int fourOfKindCount = 0;

        for (int i = 0; i < N; i++) {
            Collections.shuffle(deck, rnd);

            // Draw 7 cards (2 hole + 5 board)
            int[] rankCount = new int[13]; // for each card, count how many are in the 7 cards drawn

            for (int j = 0; j < 7; j++) {
                rankCount[deck.get(j)-1]++;
            }

            // Check for four-of-a-kind
            for (int c : rankCount) {
                if (c == 4) {
                    fourOfKindCount++;
                    break;
                }
            }
        }

        double p = (double) fourOfKindCount / N;

        // 95% confidence interval
        double se = Math.sqrt(p * (1 - p) / N);
        double lower = p - 1.96 * se;
        double upper = p + 1.96 * se;

        System.out.printf("Estimated Probability: %.6f%n", p);
        System.out.printf("95%% CI: [%.6f, %.6f]%n", lower, upper);
    }
}
