package DFS;


import util.Node;
import util.TreeNode;

import java.util.ArrayList;

public class Solution117 {
    /**
     * T(n)=O(n)
     * S(n)=O(1)
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Node cur = root;
        //每层的头节点
        Node dumpy = new Node();
        Node pre = dumpy;
        while (cur != null) {
            if (cur.left != null) {
                pre = pre.next = cur.left;
            }
            if (cur.right != null) {
                pre = pre.next = cur.right;
            }
            cur = cur.next;

            //cur==null，此时一层已遍历完毕
            if (cur == null) {
                //cur赋值为下一层的首节点
                cur = dumpy.next;
                //准备一下层的下一层
                dumpy.next = null;
                pre = dumpy;
            }
        }
        return root;
    }
}
