package Divide;

import org.junit.Test;
import util.ListNode;

import java.util.*;

public class Solution23 {
    /**
     * 分治
     */
    ListNode dummy=new ListNode();
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeDivide(lists,0,lists.length);
    }

    public ListNode mergeDivide(ListNode[] list,int i,int j){
        if(i<0||j>list.length||i==j) return null;
        if(i+1==j) return list[i];
        int mid=(i+j)/2;
        return mergeTwoList(mergeDivide(list,i,mid),mergeDivide(list,mid,j));
    }
    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode pre=dummy;
        while (l1!=null&&l2!=null){
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
        ListNode ans=dummy.next;
        dummy.next=null;
        return ans;
    }

    /**
     * 优先队列
     * @param
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        Queue<ListNode> q=new PriorityQueue<>(10, (o1, o2) -> o1.val-o2.val);
//        for (ListNode list : lists) {
//            if(list!=null) {
//                q.add(list);
//            }
//        }
//        ListNode dummy=new ListNode();
//        ListNode pre=dummy;
//        while (!q.isEmpty()){
//            pre=pre.next=q.remove();
//            if(pre.next!=null){
//                q.add(pre.next);
//            }
//        }
//        return dummy.next;
//    }

    @Test
    public void test(){
//        ListNodeFactory.createListNode(new int[]{1,4,5});
//        ListNodeFactory.createListNode(new int[]{1,3,4});
//        ListNodeFactory.createListNode(new int[]{2,6});
//        List<ListNode> listNodeArr = ListNodeFactory.getListNodeArr();
//        System.out.println(mergeKLists(listNodeArr.toArray(new ListNode[listNodeArr.size()])));

        Queue<ListNode> q=new PriorityQueue<>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        q.add(new ListNode(1));
        q.add(new ListNode(2));
        q.add(new ListNode(3));
        System.out.println(q.peek());
        System.out.println(q.poll());

    }
}
