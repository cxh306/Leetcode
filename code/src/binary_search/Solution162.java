package binary_search;

import org.junit.Test;

import java.util.Random;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        return find(0,nums.length-1,nums);
    }

    public int find(int left,int right,int[] nums){
        if(left==right) return left;
        int mid=left+((right-left)>>1);
        boolean l=mid-1<0||nums[mid-1]<nums[mid];
        boolean r=mid+1>=nums.length||nums[mid+1]<nums[mid];
        if(l&&r) return mid;
        else if(!l){
            return find(left,mid-1,nums);
        }else{
            return find(mid+1,right,nums);
        }
    }

    @Test
    public void test(){
        int len=Integer.MAX_VALUE/2/2/2/2;
        int[] nums=new int[len];
        Random r=new Random();
        while(len-->0){
            nums[len]= r.nextInt();
        }
        long l = System.currentTimeMillis();
        findPeakElement(nums);
        System.out.println(System.currentTimeMillis()-l);
    }
}
