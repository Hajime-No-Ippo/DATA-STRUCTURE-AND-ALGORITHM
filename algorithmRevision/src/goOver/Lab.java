package goOver;/*Task 1. Sum of the first n Natural Numbers
Write a recursive method that returns the sum of numbers from 1 to n.
HINT: The sum of the first n number is equal to n + the sum of the first (n-1) numbers. To
verify if the output is correct, you can check with the formula n(n+1)/2. For instance,
n=10 the sum should be 10*11/2 = 55 */

/*Task 2 Reverse a String Recursively
Write a Java program to reverse a string using recursion.
Hint: in order to compute the reverse of a string s, take the first character, reverse
(=recursion!) the string without the first character, and add the first character at the end.
In order to manipulate strings, use the function */

/*Task 3. isPalindrom helper */
public class Lab {


public static void main(String args[]){
    int[]arr = {11,42,3,43,52,61,17,47,38,12};
    System.out.println(sumNumbers(10)); //  Task1
    System.out.println(reverseString("HelloWorld")); //  Task2
    System.out.println(isPalindrome("navan"));// Task3
    bubbleSort(arr);
}

public static int sumNumbers(int n){
        if(n>0){
            return sumNumbers(n-1);
        }else
            return n;

}

public static String reverseString(String s) {
    if (s == null || s.length() <= 1) {
        return s;
    }
    return reverseString(s.substring(1)) + s.charAt(0);
}


public static boolean isPalindrome(String s) {
    if (s == null) {
        return false;  // or true based on how you treat null
    }
    return isPalindromeHelper(s, 0, s.length() - 1);
}

private static boolean isPalindromeHelper(String s, int left, int right) {
    if (left >= right) {
        return true;
    }
    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }
    return isPalindromeHelper(s, left + 1, right - 1);
}

//Recursion in sumNumbers
public static int sumNumber(int a){
    if(a>=0){
        return a+sumNumber(a-1);
    }else{
        return 0;
    }
}

//wrote a bubble sort
    public static void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i >= 0;i--){
            for(int j = 0; j < i; j++){
                if(arr[j]>arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //wrote a QuickSort
    public static void quickSort(int[] arr){

    }
}
