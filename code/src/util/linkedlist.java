package util;

public class linkedlist {
    ListNode head=new ListNode();
    ListNode pre=head;
    public ListNode createLinkedList(int[] list){
        if (list == null || list.length == 0) return null;
        for (int i = 0; i < list.length; i++) {
            pre = pre.next = new ListNode(list[i]);
        }
        return head.next;
    }
}
