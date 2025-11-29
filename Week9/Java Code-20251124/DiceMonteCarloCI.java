import java.util.Random;

public class DiceMonteCarloCI {
    public static void main(String[] args) {
        Random rand = new Random();
        int trials = 1_000_000;
        int targetSum =7;
        int count = 0;



        for (int i = 0; i < trials; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += rand.nextInt(6) + 1;
            }
            if (sum == targetSum) {
                count++;
            }
        }


        double probability = (double) count / trials;
        double se = Math.sqrt(probability * (1 - probability) / trials);

        double z = 1.96; // for 95% CI
        double lower = probability - z * se;
        double upper = probability + z * se;

        System.out.println("Estimated probability of sum = " + targetSum + " : " + probability);
        System.out.println("Approx. 95% confidence interval: [" + lower + ", " + upper + "]");
    }
}
