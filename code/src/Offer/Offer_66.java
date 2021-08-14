package Offer;

public class Offer_66 {
    public int[] constructArr(int[] a) {
        if(a.length==0) return new int[0];
        int[] dp_left=new int[a.length];
        int[] dp_right=new int[a.length];
        dp_left[0]=1;
        dp_right[0]=1;
        for (int i=1;i<dp_left.length;i++){
            dp_left[i]=dp_left[i-1]*a[i-1];
            dp_right[i]=dp_right[i-1]*a[a.length-i];
        }
        int[] ans=new int[a.length];
        for (int i=0;i<a.length;i++){
            ans[i]=dp_left[i]*dp_right[a.length-i-1];
        }
        return ans;
    }
}
