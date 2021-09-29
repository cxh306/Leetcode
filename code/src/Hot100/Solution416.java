package Hot100;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

//        boolean[][] dp = new boolean[n][target + 1];
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = true;
//        }
//        dp[0][nums[0]] = true;
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= target; j++) {
//                if (j >= nums[i]) dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
//                else dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[n - 1][target];

        //优化空间，实际上也优化了时间
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
