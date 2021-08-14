package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> q=new LinkedList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!q.isEmpty()&&q.peek()<nums2[i]){
                map.put(q.pop(),nums2[i]);
            }
            q.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i]=map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}
