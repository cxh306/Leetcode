package Divide;

import util.TreeNode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);
    }

    private TreeNode helper(int[] nums,int start,int end) {
        if(start>=end) return null;
        int maxValue=nums[start];
        int index=start;
        for (int i = start+1; i < end; i++) {
            if(nums[i]>maxValue){
                maxValue=nums[i];
                index=i;
            }
        }
        return new TreeNode(maxValue,helper(nums,start,index),helper(nums,index+1,end));
    }
}
