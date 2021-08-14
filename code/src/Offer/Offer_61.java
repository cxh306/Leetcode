package Offer;

import java.util.Arrays;

public class Offer_61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int cnt=0;
        Integer pre=null;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) cnt++;
            else{
                if(pre==null){
                    pre=nums[i];
                }else{
                    if(pre==nums[i]) return false;
                    cnt-=nums[i]-pre-1;
                    if(cnt<0) return false;
                    pre=nums[i];
                }
            }
        }
        return true;
    }
}
