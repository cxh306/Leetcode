package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution131 {
    /**
     * 深度优先搜索+动态规划预处理
     */
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

        //
        dfs(s,0);
        return ans;
    }

    //深度优先搜索+回溯
    public void dfs(String s,int i){
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j=i;j<n;j++){
            if(dp[i][j]){
                temp.add(s.substring(i,j+1));
                dfs(s,j+1);
                //回溯
                temp.remove(temp.size()-1);
            }
        }
    }

    /**
     * 深度优先搜索+记忆化搜索
     *
     */
//    List<List<String>> ans = new ArrayList<>();
//    List<String> temp = new ArrayList<>();
//    int[][] f;
//    int n;
//    public List<List<String>> partition(String s) {
//        n=s.length();
//        f=new int[n][n];
//        dfs(s,0);
//        return ans;
//    }
//    public void dfs(String s,int i){
//        if(i==n){
//            ans.add(new ArrayList<>(temp));
//            return;
//        }
//        for (int j=i;j<n;j++){
//            if(helper(s,i,j)==1){
//                temp.add(s.substring(i,j+1));
//                dfs(s,j+1);
//                temp.remove(temp.size()-1);
//            }
//        }
//    }
//
//    //记忆化搜索
//    public int helper(String s,int i,int j){
//        if(f[i][j]!=0){
//            return f[i][j];
//        }
//        if(i>=j) {
//            return f[i][j] = 1;
//        }
//        return f[i][j]=(s.charAt(i)==s.charAt(j))?helper(s,i+1,j-1):-1;
//    }

    @Test
    public void test(){
        Random r=new Random();
        int len=100;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<len;i++){
            sb.append((char)('a'+r.nextInt(26)));
        }
        String s = sb.toString();
        long l = System.currentTimeMillis();
        List<List<String>> aab = partition(s);
        System.out.println(System.currentTimeMillis()-l);
    }
}
