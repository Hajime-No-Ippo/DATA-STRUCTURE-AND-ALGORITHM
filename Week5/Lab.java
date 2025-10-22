/*Task 1. Sum of the first n Natural Numbers 
Write a recursive method that returns the sum of numbers from 1 to n.
HINT: The sum of the first n number is equal to n + the sum of the first (n-1) numbers. To
verify if the output is correct, you can check with the formula n(n+1)/2. For instance,
n=10 the sum should be 10*11/2 = 55 */

/*Task 2 Reverse a String Recursively
Write a Java program to reverse a string using recursion.
Hint: in order to compute the reverse of a string s, take the first character, reverse
(=recursion!) the string without the first character, and add the first character at the end.
In order to manipulate strings, use the function */

import java.util.*;
public class Lab{
    //Task1
    public static void main(String args[]){
        System.out.println(sumNumbers(10)); //  Task1
        System.out.println(reverseString("HelloWorld")); //  Task2
    }

    public static int sumNumbers(int n){
        int sum = 0;
        while(true){
            sum+=n;
            n--;
            if(n>0){
                sumNumbers(n);
            }else{
                return sum;
            }
        }
    }

    public static String reverseString(String arr){
        int n = arr.length() - 1;
        String reverseStr = "";
        while(true){   
                reverseStr += arr.charAt(n);
                n--;
                String sub = arr.substring(0,n);
            if(n>1){
                reverseString(sub);
            }else{
                return reverseStr + sub;
            }
        }
        
    }
}