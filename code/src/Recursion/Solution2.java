package Recursion;

import util.ListNode;

public class Solution2 {
    int jin=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return jin==1?new ListNode(1):null;
        int l1val=l1==null?0:l1.val;
        int l2val=l2==null?0:l2.val;
        int sum=l1val + l2val + jin;
        ListNode listNode = new ListNode(sum%10);
        jin=sum>=10?1:0;
        listNode.next=addTwoNumbers(l1==null?null:l1.next,l2==null?null:l2.next);
        return listNode;
    }

}
