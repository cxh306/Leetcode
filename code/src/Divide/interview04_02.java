package Divide;

import util.TreeNode;

public class interview04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=left+((right-left+1)>>1);
        return new TreeNode(nums[mid],helper(nums,left,mid-1),helper(nums,mid+1,right));
    }
}
