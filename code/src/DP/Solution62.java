package DP;

import org.junit.Test;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        int l = Math.min(m, n);
        int t = Math.max(m, n);
        int[][] dp = new int[2][l];

        for (int i = 0; i < l; i++) {
            dp[0][i] = 1;
        }
        int k=0;
        for (int i = 1; i < t; i++) {
            k = 1 - k;
            dp[k][0] = 1;
            for (int j = 1; j < l; j++) {
                dp[k][j] = dp[k][j - 1] + dp[1 - k][j];
            }
        }
        return dp[k][l-1];
    }

    @Test
    public void test(){
        long l = System.currentTimeMillis();
        uniquePaths(100000,100000);
        System.out.println(System.currentTimeMillis()-l);
    }
}
