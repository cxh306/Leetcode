package stack;

import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution143 {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack =new LinkedList<>();
        ListNode temp=head;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        ListNode pre=head;

    }
}
