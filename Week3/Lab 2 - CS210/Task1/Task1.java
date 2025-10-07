public class Task1
{
    public static void main(String args[])
    {
        int n = 10;
        int[] arr = new int[n];
        System.out.println(isPalindrome(arr));
    }

    public static boolean isPalindrome (int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if(arr.length == 0)
            {
                return false;
            }
            else if (arr[i] != arr[arr.length - 1 - i])
            {
                return false;
            }
        }
        return true;
    }
}