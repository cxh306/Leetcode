package cracking_the_coding_interview;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private Deque<Integer> xStack;
    //minStack中元素与xStack相应位置元素的最小值一一对应
    private Deque<Integer> minStack;
    public MinStack() {
        xStack=new LinkedList<>();
        minStack=new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        //当x入栈后则最小值为min(x,minStack.peek()),加入最小栈
        minStack.push(Math.min(x,minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        //xStack栈顶元素出栈,则之对应的minStack的栈顶元素也要出栈
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
