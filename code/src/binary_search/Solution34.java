package binary_search;

public class Solution34 {
    public int[] ans={-1,-1};
    public int[] searchRange(int[] nums, int target) {
        find(0,nums.length-1,nums,target);
        return ans;
    }

    public void find(int left,int right,int[] nums,int target){
        if(left>right) return;
        int mid=left+((right-left)>>1);
        if(nums[mid]==target){
            if(mid-1<0||nums[mid-1]<target) ans[0]=mid;

            if(mid+1>=nums.length||nums[mid+1]>target) ans[1]=mid;

            if(ans[0]==-1) find(left,mid-1,nums,target);

            if(ans[1]==-1) find(mid+1,right,nums,target);

        }else if(nums[mid]>target){
            find(left,mid-1,nums,target);
        }else{
            find(mid+1,right,nums,target);
        }
    }
}
