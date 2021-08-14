package stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> l=new LinkedList<>();
        int[] ans=new int[nums.length];
        Arrays.fill(ans,-1);
        for (int i = 0; i < 2*nums.length; i++) {
            while(!l.isEmpty()&&nums[l.peek()]<nums[i%nums.length]){
                ans[l.pop()]=nums[i%nums.length];
            }
            if(i<nums.length){
                l.push(i);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] te={1,2,3,2,1};
        int[] ints = nextGreaterElements(te);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
