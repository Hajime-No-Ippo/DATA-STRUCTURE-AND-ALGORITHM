    public class IBM_OA
    {
        public static void fizzBuzz(int n) {
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
