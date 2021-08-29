package binary_search;

import java.util.Arrays;

/**
 * 最长上升子序列
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int len=0;
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                dp[0]=nums[0];
                len=1;
                continue;
            }
            int right=len-1,left=0;
            while (left!=right){
                int mid=left+((right-left+1)>>1);
                if(dp[mid]<nums[i]){
                    left=mid;
                }else{
                    right=mid-1;
                }
            }
            if(nums[i]<=dp[left]) dp[left]=nums[i];
            else{
                dp[left+1]=Math.min(nums[i],dp[left+1]);
                len=Math.max(left+2,len);
            }
        }
        return len;
    }
}
