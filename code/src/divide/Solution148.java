package divide;

import util.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    public ListNode sortList(ListNode head,ListNode tail){
        if(head==null) return null;
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=tail){
            fast=fast.next;
            slow=slow.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        ListNode mid=slow;
        ListNode left=sortList(head,mid);
        ListNode right=sortList(mid,tail);
        return merge(left,right);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummyhead=new ListNode();
        ListNode pre=dummyhead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pre=pre.next=l1;
                l1=l1.next;
            }else{
                pre=pre.next=l2;
                l2=l2.next;
            }
        }
        if(l1!=null){
            pre.next=l1;
        }else{
            pre.next=l2;
        }
        return dummyhead.next;
    }
}
