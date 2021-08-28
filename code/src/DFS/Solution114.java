package DFS;

import org.junit.Test;
import util.BinaryTree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution114 {
    List<TreeNode> l=new ArrayList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode pre=new TreeNode();
        for (TreeNode treeNode : l) {
            pre.left=null;
            pre.right=treeNode;
            pre=treeNode;
        }
        pre.right=null;
        pre.left=null;
    }

    public void dfs(TreeNode root){
        if(root==null) return;
        l.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    @Test
    public void test(){
        BinaryTree binaryTree = new BinaryTree(new Integer[]{1, 2, 5, 3, 4, null, 6});

        flatten(binaryTree.getRoot());
    }
}
