import java.util.Scanner;
public class Task3
{
    public static void main(String args[])
    {
//declare
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of matrix(n): ");
        int n = scan.nextInt();
        int[][] arr = new int[n][n];

//input        
        System.out.println("Enter matrix elements: ");
        for(int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.println("Enter Element at row " + i + ", column " + j);
                arr[i][j] = scan.nextInt();
            }
        }

//output
        System.out.println("You entered:");
        for(int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.println(arr[i][j] + " ");
            }
            System.out.println();
        }

        if(isMagic)
        {
            System.out.println("The square is a magic square!");
        }
        else
        {
            System.out.println("The square is NOT a magic square!");
        }
    }

//Decision
    public static boolean isMagic (int[][] arr)
    {
        int targetSum = 0;
        int n = arr.length;

//target
        for (int i = 0; i < n; i++)
        {
            targetSum += arr[0][i];
        }

//column
        for (int i = 0; i < n; i++)
        {
            int colSum = 0;
            for (int j = 0; j < n; j++)
            {
                colSum += arr[j][i];
            }
            if(colSum != targetSum)
            {
                return false;
            }
        }
        

//row
        for (int i = 0; i < n; i++)
        {
            int rowSum = 0;
            for (int j = 0; j < n; j++)
            {
                rowSum += arr[i][j];
            }
            if(rowSum != targetSum)
            {
                return false;
            }
        }

//diagnose
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < n; i++)
        {
            d1 += arr[i][i];
            d2 += arr[i][n-1-i];
        }
        if(d1 != targetSum || d2 != targetSum)
        {
            return false;
        }
        return true;
    }
}