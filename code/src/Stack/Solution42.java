package Stack;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 动态规划
 */
public class Solution42 {

    public int trap(int[] height) {
        int[] max_left=new int[height.length+1];
        int[] max_right=new int[height.length+1];

        for (int i = 0; i < height.length; i++) {
            if(i==0) max_left[i]=height[i];
            else max_left[i]=Math.max(max_left[i-1],height[i]);
        }
        for (int i = height.length-1; i >= 0; i--) {
            if(i==height.length-1) max_right[i]=height[i];
            else max_right[i]=Math.max(max_right[i+1],height[i]);
        }

        int ans=0;
        for (int i = 0; i < height.length; i++) {
            ans+=Math.max(max_left[i],max_right[i])-height[i];
        }
        return ans;
    }
}
