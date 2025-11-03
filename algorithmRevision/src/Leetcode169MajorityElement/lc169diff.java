package Leetcode169MajorityElement;
//boyer-moore
public class lc169diff {
    public static void main(String[] args) {
        int[] arr = new int[]{8,8,7,7,7};
        System.out.println(majorityElement(arr));
    }
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
                count = 1;
            } else if(num == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
