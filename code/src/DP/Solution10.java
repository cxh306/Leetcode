package DP;

import org.junit.Test;

/**
 * 10. 正则表达式匹配
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        int i = 2;
        while (i <= n && p.charAt(i - 1) == '*') {
            dp[0][i] = true;
            i += 2;
        }

        for (i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    int k = i;
                    while (k >= 1 && (s.charAt(k - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        if (dp[k][j - 2]) {
                            dp[i][j] = true;
                            break;
                        }
                        k--;
                    }
                    if (dp[i][j] == false) {
                        dp[i][j] = dp[k][j - 2];
                    }
                } else if (p.charAt(j - 1) == '.') dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    @Test
    public void test(){
        System.out.println(isMatch("aaa","ab*a*c*a"));
    }
}
