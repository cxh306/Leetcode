package Hot100;

public class Solution647 {
    public int countSubstrings(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        int ret=len;
        for (int i = len-1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if(i>=j) dp[i][j]=true;
                else{
                    if(dp[i][j]=dp[i+1][j-1]&(s.charAt(i)==s.charAt(j))) ret++;
                }
            }
        }
        return ret;
    }
}
