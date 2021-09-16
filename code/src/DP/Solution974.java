package DP;

import org.junit.Test;

public class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map=new int[k];
        int sum=0;
        map[0]=1;
        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            ans+=map[Math.floorMod(sum,k)]++;
        }
        return ans;
    }

    @Test
    public void test(){
//        subarraysDivByK(new int[]{5},9);
        System.out.println(-5%-3);
    }
}
