package Hot100;

public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        /**
         * 寻找右边界
         * 当访问第i个元素时,假设[0,i)已经是升序数组,
         * 1.nums[i]<big,说明这个元素与最大值呈降序,右边界更新
         * 2.nums[i]>=big,当前这个元素不需要被排序,big更新
         */
        int right=0;
        int big=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<big){
                right=i;
            }else{
                big=nums[i];
            }
        }
        /**
         * 寻找左边界,从右往左找
         * 当访问第i个元素时,假设(i,nums.length-1]已经是升序数组,
         * 1.nums[i]>small,说明这个元素与最小值呈降序,左边界更新
         * 2.nums[i]<=small,当前这个元素不需要被排序,big更新
         */
        int left=nums.length-1;
        int small=nums[left];
        for (int i = nums.length-1; i >=0; i--) {
            if(nums[i]>small){
                left=i;
            }else{
                small=nums[i];
            }
        }
        //当右边界比左边界大,即为[left,right]范围内的元素升序排序后整个数组就是升序数组
        // 否则此时整个数组为升序数组
        return right>left?right-left+1:0;
    }
}
