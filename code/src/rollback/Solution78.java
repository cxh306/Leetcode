package rollback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution78 {
    Deque<Integer> temp=new ArrayDeque<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        dfs(nums,0);
        return ans;
    }
    public void dfs(int[] nums,int i){
        for (int j = i; j < nums.length; j++) {
            temp.addLast(nums[j]);
            ans.add(new ArrayList<>(temp));
            dfs(nums,j+1);
            temp.removeLast();
        }
    }
}
