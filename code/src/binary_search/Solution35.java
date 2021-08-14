package binary_search;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        Integer index=null;
        int i=0,j=nums.length-1;
        while (i!=j){
            int mid=i+((j-i)>>1);
            if(nums[mid]<target){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        if(nums[i]<target){
            index=nums.length;
        }else{
            index=i;
        }
        return index;
    }
}
