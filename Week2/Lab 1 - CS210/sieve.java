/**
 * A Java implementation of the Sieve of Eratosthenes algorithm.
 * This program finds all prime numbers up to a given number n.
 */
import java.util.Arrays;

public class sieve {

    /*
     * Main method to demonstrate the Sieve of Eratosthenes.
     */
    public static int counter=0;

    public static boolean[] sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize all entries it as true.
        // A value in prime[i] will finally be false if i is Not a prime, else true.
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        // Start from 2, as 0 and 1 are not prime numbers.
        // We should test all the number from up to the limit n, but it is enough to stop when p <= sqrt(n) (or p*p <=n). 
        // Indeed, it can be proven mathematically that if a number is not prime, it must have a fator that it is less than its square root,
        // therefore we need just to test the number p from 2 to sqrt(n).
        for (int p = 2; p<= Math.sqrt(n); p++) {
            
            // If prime[p] is still true, then it is a prime.
            if (prime[p]) {
                // Update all multiples of p as not prime.
                // The loop starts from p*p because smaller multiples of p
                // (like 2*p, 3*p, etc.) would have already been marked by
                // smaller prime numbers.
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                    counter++;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        
        
        int limit = 1000; // Find prime numbers up to the value of the "limit" variable.
        boolean[] isPrime = sieveOfEratosthenes(limit);  //isPrima is an array of boolean, isPrime[n] = true if number n is prime
        
        int[] sum = new int[limit];

        System.out.println("Primes up to " + limit + ":");
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }

        for (int z = 2; z < sum.length; z++) {
            if (isPrime[z]) {
                sum[z] = z;
//                System.out.print(sum[z] + " ");
            }
        }

        boolean isFound = false;
        System.out.print("\n" + limit);
         for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum.length; j++) {
                if (sum[i] + sum[j] == limit && isFound != true) {
                    System.out.print(" = " + sum[i] + " + " + sum[j]);
                    isFound = true;
                }
                
            }
        }
        
        //System.out.println();
        //System.out.println(counter);
    }
}
