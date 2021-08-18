package DP;

import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

public class Solution132 {
    /**
     * 深度优先搜索+动态规划预处理
     */
    public int minCut(String s) {
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],true);
        }

        for (int i=n-1;i>=0;i--){
            for (int j=i+1;j<n;j++){
                dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
            }
        }

        int[] g=new int[n];
        for (int i=0;i<n;i++){
            int ans=Integer.MAX_VALUE;
            for (int j=i;j>=0;j--){
                if(dp[j][i]){
                    ans=Math.min(ans,j>0?g[j-1]+1:0);
                }
            }
            g[i]=ans;
        }

        return g[n-1];
    }


    @Test
    public void test(){
        Random r=new Random();
        int len=20000;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<len;i++){
            sb.append((char)('a'+r.nextInt(26)));
        }
        String s = sb.toString();
        long l = System.currentTimeMillis();
        minCut(s);
        System.out.println(System.currentTimeMillis()-l);
    }
}
