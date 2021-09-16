package Divide;

import org.junit.Test;

import java.beans.Transient;
import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!countMap.containsKey(nums[i])){
                countMap.put(nums[i],1);
            }else{
                countMap.put(nums[i],countMap.get(nums[i])+1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> objects = new PriorityQueue<>(k,
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getValue()-o2.getValue();
                    }
                });
        Set<Map.Entry<Integer,Integer>> objs = countMap.entrySet();
        for (Map.Entry<Integer,Integer> obj : objs) {
            if(objects.size()<k){
                objects.offer(obj);
            }else{
                if(objects.peek().getValue()<obj.getValue()) {
                    objects.remove();
                    objects.offer(obj);
                }
            }
        }
        int[] ans = new int[k];
        for (Map.Entry<Integer, Integer> object : objects) {
            ans[--k]=object.getKey();
        }
        return ans;
    }

    @Test
    public void test(){
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i = 0; i < 2; i++) {
            System.out.println(ints[i]);
        }
    }
}
