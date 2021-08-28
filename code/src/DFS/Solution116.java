package DFS;

import util.Node;

public class Solution116 {
    public Node connect(Node root) {
        if(root==null) return null;
        dfs(root.left,root.right);
        return root;
    }

    public void dfs(Node left,Node right){
        if(left==null) return;
        left.next=right;
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);
    }
}
