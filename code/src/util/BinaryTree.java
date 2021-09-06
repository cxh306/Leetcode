package util;

import java.util.LinkedList;

public class BinaryTree{
    public TreeNode root;
    public TreeNode createTree(Integer[] node){
        if(node.length==0){
            return null;
        }
        root=new TreeNode(node[0]);
        LinkedList<TreeNode> l = new LinkedList<>();
        l.addLast(root);
        for(int i=1;i<node.length;i++){
            TreeNode top = l.getLast();
            if(node[i]==null){
                top.left=null;
            }
            else{
                top.left=new TreeNode(node[i]);
                l.addFirst(top.left);
            }
            i++;
            if(i==node.length) break;
            if(node[i]==null){
                top.right=null;
            }else{
                top.right=new TreeNode(node[i]);
                l.addFirst(top.right);
            }
            l.removeLast();
        }
        return root;
    }
}
