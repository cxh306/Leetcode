package rollback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution216 {
    List<List<Integer>> ans;
    Deque<Integer> temp=new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1);
        return ans;
    }

    public void dfs(int k,int n,int num){
        if(k==0&&n==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(k<=0||n<=0) return;
        for(int i=num;i<=9;i++){
            temp.addLast(i);
            dfs(k-1,n-i,num+1);
            temp.removeLast();
        }
    }
}
