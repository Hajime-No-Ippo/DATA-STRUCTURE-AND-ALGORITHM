import java.util.*;

public class RandomTest {
    
    public static void main(String[] args) {
        
        Random rand = new Random(123);
        System.out.println(rand.nextInt(10));  //random int from 0 to 9
        System.out.println(rand.nextInt(10));  //random int from 0 to 9
        int a = 10;
        int b = 20;
        System.out.println(a+rand.nextInt(b+1));  //random int from a to b


        Random rand2 = new Random();
        System.out.println(rand2.nextInt(10));  //random int from 0 to 9
        System.out.println(rand2.nextInt(10));  //random int from 0 to 9
        a = 10;
        b = 20;
        System.out.println(a+rand2.nextInt(b+1));  //random int from a to b


    }
}