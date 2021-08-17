package HashTable;

import org.junit.Test;

import java.util.*;

//最小堆
public class Solution264 {
    public int nthUglyNumber(int n) {
        Set<Long> set=new HashSet<>();
        PriorityQueue<Long> pq=new PriorityQueue<>();
        pq.add(1L);
        long minNum = 1;
        while (n>0){
            minNum=pq.poll();
            n--;
            if(!set.contains(minNum*2)) {
                pq.add(minNum*2);
                set.add(minNum*2);
            }
            if(!set.contains(minNum*3)) {
                pq.add(minNum*3);
                set.add(minNum*3);
            }
            if(!set.contains(minNum*5)) {
                pq.add(minNum*5);
                set.add(minNum*5);
            }
        }
        return (int)minNum;
    }

    @Test
    public void test(){
        nthUglyNumber(10);
    }
}
