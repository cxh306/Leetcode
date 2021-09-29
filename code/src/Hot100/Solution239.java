package Hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
    /**
     * O(1)时间找到最大值的队列
     * @param nums
     * @param k
     * @return
     */
//    class MaxQueue extends ArrayDeque<Integer>{
//        Deque<Integer> incrStack=new ArrayDeque<>();
//
//        @Override
//        public Integer removeFirst() {
//            Integer integer = super.removeFirst();
//            if (!incrStack.isEmpty()&&integer==incrStack.getFirst()) incrStack.removeFirst();
//            return integer;
//        }
//
//        @Override
//        public void addLast(Integer integer) {
//            super.addLast(integer);
//            while (!incrStack.isEmpty()&&integer>incrStack.getLast()){
//                incrStack.removeLast();
//            }
//            incrStack.addLast(integer);
//        }
//
//        public int getMaxValue(){
//            if(!incrStack.isEmpty()) return incrStack.getFirst();
//            else  return Integer.MIN_VALUE;
//        }
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxQueue=new ArrayDeque<>();
        int[] maxValue=new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!maxQueue.isEmpty()&&nums[i]>maxQueue.getLast()){
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[i]);
            if(i>=k&&maxQueue.getFirst()==nums[i-k]){
                maxQueue.removeFirst();
            }
            if(i>=k-1){
                maxValue[i-k]=maxQueue.getFirst();
            }
        }
        return maxValue;
    }
}
