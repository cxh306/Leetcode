package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution131 {
    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    boolean[][] dp;
    int n;
    public List<List<String>> partition(String s) {
        n=s.length();
        dp = new boolean[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],true);
        }

        for (int i=n-1;i>=0;i--){
            for (int j=i+1;j<n;j++){
                dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
            }
        }
        dfs(s,0);
        return ans;
    }

    public void dfs(String s,int i){
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j=i;j<n;j++){
            if(dp[i][j]){
                temp.add(s.substring(i,j+1));
                dfs(s,j+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    @Test
    public void test(){
        List<List<String>> aab = partition("aab");
        System.out.println(aab);
    }
}
