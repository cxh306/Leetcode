package Offer;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Offer_32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> l = new LinkedList<>();
        /**
         * 用flag来判别l是从后往前还是从前往后访问
         * l==true:从后往前
         * l==false:从前往后
         */
        boolean flag = true;
        if(root==null) return ans;
        l.add(root);
        while(!l.isEmpty()){
            int n=l.size();
            List<Integer> pp = new LinkedList<>();
            while(n-->0) {
                if (flag) {
                    TreeNode tail = l.getLast();
                    pp.add(tail.val);
                    if(tail.left!=null) l.addFirst(tail.left);
                    if(tail.right!=null) l.addFirst(tail.right);
                    l.removeLast();
                }else{
                    TreeNode head = l.getFirst();
                    pp.add(head.val);
                    if(head.right!=null) l.addLast(head.right);
                    if(head.left!=null) l.addLast(head.left);
                    l.removeFirst();
                }
            }
            ans.add(pp);
            flag=!flag;
        }
        return ans;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> l = new LinkedList<>();
        if(root==null) return ans;
        l.add(root);
        while(!l.isEmpty()){
            int n=l.size();
            LinkedList<Integer> pp = new LinkedList<>();
            while(n-->0) {
                //poll获得头元素并删除
                TreeNode node = l.poll();
                if(ans.size()%2==0){
                    pp.addLast(node.val);
                }else{
                    pp.addFirst(node.val);
                }
                if(node.left!=null) l.addLast(node.left);
                if(node.right!=null) l.addLast(node.right);
                l.removeFirst();
            }
            ans.add(pp);
        }
        return ans;
    }
}
