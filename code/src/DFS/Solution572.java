package DFS;

import util.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null&&root==null) return true;
        if(subRoot==null||root==null) return false;
        if(!helper(root,subRoot)) return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
        else return true;
    }
    public boolean helper(TreeNode root,TreeNode subRoot){
        if(subRoot==null&&root==null) return true;
        if(subRoot==null||root==null) return false;
        if(root.val==subRoot.val) return helper(root.left,subRoot.left)&&helper(root.right,subRoot.right);
        else return false;
    }

}
