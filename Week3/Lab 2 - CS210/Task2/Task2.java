import java.util.Random;
import java.util.Arrays;
public class Task2
{
    public static void main(String args[])
    {
        int n = 1000000000;
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(100000);
        }
//Declare the target
        int target = 99999;

//Calculate the running time
        long start = System.nanoTime(); // get starting time
        int nLS = binarySearch (arr, target);
        long end = System.nanoTime();       
        long elapsedTime = (end - start) / 1_000_000;
        System.out.println("Execution time: " + elapsedTime + " ms");

        System.out.println(nLS);
    }

//LS Function
    public static int linearSearch (int[] arr, int target)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] == target)
            {
                return i;
            }
        }
        return -1;
    }
    
//BS Function
    public static int binarySearch (int[] arr, int target)
    {
        Arrays.sort(arr);
        int right = arr.length - 1;
        for (int left = 0; left < right; left++)
        {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target)
            {
                return mid;
            }
            else if (arr[mid] > target)
            {
                left = mid + 1;
            }
            else if (arr[mid] < target)
            {
                right = mid - 1;
            }
        }
        return -1;
    }

}