package rollback;

import org.junit.Test;

import java.util.*;

public class Solution47 {
    List<List<Integer>> ans=new ArrayList<>();
    Deque<Integer> temp=new ArrayDeque<>();
    List<int[]> freq = new ArrayList<int[]>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        for (int num : nums) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(nums.length);
        return ans;
    }

    public void dfs(int length){
        if(length==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int[] o : freq) {
            int len=o[1];
            for (int i = 1; i <= o[1]; i++) {
                temp.addLast(o[0]);
                o[1]--;
                dfs(length-1);
            }
            for (int i = 1; i <= len; i++) {
                temp.removeLast();
                o[1]++;
            }

        }
    }

//    boolean[] vis;
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> perm = new ArrayList<Integer>();
//        vis = new boolean[nums.length];
//        Arrays.sort(nums);
//        backtrack(nums, ans, 0, perm);
//        return ans;
//    }
//
//    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
//        if (idx == nums.length) {
//            ans.add(new ArrayList<Integer>(perm));
//            return;
//        }
//        for (int i = 0; i < nums.length; ++i) {
//            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
//                continue;
//            }
//            perm.add(nums[i]);
//            vis[i] = true;
//            backtrack(nums, ans, idx + 1, perm);
//            vis[i] = false;
//            perm.remove(idx);
//        }
//    }

    @Test
    public void test(){
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
