package rollback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return ans;
    }
    public void dfs(int[] candidates, int target,int i){
        if(i==candidates.length||target<0) return;
        if(target==0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i;j<candidates.length;j++){
            target-=candidates[j];
            temp.add(candidates[j]);
            dfs(candidates,target,i);
            temp.remove(temp.size()-1);
            target+=candidates[j];
        }
    }
}
