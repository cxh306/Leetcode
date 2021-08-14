package stack;

import org.junit.Test;
import util.BinaryTree;
import util.TreeNode;

/**
 * 面试题 17.12. BiNode
 */
public class Solution17_12 {
    public TreeNode head=null;
    public TreeNode pre=null;
    public TreeNode convertBiNode(TreeNode root) {
        if(root==null) return null;
        convertBiNode(root.left);
        if(head==null) {
            head=root;
        }else{
            pre.right=root;
        }
        pre=root;
        root.left=null;
        convertBiNode(root.right);
        return head;
    }

    @Test
    public void test(){
        BinaryTree binaryTree = new BinaryTree(new Integer[]{4, 2, 5, 1, 3, null, 6, 0});
        convertBiNode(binaryTree.getRoot());
    }
}
