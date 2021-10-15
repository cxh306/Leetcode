package origin;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        int[] numCopy=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numCopy[i]=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i+k)%nums.length]=numCopy[i];
        }
    }
}
