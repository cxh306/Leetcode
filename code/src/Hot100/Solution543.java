package Hot100;

import util.TreeNode;

public class Solution543 {
//    Map<TreeNode,Integer> map=new HashMap<>();
//    public int diameterOfBinaryTree(TreeNode root) {
//        map.put(null,0);
//        height(root);
//        return helper(root);
//    }
//    public int helper(TreeNode root){
//        if(root==null) return 0;
//        int left = helper(root.left);
//        int right = helper(root.right);
//        return Math.max(Math.max(left,right),1+map.get(root.left)+map.get(root.right));
//    }
//    public int height(TreeNode root){
//        if(root==null) return 0;
//        int left=height(root.left);
//        int right=height(root.right);
//        map.put(root,1+Math.max(left,right));
//        return 1+Math.max(left,right);
//    }


    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
