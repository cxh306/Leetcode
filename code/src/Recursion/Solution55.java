package Recursion;

public class Solution55 {
    public double myPow(double x, int n) {
       return helper(x,n);
    }

    public double helper(double x,long n){
        if(n==0) return 1;
        if(x==0) return 0;
        if(n==1) return x;
        if(n<0){
            return helper(1/x,-n);
        }
        double temp=helper(x,n/2);
        return temp*temp*(n%2==0?1:x);
    }
}
