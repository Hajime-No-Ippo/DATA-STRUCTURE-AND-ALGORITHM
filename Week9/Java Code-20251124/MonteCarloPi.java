import java.util.Random;

public class MonteCarloPi {

    public static void main(String[] args) {
        int numPoints = 10000;
        Random rand = new Random();

        int inside = 0;

        for (int i = 0; i < numPoints; i++) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();

            if (x * x + y * y <= 1.0) {
                inside++;
            }
        }

        // Estimate of p and pi
        double pHat = (double) inside / numPoints;
        double piHat = 4.0 * pHat;

        // Standard error of p and pi
        double sePHat = Math.sqrt(pHat * (1 - pHat) / numPoints);
        double sePiHat = 4.0 * sePHat;

        // 95% confidence interval
        double lower = piHat - 1.96 * sePiHat;
        double upper = piHat - 1.96 * sePiHat;  // UPDATING NEXT LINE
        upper = piHat + 1.96 * sePiHat;

        System.out.println("Estimated π = " + piHat);
        System.out.println("95% CI = [" + lower + ", " + upper + "]");
    }
}
