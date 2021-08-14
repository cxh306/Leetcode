package Offer;

import util.TreeNode;

public class Offer_36 {
    /**
     * 中序遍历
     */
    public TreeNode head,tail;
    public void dfs(TreeNode cur){
        if(cur==null) return;
        //dfs(cur.left)返回代表以cur的左子树已经完成链表构建，且此时pre=循环链表的尾节点，pre.right=null
        dfs(cur.left);
        //若pre为空,即左子树是空，则头节点就是cur;
        if(tail==null) head=cur;
        //否则连接左子树的双向链表,pre的右节点就是cur,cur的左节点就是pre
        else{
            tail.right=cur;
            cur.left=tail;
        }
        //cur访问完毕,则pre变为cur
        tail=cur;
        //继续访问右子树
        dfs(cur.right);
    }
    public TreeNode treeToDoublyList(TreeNode root) {
//        if(root==null) return null;
//        else return helper1(root).right;
        if(root==null) return null;
        //完成了以root为根节点的双向链表构建，此时head节点的左节点为空，tail的右元素为空
        dfs(root);
        //头尾相连，组成循环链表
        head.left=tail;
        tail.right=head;
        return head;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public TreeNode helper1(TreeNode root){
        if(root==null) return null;
        TreeNode left_last = helper1(root.left);
        TreeNode right_last = helper1(root.right);
        if(left_last==null&&right_last==null){
            root.left=root;
            root.right=root;
            return root.right;
        }else if(left_last==null){
            root.right=right_last.right;
            right_last.right=root;
            root.left=right_last;
            root.right.left=root;
            return right_last;
        }else if(right_last==null){
            left_last.right.left=root;
            root.right=left_last.right;
            root.left=left_last;
            left_last.right=root;
            return root;
        }
        else {
            TreeNode left_first = left_last.right;
            TreeNode right_first = right_last.right;
            left_last.right = root;
            root.left = left_last;
            root.right = right_last.right;
            right_first.left = root;
            right_last.right = left_first;
            left_first.left = right_last;
            return right_last;
        }
    }


}