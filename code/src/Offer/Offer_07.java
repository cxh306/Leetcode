package Offer;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class Offer_07 {
    public Map<Integer,Integer> map = new HashMap<>();
    public int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode build(int pbeg,int pend,int ibeg,int iend){
        if(pbeg>pend||ibeg>iend){
            return null;
        }
        int baseVal = pre[pbeg];
        TreeNode head = new TreeNode(baseVal);
        /**
         * 搜索中序遍历序列的与前序遍历序列相等的值的index耗时，用HashMap记录inorder的元素的index
         */
//        int inorderIndex=ibeg;
//        while(inorder[i]!=baseVal){
//            inorderIndex++;
//        }
        int inorderIndex = map.get(baseVal);
        int len = inorderIndex-ibeg;
        head.left = build(pbeg+1,pbeg+len,ibeg,inorderIndex-1);
        head.right = build(pbeg+len+1,pend,inorderIndex+1,iend);
        return head;
    }
}