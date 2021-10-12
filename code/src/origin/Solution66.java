package origin;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int jin=0;
        int i=digits.length-1;
        if(digits[i]<9){
            digits[i]=0;
            jin=1;
            i--;
        }
        while (i>=0&&jin>0){
            digits[i]+=jin;
            if(digits[i]<9) jin=0;
            else digits[i]=0;
            i--;
        }
        int[] ans;
        if(i<0){
            ans = new int[digits.length + 1];
            ans[0]=1;
            for (int j = 1; j < ans.length; j++) {
                ans[j]=digits[j-1];
            }
        }else {
            ans=digits;
        }
        return ans;
    }
}
