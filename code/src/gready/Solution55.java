package gready;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int pre_max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<=pre_max) pre_max=Math.max(pre_max,i+nums[i]);
            else return false;
        }
        return true;
    }
}