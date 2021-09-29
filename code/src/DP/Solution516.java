package DP;

import org.junit.Test;

import java.util.Arrays;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][len-1];
    }

    public String longestPalindromeSubseq1(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i],"");
            dp[i][i]=String.valueOf(s.charAt(i));
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = s.charAt(i)+dp[i + 1][j - 1]+s.charAt(i) ;
                else dp[i][j] = dp[i + 1][j].length()>dp[i][j - 1].length()?dp[i+1][j]:dp[i][j-1];
            }
        }
        return dp[0][len-1];
    }

    @Test
    public void test(){
        String  s="ccccdc";
        System.out.println(longestPalindromeSubseq1(s));
    }
}
