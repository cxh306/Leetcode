package DP;

public class Solution91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        if(len == 0) return 0;
        if(s.charAt(0)!='0'){
            dp[0] = 1;
        }
        if(len>=2){
            if(s.charAt(0)=='0'||(s.charAt(0)>='3'&&s.charAt(1)=='0')){
                dp[1] = 0;
            }
            else if((s.charAt(0)-'0')*10+s.charAt(1)-'0'>26||s.charAt(1)=='0'){
                dp[1] = 1;
            }else{
                dp[1] = 2;
            }
        }
        for(int i=2;i<len;i++){
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='2'||s.charAt(i-1)=='1'){
                    dp[i] = dp[i-2];
                }
            }
            else{
                if(s.charAt(i-1) == '0' || (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'>26){
                    dp[i] = dp[i-1];
                }
                else{
                    dp[i] = dp[i-1]+dp[i-2];
                }
            }
        }
        return dp[len-1];

    }
}
