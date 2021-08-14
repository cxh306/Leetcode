package DFS;

import java.util.LinkedList;
import java.util.List;

public class Solution386 {
    List<Integer> ans=new LinkedList<>();
    public List<Integer> lexicalOrder(int n) {
        dfs(0,n);
        return ans;
    }
    public void dfs(int pre,int n){
        for (int i = (n==pre?1:0); i <= 9; i++) {
            if(pre*10+i<=n){
                ans.add(pre*10+i);
                dfs(pre*10+i,n);
            }else break;
        }
    }
}
