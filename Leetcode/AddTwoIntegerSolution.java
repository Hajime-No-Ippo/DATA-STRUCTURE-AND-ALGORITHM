package leetcode;

import java.util.Scanner;

public class AddTwoIntegerSolution {
	public int sum(int num1, int num2) {
		return  num1 + num2;
	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input1:");
        int num1 = scan.nextInt();
        System.out.println("Input2:");
        int num2 = scan.nextInt();
        
        
        AddTwoIntegerSolution s = new AddTwoIntegerSolution();
        int result = s.sum(num1, num2);
        do {
        System.out.println("Output:" + result);
        
        System.out.println("Explanation: num1 is " + num1 + " num2 is " + num2 + " and their sum is " + num1 + " + " + num2 + " = " + result + " , so " + result + " is returned. ");
        }
        while(-100 >= num1 && num2 <= 100);
        }
}