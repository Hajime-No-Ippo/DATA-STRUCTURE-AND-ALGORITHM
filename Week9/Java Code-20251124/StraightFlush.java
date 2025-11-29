import java.util.*;

public class StraightFlush {
    // Convert ranks to numbers for easier comparison
    static Map<String, Integer> rankValue = Map.ofEntries(
        Map.entry("2", 2),
        Map.entry("3", 3),
        Map.entry("4", 4),
        Map.entry("5", 5),
        Map.entry("6", 6),
        Map.entry("7", 7),
        Map.entry("8", 8),
        Map.entry("9", 9),
        Map.entry("10", 10),
        Map.entry("J", 11),
        Map.entry("Q", 12),
        Map.entry("K", 13),
        Map.entry("A", 14)
    );
    public static void main(String[] args) {
        ArrayList<String> deck = new ArrayList<>();
        String[] suits = {"H","D","C","S"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for(String suit: suits) {
            for(String rank: ranks) {
                deck.add(rank + suit);
            }
        }
        System.out.println(deck);
        Collections.shuffle(deck);

        // Draw 5 cards (2 hole + 5 board)
        int count = 0;    
        int trials = 1_000_000;
        for(int i = 0; i < trials; i++){
            Collections.shuffle(deck);
            List<String> hand = deck.subList(0,5);
            if(isStraight(hand)){
                count++;
            }
        }

        double p = (double)count/trials;
        double z =1.96;
        double se = Math.sqrt(p * (1-p)/trials);
        double lower = p - z * se;
        double higher = p + z * se;

        System.out.println("The possibilities: " + p);
        System.out.println("Appoximate 95% confidence interval: [" + lower+ "," + higher+"]" );

    }

    //test if the card is straight flush
    public static boolean isStraight(List<String> hand){
        char suit = hand.get(0).charAt(hand.get(0).length() - 1);

        List<Integer> ranks = new ArrayList<>();

        for(String card : hand){
            char s = card.charAt(card.length()-1);
            if(s !=suit){
                return false;
            }

            String rank = card.substring(0,card.length() -1);
            ranks.add(rankValue.get(rank));
        }
        Collections.sort(ranks);
        boolean straight = true;
        for(int i = 1; i< ranks.size(); i++){
            if(ranks.get(i) != ranks.get(i -1)+1){
                straight = false;
                break;
            }
        }

        boolean aceLow = ranks.equals(Arrays.asList(2,3,4,5,14));

        return straight || aceLow;
    }
}