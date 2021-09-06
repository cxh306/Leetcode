package rollback;

import org.junit.Test;

import java.util.*;

public class Solution90 {

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

    boolean[] flag;
    Deque<Integer> temp=new ArrayDeque<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        flag=new boolean[nums.length];
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        dfs(nums,0);
        return ans;
    }

    public void dfs(int[] nums,int i){
        for(int j=i;j<nums.length;j++){
            if(j>0&&nums[j-1]==nums[j]&&!flag[j-1]) continue;
            temp.addLast(nums[j]);
            ans.add(new ArrayList<>(temp));
            flag[j]=true;
            dfs(nums,j+1);
            flag[j]=false;
            temp.removeLast();
        }
    }

    @Test
    public void test() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
