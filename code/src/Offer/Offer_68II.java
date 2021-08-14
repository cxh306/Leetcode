package Offer;

import util.TreeNode;

import java.util.LinkedList;

public class Offer_68II {
    LinkedList<TreeNode> l=new LinkedList<>();
    TreeNode pre=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root,p);
        TreeNode ans= null;
        while(!l.isEmpty()){
            ans=l.removeLast();
            if(pre==null){
                if(findNode(ans,q)) break;
            }else{
                if(ans==q||findNode(ans.left==pre?ans.right:ans.left,q)){
                    break;
                }
            }
            pre=ans;
        }
        return ans;
    }
    public boolean findNode(TreeNode root,TreeNode p){
        if(root==null) return false;
        l.addLast(root);
        if(root==p) return true;
        boolean flag=findNode(root.left,p)||findNode(root.right,p);
        if (flag==false){
            l.removeLast();
        }
        return flag;
    }
}
