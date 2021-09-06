package rollback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution77 {
    Deque<Integer> temp=new ArrayDeque<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,0);
        return ans;
    }

    public void dfs(int n,int k,int i){
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i+1; j <= n; j++) {
            temp.addLast(j);
            dfs(n,k-1,j);
            temp.removeLast();
        }
    }
}
