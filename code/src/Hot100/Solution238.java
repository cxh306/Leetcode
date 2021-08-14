package Hot100;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] dp_left=new int[nums.length];
        int[] dp_right=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                dp_left[0]=1;
                dp_right[0]=1;
            }else{
                dp_left[i]=dp_left[i-1]*nums[i-1];
                dp_right[i]=dp_right[i-1]*nums[nums.length-i-1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            dp_left[i]=dp_left[i]*dp_right[nums.length-1-i];
        }
        return dp_left;
    }
}
