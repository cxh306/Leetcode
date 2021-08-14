package Offer;

import util.TreeNode;

public class Offer_68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val>q.val) return lowestCommonAncestor(root,p,q);
        if(p.val<=root.val&&q.val>=root.val) return root;
        else if (q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return  lowestCommonAncestor(root.right,p,q);
        }
    }
}
