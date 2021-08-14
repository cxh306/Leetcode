package stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution84 {
    /**
     * 单调栈,分别从左到右，从右往左
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> q=new LinkedList<>();
        int[] ans=new int[heights.length];
        q.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while(q.peek()>=0&&heights[q.peek()]>=heights[i]){
                    q.pop();
            }
            ans[i]=heights[i]*(i-q.peek());
            q.push(i);
        }
        q.clear();
        q.push(heights.length);
        for (int i = heights.length-1; i >=0 ; i--) {
            while(q.peek()<heights.length&&heights[q.peek()]>=heights[i]){
                q.pop();
            }
            ans[i]+=heights[i]*(q.peek()-i-1);
            q.push(i);
        }
        int temp=0;
        for (int i = 0; i < ans.length; i++) {
            temp=Math.max(temp,ans[i]);
        }
        return temp;
    }

    /**
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        Deque<Integer> q=new LinkedList<>();
        int[] ans=new int[heights.length];
        //最大值
        int temp=0;
        //边界处理
        q.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while(q.peek()>=0&&heights[q.peek()]>=heights[i]){
                //每当栈中的元素将要被pop,则可以确定这个元素的右边界为当前访问元素i的前一个元素
                ans[q.peek()]+=heights[q.peek()]*(i-q.peek()-1);
                //更新最大值
                temp=Math.max(temp,ans[q.peek()]);
                q.pop();
            }
            //计算左边界到i元素的面积
            ans[i]=heights[i]*(i-q.peek());
            q.push(i);
        }
        //此时栈中的元素的右边界都为最后一个元素
        while (q.peek()>=0){
            ans[q.peek()]+=heights[q.peek()]*(heights.length-q.peek()-1);
            //更新最大值
            temp=Math.max(temp,ans[q.peek()]);
            q.pop();
        }
        return temp;
    }
    @Test
    public void test(){
        int[] arr={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}
