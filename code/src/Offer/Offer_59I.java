package Offer;

import java.util.LinkedList;

public class Offer_59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        LinkedList<Integer> l=new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!l.isEmpty()&&nums[i]>nums[l.getLast()]){
                l.removeLast();
            }
            l.addLast(i);
        }
        ans[0]=nums[l.getFirst()];
        for(int i=k;i<nums.length;i++){
            if(i-k==l.getFirst()){
                l.removeFirst();
            }
            while(!l.isEmpty()&&nums[i]>nums[l.getLast()]){
                l.removeLast();
            }
            l.addLast(i);
            ans[i-k+1]=nums[l.getFirst()];
        }
        return ans;
    }
}
