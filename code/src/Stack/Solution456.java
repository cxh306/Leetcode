package Stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new LinkedList<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!d.isEmpty() && d.peek() < nums[i]) {
                // 事实上，k 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                k = d.pop();
            }
            d.push(nums[i]);
        }
        return false;
    }

    @Test
    public void test(){
        int[] num = {1,3,2,4,5,6,7,8,9,10};
        System.out.println(find132pattern(num));
    }
}
