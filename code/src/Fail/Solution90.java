package Fail;

import org.junit.Test;

import java.util.*;

public class Solution90 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }




//    Deque<Integer> temp = new ArrayDeque<>();
//    List<List<Integer>> ans = new ArrayList<>();
//    int len;
//    List<int[]> arr = new ArrayList<>();
//
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        len = nums.length;
//        Arrays.sort(nums);
//        for (int i = 0; i < len; i++) {
//            if (i == 0 || arr.get(arr.size() - 1)[0] != nums[i]) {
//                arr.add(new int[]{nums[i], 1});
//            } else {
//                arr.get(arr.size() - 1)[1]++;
//            }
//        }
//        ans.add(new ArrayList<>());
//        dfs(nums, 0, 0);
//        return ans;
//    }
//
//    public void dfs(int[] nums, int i, int p) {
//        if (i == len) return;
//        for (int j = p; j < arr.size(); j++) {
//            if(arr.get(j)[1]>0) {
//                temp.addLast(arr.get(j)[0]);
//                ans.add(new ArrayList<>(temp));
//                arr.get(j)[1]--;
//                dfs(nums, i + 1, j);
//                temp.removeLast();
//                arr.get(j)[1]++;
//            }
//        }
//    }



    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
