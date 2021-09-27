package Hot100;

import java.util.HashMap;
import java.util.Map;


//双向链表+哈希表
//LinkedHashMap内部原理
public class Solution146 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(){
        }
        DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private Map<Integer,DLinkedNode> map;
    private DLinkedNode head;
    private DLinkedNode tail;
    private int size;
    private int capacity;
    public Solution146(int capacity) {
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }

    public int get(int key) {
        DLinkedNode node=map.get(key);
        if(node==null) return -1;
        else{
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node==null){
            node=new DLinkedNode(key,value);
            map.put(key,node);
            addToHead(node);
            if(size>capacity){
                removeLastNode();
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
    }

    private void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    private void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        map.put(node.key,node);
        size++;
    }

    private void removeLastNode(){
        int key= tail.prev.key;
        removeNode(tail.prev);
        map.remove(key);
        size--;
    }
}
