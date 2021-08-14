package Offer;

public class Offer_10 {
    public int numWays(int n) {
        /**
         * 直接递归，重复计算
         */
        //return numWays(n-1)+numWays(n-2);

        /**
         * 动态规划
         */

        //初始条件，一级台阶1种跳法,二级台阶2种跳法
//        int dp[] = new int[n];
//        dp[0] = 1;
//        dp[1] = 2;

//        for(int i=2;i<=n;i++){
//            dp[i] = dp[i-1]+dp[i-2];
//        }

        /**优化
         * 滚动数组
         *
         * 取余运算优化:x%(2^N)==x&(2^N-1)
         */
        int dp[] = new int[2];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i%2]=(dp[0]+dp[1])%1000000007;//i&1
        }
        return dp[n%2];//dp[n&1]
    }
}

