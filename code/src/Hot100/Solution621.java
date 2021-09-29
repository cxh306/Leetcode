package Hot100;

import java.util.*;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        //计算各种任务的个数
        int[] map=new int[26];
        for (char task : tasks) {
            map[task-'A']++;
        }

        //数量越多的任务越优先被执行
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < map.length; i++) {
            if(map[i]>0) priorityQueue.offer(map[i]);
        }

        //缓存数组
        Deque<Integer> deque=new ArrayDeque<>();
        int time=0;

        //优先队列非空时
        while (!priorityQueue.isEmpty()) {
            //贪心:数量最多的任务能不等待执行时优先执行
            //一轮任务的数量
            int len=Math.min(n+1,priorityQueue.size());

            for (int i = 0; i < len; i++) {
                Integer poll = priorityQueue.poll();
                poll=poll-1;

                //变化的任务数压入缓存数组
                if(poll>0) deque.add(poll);
                time++;
            }

            //把变化的任务数压入优先队列
            while (!deque.isEmpty()){
                priorityQueue.offer(deque.poll());
            }

            //当优先队列非空时,计算需要等待的时间
            if(!priorityQueue.isEmpty()) time+=Math.max(n-len+1,0);
        }
        return time;
    }
}
