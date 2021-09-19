package DP;

public class interview16_17 {
    public int maxSubArray(int[] nums) {
        int temp=0;
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            temp=nums[i]+(temp>0?temp:0);
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}
