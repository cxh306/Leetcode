package util;

 public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public  ListNode(int val) { this.val = val; }
     public  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     @Override
     public String toString() {
         ListNode now=this;
         StringBuilder sb=new StringBuilder("[");
         while(now!=null){
             sb.append(now.val+",");
             now=now.next;
         }
         sb.deleteCharAt(sb.length()-1);
         sb.append(']');
         return sb.toString();
     }
 }
