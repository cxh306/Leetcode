package Offer;

import java.util.LinkedList;

public class Offer_30 {
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        int v1=m.min();
        int v2=m.top();
        m.pop();
        int v3=m.min();
    }

}
class MinStack {
    LinkedList<Integer> l;
    //维护一个单调栈
    LinkedList<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
        l=new LinkedList<>();
        helper=new LinkedList<>();
    }

    public void push(int x) {
        l.addLast(x);
        if(helper.size()==0||x<=helper.getLast()){
            helper.addLast(x);
        }
    }

    public void pop() {
        if(top()==helper.getLast()){
            helper.removeLast();
        }
        l.removeLast();
    }

    public int top() {
        return l.getLast();
    }

    public int min() {
        return helper.getLast();
    }
}
