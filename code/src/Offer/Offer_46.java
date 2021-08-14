package Offer;

public class Offer_46 {
    public int translateNum(int num) {
//        char[] ch = String.valueOf(num).toCharArray();
//        int len = ch.length;
//        int[] dp = new int[len + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for(int i = 2; i <= len; i++){
//            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
//            if(n >= 10 && n <= 25){
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }else{
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[len];

        /**
         * 滚动数组优化空间
         */
        String src = String.valueOf(num);
        //r为dp[0],q为dp[0],p为dp[-1]
        int p=1,q=1,r=1;
        for (int i = 1; i < src.length(); ++i) {
            String pre = src.substring(i - 1, i+1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r=p+q;
            }else{
                r=q;
            }
            p=q;
            q=r;
        }
        return r;
    }
}
