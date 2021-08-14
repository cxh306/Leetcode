package Offer;

import util.ListNode;

public class Offer_24{
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now =head;
        while(now!=null){
            ListNode after = now.next;
            now.next=pre;
            pre =now;
            now = after;
        }
        return pre;
    }
}
