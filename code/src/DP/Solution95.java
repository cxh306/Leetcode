package DP;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    /**
     * 暴力递归
     */
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return generateTreeOfRange(1,n);
    }
    private List<TreeNode> generateTreeOfRange(int start,int end){
        List<TreeNode> allTrees=new ArrayList<>();
        if(start>end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i=start;i<=end;i++){
            List<TreeNode> leftTree = generateTreeOfRange(start, i - 1);
            List<TreeNode> rightTree = generateTreeOfRange(i+1, end);
            for (TreeNode treeNode : leftTree) {
                for (TreeNode node : rightTree) {
                    TreeNode root =new TreeNode(i);
                    root.left=treeNode;
                    root.right=node;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }


//    @Test
//    public void test(){
//        long l = System.currentTimeMillis();
//        generateTrees(15);
//        System.out.println(System.currentTimeMillis()-l);
//    }

}
