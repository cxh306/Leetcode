package DP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=1;i<nums.length;i++){
            for (int j = i-1; j >=0 ; j--) {
                if(nums[j]<nums[i]) dp[i]=Math.max(dp[i],nums[j]+1);
                ans=Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}
