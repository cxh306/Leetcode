package DP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution45 {
    public int jump(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        int j=0;
        for(int i=1;i<len;i++){
            while (i-j<nums[j]){
                j++;
            }
            dp[i]=Math.min(Integer.MAX_VALUE,dp[j]);
        }
        return dp[len-1];
    }
}
