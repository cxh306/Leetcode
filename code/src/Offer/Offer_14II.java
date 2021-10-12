package Offer;

public class Offer_14II {
    public int cuttingRope(int n) {
        int[][] dp=new int[n+1][2];
        final int c=1000000007;
        dp[1][0]=1;
        for (int i=2;i<=n;i++){
            int[] temp=new int[]{0,0};
            for (int j = i-1; j >=1 ; j--) {
                int first=dp[j][0];
                int second=dp[j][1];
                first*=i-j;
                second*=i-j;
                temp=compare(compare(new int[]{first,second},new int[]{(j*(i-j))%c,(j*(i-j))/c}),temp);
            }
            dp[i]=temp;
        }
        return dp[n][0];
    }

    public int[] compare(int[] o1,int[] o2){
        if(o1[1]>o2[1]||(o1[1]==o2[1]&&o1[0]>o2[0])) return o1;
        else return o2;
    }
}
