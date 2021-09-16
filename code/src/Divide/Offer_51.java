package Divide;

import org.junit.Test;

public class Offer_51 {
    int count=0;
    public int reversePairs(int[] nums) {
        sort(nums,0,nums.length-1,new int[nums.length]);
        return count;
    }
    public void sort(int[] nums,int start,int end,int[] temp){
        if(start>end) return;
        if(start==end) {
            temp[start]=nums[start];
            return;
        }
        int mid=(start+end)/2;
        sort(nums,start,mid,temp);
        sort(nums,mid+1,end,temp);
        int i=start,j=mid+1;
        int k=0;
        while(i<=mid&&j<=end){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                count+=(mid-i+1);
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        while(j<=end){
            temp[k++]=nums[j++];
        }
        for(i=start,k=0;i<=end;i++,k++){
            nums[i]=temp[k];
        }
    }

    @Test
    public void test(){
        System.out.println(reversePairs(new int[]{7,5,6,4}));
    }
}
