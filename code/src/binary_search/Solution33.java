package binary_search;

public class Solution33 {
    /**
     * 二分递归形式
     */
    public int search(int[] nums, int target) {
        return search(0,nums.length-1,nums,target);
    }

    public int search(int left, int right, int[] nums,int target){
        if(left>right) return -1;
        int mid=left+((right-left)>>1);
        if(nums[mid]==target) return mid;
        if(nums[mid]<target){
            int ans=search(mid+1,right,nums,target);
            if(nums[mid]>nums[left]){
                return ans;
            }
            else{
                if(ans!=-1) return ans;
                else return search(left,mid-1,nums,target);
            }
        }
        else{
            int ans=search(left,mid-1,nums,target);
            if(nums[mid]<nums[left]){
                return ans;
            }else{
                if(ans!=-1) return ans;
                else return search(mid+1,right,nums,target);
            }
        }
    }

}
