    import java.util.*;
    public class IBM_OA
    {
/*SAMPLE       public static void fizzBuzz(int n) {
        // Write your code here
        if(n % 3 == 0 && n % 5 == 0)
            {
                System.out.println("FizzBuzz");
            }
            else if(n % 3 == 0 && n % 5 != 0)
            {
                System.out.println("Fizz");
            }
            else if(n % 3 != 0 && n % 5 == 0)
            {
                System.out.println("Buzz");
            }
            else
            {
                System.out.println(n);
            }
        }
       
        public static void main (String args[])
        {
            int n = 1;
            for(int i = 0; i <= 15; i++)
            {
                fizzBuzz(n++);
            }
            
        }

    }

*/


//IBM_OA_Q1
    class Result {
        public static int getMaxPositiveTransactions(List<Integer> transactions) {
            // Sort in descending order
            Collections.sort(transactions, Collections.reverseOrder()); //Collections function | reverseOrder() function
            
            long sum = 0;
            int count = 0;

            for (int t : transactions) { //Enhanced for loop
                sum += t;
                if (sum > 0)
                    count++;
                else
                    break;
            }
            return count;
        }
    }

//IBM_OA_Q2
    class Result {
        public static int getMaxUniqueServer(int[] capacities) {
            Arrays.sort(capacities);
            Set<Integer> used = new HashSet<>(); //HashSet

            for (int c : capacities) {
                if (c > 1 && !used.contains(c - 1)) {
                    used.add(c - 1);
                } else if (!used.contains(c)) {
                    used.add(c);
                } else if (!used.contains(c + 1)) {
                    used.add(c + 1);
                }
            }

            return used.size();
        }
    }
}


/*public class EmailRegistry
{
    public static void main(String[] args)
    {
        HashSet<String> emails = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while(true)
        {
            if(input.equalsIgnoreCase('exit'))
            {
                break;
            }
            else
            {
                emails.add(input);
            }
        }
        
        sc.close();
        for(String email: emails)
        {
            System.out.println(" - " + email);
        }
    }
}
    */