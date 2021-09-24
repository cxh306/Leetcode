package Hot100;

/**
 * 时间复杂度O(n) 空间复杂度O(1)
 * 异或运算
 * a⊕0=a  a⊕a=0  a⊕b=b⊕a
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = pre ^ nums[i];
        }
        return pre;
    }
}
