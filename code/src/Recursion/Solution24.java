package Recursion;

import org.junit.Test;
import util.ListNode;
import util.linkedlist;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode temp=head.next;
        head.next=swapPairs(temp.next);
        temp.next=head;
        return temp;
    }

    @Test
    public void test(){
        ListNode head=new linkedlist().createLinkedList(new int[]{1,2,3,4});
        System.out.println(swapPairs(head));
    }
}
