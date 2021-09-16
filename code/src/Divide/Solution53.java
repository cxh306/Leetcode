package Divide;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        return helper(nums,0,nums.length-1)[2];
    }
    public int[] helper(int[] nums,int i,int j){
        if(i==j){
            return new int[]{nums[i],nums[j],nums[i],nums[j]};
        }
        int mid=i+((j-i)>>1);
        int[] left_ans=helper(nums,i,mid);
        int[] right_ans=helper(nums,mid+1,j);
        int[] ans=new int[4];
        ans[0]=Math.max(left_ans[0],left_ans[3]+right_ans[0]);
        ans[1]=Math.max(right_ans[1],right_ans[3]+left_ans[1]);
        ans[2]=Math.max(Math.max(left_ans[2],right_ans[2]),left_ans[1]+right_ans[0]);
        ans[3]=left_ans[3]+right_ans[3];
        return ans;
    }
}
