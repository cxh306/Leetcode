package DP;

import java.util.Arrays;

public class Solution5 {
    public String longestPalindrome(String s) {
        int[] idx = new int[2];
        int len=s.length();
        boolean[][] flag=new boolean[len][len];
        for (int i=0;i<len;i++){
            Arrays.fill(flag[i],true);
        }

        for (int i=len-1;i>=0;i--){
            for (int j=i+1;j<len;j++){
                flag[i][j]=flag[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                if(flag[i][j] && (j-i > idx[1]-idx[0])){
                    idx[0]=i;
                    idx[1]=j;
                }
            }
        }
        return s.substring(idx[0],idx[1]+1);
    }
}
