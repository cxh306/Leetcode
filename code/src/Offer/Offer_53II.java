package Offer;

public class Offer_53II {
    public int missingNumber(int[] nums) {
        int beg=0,end=nums.length;
        while(beg<end){
            int mid=beg+((end-beg)>>1);
            if(nums[mid]==mid){
                beg=mid+1;
            }else{
                end=mid;
            }
        }
        return beg;
    }
}
