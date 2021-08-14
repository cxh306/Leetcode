package Offer;

public class Offer_17{
    public int[] printNumbers(int n) {
        int MaxValue = (int)Math.pow(10,n);
        int[] ans = new int[MaxValue-1];
        for(int i=0;i<MaxValue-1;i++){
            ans[i]=i+1;
        }
        return ans;
    }
}
