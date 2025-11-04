package Leetcode26RemoveDuplicateFromArray;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class lc26 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(removeDuplicates(arr));
    }

    //Create new Index to modify the original Array, the length would be same,  but the index would record the new number of elements.
    //we call it overwrite
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
