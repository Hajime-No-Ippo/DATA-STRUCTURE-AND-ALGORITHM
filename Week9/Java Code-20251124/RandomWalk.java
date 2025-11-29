import java.util.*;

public class RandomWalk {
    int org = 0;
    
    Random rand = new Random();
    public static void main(String[] args) {
        int trials = 1_000_000;
        int back = 0;
        for(int i = 0; i < trials; i++){
            RandomWalk temp = new RandomWalk();
            back += isZero(temp.org);
        }
        
        
        double z = 1.96;
        double p = (double)back/trials;
        double se = Math.sqrt(p * (1 - p)/trials);
        double higher = p + z * se;
        double lower = p - z * se;
        
        
        System.out.println("The possibility of staying at 0: " + p);
        System.out.println("95% Confidence Interval: [" + lower + "," + higher+ "]");

    }

    public RandomWalk() {
        this.org = 0;
        int walks = 20;
        boolean step = rand.nextBoolean();
        
        for(int i = 0; i < walks; i++){
            step = rand.nextBoolean();
        
            if (step) {
                org++;
            } else {
                org--;
            }
        }
    }

    public static int isZero(int x){
        int count = 0;
        if(x == 0){
            count++;
        }
        return count;
    }
}
