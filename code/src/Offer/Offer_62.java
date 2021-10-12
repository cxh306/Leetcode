package Offer;

public class Offer_62 {
    public int lastRemaining(int n, int m) {
        // if(n==1) return 0;
        // int index=m%n-1;
        // int ret1=lastRemaining(n-1,m);
        // return (index+1+ret1)%n;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=(ans+m%i)%i;
        }
        return ans;
    }
}
