package Offer;

import util.TreeNode;

public class Offer_28 {
    public boolean isSymmetric(TreeNode root) {
        return null==root?true:recur(root.left,root.right);
    }

    /**
     *判断L树和R树是否对称
     * 1.L树，R树均为空
     * 2.L树和R树根节点相等，且L树的左右子树分别与R树的右左子树对称
     */
    public boolean recur(TreeNode L,TreeNode R){
        if(L==null&&R==null) return true;
        if(L==null||R==null||L.val!=R.val) return false;
        return recur(L.left,R.right)&&recur(L.right,R.left);
    }
}