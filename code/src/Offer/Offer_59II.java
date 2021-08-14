package Offer;

import java.util.LinkedList;

public class Offer_59II {
}

/**
 * 单调递减队列
 * 1.每次push元素后,所有比push元素小的队列内元素不再对结果有影响(因为pop掉此较小元素最大值不变,而比这个值大的元素要保留,因为pop掉可能会改变最大值)
 *      则每push一个元素之前,都有一个单调不增的序列,这个序列以队列尾元素为最小值,则push这个元素之后，也要维护这个单调递减的序列,使之以新加入的元素
 *      为最小值
 * 2.每次pop元素时,要判断与单调队列头元素是否相等
 *
 *
 */
class MaxQueue {
    LinkedList<Integer> q;
    LinkedList<Integer> d;
    public MaxQueue() {
        q=new LinkedList<>();
        d=new LinkedList<>();
    }

    public int max_value() {
        return d.isEmpty()?-1:d.getFirst();
    }

    public void push_back(int value) {
        q.addLast(value);
        while(!d.isEmpty()&&value>d.getLast()){
            d.removeLast();
        }
        d.addLast(value);
    }

    public int pop_front() {
        int t=-1;
        if(!q.isEmpty()){
            t=q.removeFirst();
            if(t==d.getFirst()){
                d.removeFirst();
            }
        }
        return t;
    }
}