package Recursion;

import util.ListNode;

public class Solution21 {
    ListNode head=new ListNode(Integer.MIN_VALUE);
    ListNode pre=head;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1==null) pre.next=l2;
//        else if(l2==null) pre.next=l1;
//        else {
//            if (l1.val <= l2.val) {
//                pre = pre.next = l1;
//                mergeTwoLists(l1.next, l2);
//            } else {
//                pre = pre.next = l2;
//                mergeTwoLists(l1, l2.next);
//            }
//        }
//        return head.next;
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val>=l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }else{
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }

    }
}
