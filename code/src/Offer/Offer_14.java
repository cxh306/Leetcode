package Offer;

public class Offer_14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<=i-1;j++){
                dp[i]=Math.max(dp[i],j*Math.max(dp[i-j],i-j));
            }
        }
        return dp[n];
    }
}