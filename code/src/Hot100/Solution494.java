package Hot100;

import java.util.*;

public class Solution494 {
    HashMap<Integer,Integer>[] res;
    public int findTargetSumWays1(int[] nums, int target) {
        res=new HashMap[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=new HashMap<>();
        }
        return dfs(nums,nums.length-1,target);
    }
    public int dfs(int[] nums,int n,int target){
        if(n==0){
            int left=0,right=0;
            if(nums[0]==target) {
                left++;
            }
            if(nums[0]==-target) {
                right++;
            }
            res[0].put(target,left+right);
            return left+right;
        }
        int left=res[n-1].containsKey(target+nums[n])?res[n-1].get(target+nums[n]):dfs(nums,n-1,target+nums[n]);
        int right=res[n-1].containsKey(target-nums[n])?res[n-1].get(target-nums[n]):dfs(nums,n-1,target-nums[n]);
        res[n].put(target,left+right);
        res[n].clear();
        return left+right;
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum-target<0||(sum-target)%2!=0) return 0;
        int len=(sum-target)/2;
        int[][] dp=new int[nums.length+1][len+1];
        dp[0][0]=1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <=len; j++) {
                dp[i][j]=dp[i-1][j];
                if(j-nums[i-1]>=0) dp[i][j]+=dp[i-1][j-nums[i-1]];
            }
        }
        return dp[nums.length][len];
    }

    public int findTargetSumWays3(int[] nums, int target) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum-target<0||(sum-target)%2!=0) return 0;
        int len=(sum-target)/2;
        int[][] dp=new int[2][len+1];
        dp[0][0]=1;
        int k=0;
        for (int i = 1; i <= nums.length; i++) {
            k=1-k;
            for (int j = 0; j <=len; j++) {
                dp[k][j]=dp[1-k][j];
                if(j-nums[i-1]>=0) dp[k][j]+=dp[1-k][j-nums[i-1]];
            }
        }
        return dp[k][len];
    }


}
