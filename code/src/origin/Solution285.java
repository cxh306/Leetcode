package origin;

import util.TreeNode;

public class Solution285 {
    /**
     * inorderSuccessor(TreeNode root, TreeNode p)代表以root为根的树有没有指定p的后继节点，空为没有，非空为这个值
     * 1.遍历左子树，如果左树非空，则以该root为根的树有指定的值，返回左树结果即可
     * 2.当pre和p相等,则p的后继节点就是root
     * 3.把root记为pre,遍历右子树，返回其结果
     */
    TreeNode pre=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null) return null;
        TreeNode left=inorderSuccessor(root.left,p);
        if(left!=null) return left;
        if(pre==p) return root;
        pre=root;
        return inorderSuccessor(root.right,p);
    }
}
