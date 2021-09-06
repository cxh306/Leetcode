package Fail;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution46 {
    List<List<Integer>> ans=new ArrayList<>();
    Deque temp=new ArrayDeque();
    boolean[] flag;
    public List<List<Integer>> permute(int[] nums) {
        flag=new boolean[nums.length];
        dfs(nums,0);
        return ans;
    }

    public void dfs(int[] nums,int length){
        if(length==nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(flag[j]) continue;
            temp.addLast(nums[j]);
            flag[j]=true;
            dfs(nums,length+1);
            flag[j]=false;
            temp.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}));
    }
}
