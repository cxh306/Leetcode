package origin;

import java.util.Arrays;

public class Solution204 {
//    /**
//     * 暴力
//     * @param n
//     * @return
//     */
//    public int countPrimes(int n) {
//        int ans=0;
//        for (int i = 2; i <= n; i++) {
//            if(isPrime(i)) ans++;
//        }
//        return ans;
//    }
//    boolean isPrime(int n){
//        int sqrt = (int)Math.sqrt(n);
//        for (int i = 2; i <= sqrt; i++) {
//            if(n%i==0) return false;
//        }
//        return true;
//    }

    /**
     * 埃氏筛
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int[] isPrime=new int[n];
        Arrays.fill(isPrime,1);
        int ans=0;
        for (int i = 2; i <n ; ++i) {
            if(isPrime[i]==1){
                ans++;
                if((long)(i*i)<n){
                    for (int j = i*i; j < n; j+=i) {
                        isPrime[j]=0;
                    }
                }
            }
        }
        return ans;
    }


}
