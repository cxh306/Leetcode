package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    int left,right;
    StringBuilder sb=new StringBuilder();
    List<String> ans=new ArrayList<>();
    int len;
    public List<String> generateParenthesis(int n) {
        left=n;
        right=n;
        len=n;
        dfs(0);
        return ans;
    }

    public void dfs(int i){
        if(i==2*len){
            ans.add(sb.toString());
            return;
        }
        if(left>0) {
            left--;
            sb.append('(');
            dfs(i + 1);
            sb.deleteCharAt(sb.length() - 1);
            left++;
        }
        if(left<right){
            if(right>0) {
                right--;
                sb.append(')');
                dfs(i + 1);
                sb.deleteCharAt(sb.length() - 1);
                right++;
            }
        }
    }

    @Test
    public void test(){
        long l=System.currentTimeMillis();
        generateParenthesis(15);
        System.out.println(System.currentTimeMillis()-l);
    }
}
