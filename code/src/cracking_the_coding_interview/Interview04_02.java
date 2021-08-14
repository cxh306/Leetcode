package cracking_the_coding_interview;

import util.TreeNode;

public class Interview04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int beg,int end) {
        if(beg>end) return null;
        int mid=beg+((end-beg)>>1);
        return new TreeNode(nums[mid],helper(nums,beg,mid-1),helper(nums,mid+1,end));
    }
}
