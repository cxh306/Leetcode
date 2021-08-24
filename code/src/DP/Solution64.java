package DP;

import java.util.Arrays;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp = new int[2][n+1];
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][1]=0;
        for (int i = 1; i <= m; i++) {
            int k=i%2;
            dp[k][0]=Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                dp[k][j]=grid[i-1][j-1]+Math.min(dp[1-k][j],dp[k][j-1]);
            }
        }
        return dp[m%2][n];
    }


}
