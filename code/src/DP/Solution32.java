package DP;

public class Solution32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max_len = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
            if (s.charAt(i) == ')' && s.charAt(i - 1) == ')' && i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')
                dp[i] = dp[i - 1] + 2 + (i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }
}
