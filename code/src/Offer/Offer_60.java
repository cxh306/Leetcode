package Offer;

import java.util.Arrays;

public class Offer_60 {
    public double[] dicesProbability(int n) {
        /**
         * dp
         */
        int[][] dp=new int[2][];
        int k=0;
        int sum=0;
        for(int i=0;i<n;i++){
            k=1-k;
            dp[k]=new int[5*i+6];
            for(int j=0;j<dp[k].length;j++){
                if(i==0||j==0) dp[k][j]=1;
                else{
                    if (j < 6) {
                        dp[k][j] = dp[k][j - 1] + dp[1-k][j];
                    } else  if(j<5*i+1){
                        dp[k][j] = dp[k][j - 1] - dp[1-k][j - 6] + dp[1-k][j];
                    }else{
                        dp[k][j]=dp[k][j-1]- dp[1-k][j - 6];
                    }
                }
                if (i == n - 1) {
                    sum += dp[k][j];
                }
            }
        }
        double ans[] =new double[dp[k].length];
        for (int j = 0; j < ans.length; j++) {
            ans[j]=(double)dp[k][j]/sum;
        }
        return ans;
    }
}
