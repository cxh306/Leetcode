package Offer;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * dfs,深度优先搜索+回溯
 */
public class Offer_34 {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        helper(root,target);
        return ans;
    }
    void helper(TreeNode node,int target){
        if(node==null) return;
        path.add(node.val);
        target-=node.val;
        if(node.left==null&&node.right==null&&target==0){
                ans.add(new LinkedList<>(path));
        }
        helper(node.left,target);
        helper(node.right,target);
        path.removeLast();
    }
}
