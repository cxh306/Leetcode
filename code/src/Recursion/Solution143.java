package Recursion;

import org.junit.Test;
import util.ListNode;
import util.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Solution143 {
    ListNode dumy=new ListNode();
    ListNode pre=dumy;
    public void reorderList(ListNode head) {
        List<ListNode> l=new ArrayList<>();
        ListNode now=head;
        while (now!=null){
            l.add(now);
            now=now.next;
        }
        helper(0,l.size()-1,l);
    }

    public void helper(int i,int j,List<ListNode> l){
        if(i==j){
            pre.next=l.get(i);
            l.get(i).next=null;
            return;
        }
        if(i>j) return;
        pre.next=l.get(i);
        pre=l.get(i).next=l.get(j);
        pre.next=null;
        helper(i+1,j-1,l);
    }

    @Test
    public void test(){
        ListNode linkedList = new linkedlist().createLinkedList(new int[]{1, 2, 3, 4});
        reorderList(linkedList);
    }
}
