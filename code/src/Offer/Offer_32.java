package Offer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Offer_32 {
    public int[] levelOrder(TreeNode root) {
        LinkedList<TreeNode> l = new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return new int[0];
        }
        l.addFirst(root);
        while(!l.isEmpty()){
            int n=l.size();
            while(n-->0){
                TreeNode now=l.getLast();
                ans.add(now.val);
                if(now.left!=null) l.addFirst(now.left);
                if(now.right!=null) l.addFirst(now.right);
                l.removeLast();
            }
        }
        int len = ans.size();
        int[] a= new int[len];
        for (int i = 0; i < len; i++) {
            a[i]=ans.get(i);
        }
        return a;
    }

}
