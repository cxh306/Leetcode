package Offer;

public class Offer_57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left!=right){
            if(nums[left]+nums[right]>target){
                right--;
            }else if(nums[left]+nums[right]<target){
                left++;
            }else{
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[0];
    }
}
