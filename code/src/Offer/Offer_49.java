package Offer;

public class Offer_49 {
    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int num_2=dp[a]*2,num_3=dp[b]*3,num_5=dp[c]*5;
            dp[i]=Math.min(num_2,Math.min(num_3,num_5));
            if(dp[a]*2==dp[i]) a++;
            if(dp[b]*3==dp[i]) b++;
            if(dp[c]*5==dp[i]) c++;
        }
        return dp[n-1];
    }
}
