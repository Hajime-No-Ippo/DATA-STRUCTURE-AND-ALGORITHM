import java.util.Random;

public class CoinFlipSimulation {
    public static void main(String[] args) {
    int trials = 1_000_000;  // N, try different values
    int targetSum = 25;      // choose the sum you want to estimate
    int count = 0;

    Random ran = new Random();


    for(int i = 0; i < trials; i++){
        int sum = 0;

        for(int j = 0; j < 10; j++){
            sum += ran.nextInt(6)+1;        
        }

        if(sum == targetSum){
            count++;
        }
    }

    double p = (double) count / trials;
    double se = Math.sqrt(p * (1 - p) / trials);
    double z = 1.96;
    double lower = p - z * se;
    double upper = p + z * se;

    System.out.println("Estimated P = " + p);
    System.out.println("95% CI = [" + lower + ", " + upper + "]");

    double probability = (double) count/trials;
    System.out.println("Estimated P(sum = " + targetSum + ") = " + probability);
    }
}