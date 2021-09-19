package QuickFind;

public class OfferII076 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }
    public int quickSort(int[] nums,int beg,int end,int k){
        if(beg>end) return Integer.MIN_VALUE;
        int value=nums[beg];
        int i=beg,j=end;
        while (i<j){
            while(i<j&&nums[j]>=value) j--;
            if(i<j) nums[i]=nums[j];
            while (i<j&&nums[i]<=value) i++;
            if(i<j) nums[j]=nums[i];
        }
        nums[i]=value;
        if(i<k) return quickSort(nums,i+1,end,k);
        else if(i>k) return quickSort(nums,beg,i-1,k);
        else return nums[i];
    }
}
