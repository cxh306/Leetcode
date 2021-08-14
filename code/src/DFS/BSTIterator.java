package DFS;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTIterator {
    private ArrayList<Integer> l=new ArrayList<>();
    int i=0;
    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.left);
        l.add(root.val);
        inorderTraversal(root.right);
    }
    public int next() {
        if(i<l.size()) return l.get(i++);
        return -1;
    }

    public boolean hasNext() {
        if(i<l.size()) return true;
        else return false;
    }
}
