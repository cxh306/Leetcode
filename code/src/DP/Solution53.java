package DP;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int pre=0;
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            pre=Math.max(pre+nums[i],nums[i]);
            ans=Math.max(pre,ans);
        }
        return ans;
    }
}
