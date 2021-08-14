package HashTable;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution138 {
    Map<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        Node temp=head;
        while (temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        map.put(null,null);
        temp=head;
        while (temp!=null){
            map.get(temp).random=map.get(temp.random);
            map.get(temp).next=map.get(temp.next);
            temp=temp.next;
        }
        System.out.println(1);
        return map.get(head);
    }
}
