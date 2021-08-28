package binary_search;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        return find(0,nums.length-1,nums,target);
    }

    public boolean find(int left,int right,int[] nums,int target){
        if(left>right) return false;
        int mid= left+((right-left)>>1);
        if(nums[mid]==target) return true;
        if(nums[mid]>target){
            if(nums[mid]>=nums[left]){
                return find(left,mid-1,nums,target)||find(mid+1,right,nums,target);
            }else{
                return find(left,mid-1,nums,target);
            }
        }else{
            if(nums[mid]<=nums[left]){
                return find(left,mid-1,nums,target)||find(mid+1,right,nums,target);
            }else{
                return find(mid+1,right,nums,target);
            }
        }
    }
}
