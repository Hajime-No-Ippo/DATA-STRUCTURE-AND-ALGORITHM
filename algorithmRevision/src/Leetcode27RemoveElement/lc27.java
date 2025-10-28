package Leetcode27RemoveElement;

import java.util.Arrays;

public class lc27 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3, 1, 4, 5, 7};
        int val = 3;
        System.out.println(removeElement(arr, val));
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] ^ val) != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return k;
    }
}


