package Recursion;

import org.junit.Test;
import util.ListNode;

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
    }
}
