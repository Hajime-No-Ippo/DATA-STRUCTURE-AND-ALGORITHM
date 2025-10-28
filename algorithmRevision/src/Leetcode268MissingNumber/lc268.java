package Leetcode268MissingNumber;
import java.util.*;

public class lc268 {
    public static void  main(String [] args){
        int [] arr = {0,1};
        System.out.println(missingNumber(arr));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] != (nums[i] + 1) && (i + 1) < n) {
                return nums[i] + 1;
            }
        }
        for (int num : nums) {
            if (num != 0) {
                return 0;
            }
        }
        return n;
    }
}
