package util;

import java.util.ArrayList;
import java.util.List;

public class ListNodeFactory {
    private static ListNode head=new ListNode();
    private static ListNode pre=head;
    private static List<ListNode> listListNode=new ArrayList<>();
    public static ListNode createListNode(int[] list){
        if (list == null || list.length == 0) return null;
        for (int i = 0; i < list.length; i++) {
            pre = pre.next = new ListNode(list[i]);
        }
        ListNode ans=head.next;
        head.next=null;
        pre=head;
        listListNode.add(ans);
        return ans;
    }

    public static List<ListNode> getListNodeArr(){
        return listListNode;
    }
}
