package DP;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j=0;j < n;j++) {
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                if(i==0&&j==0){
                    dp[i][j]=1;
                    continue;
                }

                if(i==0) {
                    if(dp[i][j-1]!=0) dp[i][j]=1;
                    continue;
                }

                if(j==0) {
                    if(dp[i-1][j]!=0) dp[i][j]=1;
                    continue;
                }

                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
