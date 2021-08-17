package Tree;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue=new LinkedList<>();
        if(root!=null) queue.push(root);
        int sum=0;
        while (!queue.isEmpty()){
            int n=queue.size();
            sum=0;
            while (n-->0){
                TreeNode top=queue.removeLast();
                sum+=top.val;
                if(top.left!=null) queue.addFirst(top.left);
                if(top.right!=null) queue.addFirst(top.right);
            }
        }
        return sum;
    }
}
