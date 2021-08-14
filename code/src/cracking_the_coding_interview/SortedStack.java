package cracking_the_coding_interview;

import java.util.Deque;
import java.util.LinkedList;

public class SortedStack {
    private Deque<Integer> s;
    private Deque<Integer> temp;
    public SortedStack() {
        s=new LinkedList();
        temp=new LinkedList();
    }

    public void push(int val) {
        while(!s.isEmpty()&&s.peek()<val){
            temp.push(s.pop());
        }
        s.push(val);
        while (!temp.isEmpty()){
            s.push(temp.pop());
        }
    }

    public void pop() {
        if(!s.isEmpty()) s.pop();
    }

    public int peek() {
        return s.isEmpty()?-1:s.peek();
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }
}
