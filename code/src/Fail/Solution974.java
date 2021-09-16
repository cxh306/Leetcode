package Fail;

import org.junit.Test;

/**
 * rem(x,y)=x-y.*(fix(x./y)) fix表示向0整
 * mod(x,y)=x-y.*(floor(x./y)) floor表示向下取整
 * x,y同号时或x能整除y时,rem(x,y)==mod(x,y)
 * 否则,mod(x,y)=rem(x,y)+y
 *
 * 同余定理
 * Mod(a-b,k)==0和Mod(a,k)==Mod(b,k)是充要的
 *
 * Java中取模Math.floorMod,取余%
 */
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
