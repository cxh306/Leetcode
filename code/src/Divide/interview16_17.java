package Divide;

public class interview16_17 {
    public int maxSubArray(int[] nums) {
        return helper(nums,0,nums.length-1)[2];
    }
    public int[] helper(int[] nums,int start,int end){
        if(start>end) return null;
        if(start==end){
            return new int[]{nums[start],nums[end],nums[start],nums[start]};
        }
        int mid=start+((end-start)>>1);
        int[] left=helper(nums,start,mid);
        int[] right=helper(nums,mid+1,end);
        int[] ans=new int[4];
        ans[0]=Math.max(left[0],left[3]+right[0]);
        ans[1]=Math.max(right[1],right[3]+left[1]);
        ans[2]=Math.max(Math.max(left[2],right[2]),left[1]+right[0]);
        ans[3]=left[3]+right[3];
        return ans;
    }
}
