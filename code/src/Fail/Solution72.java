package Fail;

/**
 * 对一个字符串的操作有:
 * 删除、修改、添加
 * 则对两个字符串的操作有
 * A删除,B删除,A修改,B修改，A添加,B添加
 *
 * 1、对B字符串的删除等价于对A字符串的添加
 * 2、对B字符串的修改等价于对A字符串的修改
 * 3、对B字符串的添加等价于对A字符串的删除
 *
 * 故总共有不同的操作
 * 对A添加
 * 对B添加
 * 对A修改
 *
 * 令dp[i][j]为A前i个字符串到B前j个字符串的最小编辑距离
 * 状态转移:
 *      dp[i-1][j]:A前i-1个字符串到B前j个字符串的最小编辑距离加上对A末尾添加一个字符  dp[i-1][j]+1
 *      dp[i][j-1]:A前i个字符串到B前j-1个字符串的最小编辑距离加上对B末尾添加一个字符  dp[i][j-1]+1
 *      dp[i-1][j-1]:
 *          若word1[i-1]==word2[j-1],那么就是A前i-1个字符串到B前j-1个字符串的最小编辑距离 dp[i-1][j-1]
 *          若word1[i-1]!=word2[j-1],那么就是A前i-1个字符串到B前j-1个字符串的最小编辑距离再修改A的末尾字符 dp[i-1][j-1]+1
 * 三者取最小值
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j]=Math.min(1+Math.min(dp[i-1][j],dp[i][j-1]),word1.charAt(i-1)==word2.charAt(j-1)?dp[i-1][j-1]:dp[i-1][j-1]+1);
            }
        }
        return dp[len1][len2];
    }
}
