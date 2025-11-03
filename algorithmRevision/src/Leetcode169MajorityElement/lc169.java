package Leetcode169MajorityElement;

public class lc169 {
        public static void main(String[] args) {
            int[] arr = new int[]{8,8,7,7,7};
            System.out.println(majorityElement(arr));
        }
        public static int majorityElement(int[] nums) {
            int count = 1;
            int n = nums.length;
            int current;

            for(int i = 0; i < n; i++){
                count = 1;
                current = nums[i];
                for(int j = i + 1; j < n; j++){
                    if(nums[j] == current && i != j){
                        count++;
                    }
                }
                if (count > n / 2) {
                    return current;
                }

            }
            return -1;
        }

}
