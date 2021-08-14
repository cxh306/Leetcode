package Offer;

import java.util.ArrayList;
import java.util.List;


public class Offer_03 {
    public int findRepeatNumber(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        int i=0;
        while(!arr[nums[i]]){
            arr[nums[i]] = true;
            i++;
        }
        return nums[i];
    }
}