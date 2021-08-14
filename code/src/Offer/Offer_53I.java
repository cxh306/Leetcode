package Offer;

public class Offer_53I {
    public int search(int[] nums, int target) {
        int cnt=0;
        int beg=0,end=nums.length;
        while(beg<end){
            int mid = beg+((end-beg)>>1);
            if(nums[mid]<target){
                beg=mid+1;
            }else if(nums[mid]>target){
                end=mid;
            }else{
                //当找到了target，往前往后记录出现个数即可
                int i=mid;
                while(i>=0&&nums[i]==target){
                    cnt++;
                    i--;
                }
                i=mid+1;
                while(i<nums.length&&nums[i]==target){
                    cnt++;
                    i++;
                }
                break;
            }
        }
        return cnt;
    }
}
