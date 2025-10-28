package Leetcode136SingleNumber;

public class lc136 {
    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(singleNumber(arr));
    }
    public static int singleNumber(int[] nums) {
        boolean isTwice = false;
        int currentVal = 0;
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        for (int i = 0; i < n; i++){
            currentVal = nums[i];
            isTwice = false;
            for(int j = 0; j < n; j++){
                if(nums[j] == currentVal && i != j){
                    isTwice = true;
                    break;
                }
            }
            if(!isTwice){
                return currentVal;
            }
        }
        return -1;
    }
}
