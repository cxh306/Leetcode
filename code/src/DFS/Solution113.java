package DFS;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }
        targetSum-=root.val;
        temp.add(root.val);
        if(root.left==null&&root.right==null&&targetSum==0){
            List<Integer> now=new LinkedList<>(temp);
            res.add(now);
        }

        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        temp.remove(temp.size()-1);
        return res;
    }

}
