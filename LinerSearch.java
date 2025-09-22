
public class LinerSearch {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int target = 30;
        boolean isFound = false;
        isFound = LSearch(arr, target);
        System.out.println(isFound);
    }

    public static boolean LSearch(int[] arr, int target) 
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }
}
