import java.util.Scanner;
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
       
        sieve(n);
    }

    public static void sieve(int n)
    {
        boolean isPrime[] = new boolean[n + 1];
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i < n; i++)
        {
            isPrime[i] = true; 
        }
        
        for(int p = 2; p * p <= n; p++)
        {
            if(isPrime[p])
            {
                for( int i = p * p; i < n; i += p)
                {
                    isPrime[i] = false;
                }
            }
        }

        for(int a = 0; a < isPrime.length; a++)
        {
            if(isPrime[a])
            {
                System.out.println(a + " ");
            }
        }
        System.out.print(" is prime");
    }
}