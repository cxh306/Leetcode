package origin;

import util.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }

    public TreeNode buildBST(int[] nums,int start,int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        int mid=(end+start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildBST(nums,start,mid-1);
        root.right=buildBST(nums,mid+1,end);
        return root;
    }
}
