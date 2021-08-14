package HashTable;

import org.junit.Test;

import java.util.*;

public class Solution128 {
    /**
     * TreeSet
     * 37ms
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set =new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans=0;
        int len=0;
        Integer pre=null;
        for (Integer integer : set) {
            if(pre==null){
                len=1;
                ans=1;
            }
            else{
                if(integer-1==pre){
                    len++;
                    ans=Math.max(ans,len);
                }else{
                    len=1;
                }
            }
            pre=integer;
        }
        return ans;
    }

    /**
     * HashSet
     * 13ms
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {

        int ans=0;

        //建立HashSet
        Set<Integer> set =new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (Integer integer : set) {
            //set中没有当前元素-1的元素,说明这个元素是连续序列的头元素
            if(!set.contains(integer-1)){
                int currentNum=integer;
                int currentLen=1;
                while (set.contains(currentNum+1)){
                    currentNum++;
                    currentLen++;
                }
                ans=Math.max(ans,currentLen);
            }
            //否则不是头元素，跳过
        }
        return ans;
    }
}
