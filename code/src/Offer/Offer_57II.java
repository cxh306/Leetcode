package Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer_57II {
    //返回int[][]比较恶心
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int l=1,r=2;
        while(l<r){
            int sum=(l+r)*(r-l+1)/2;
            if(sum<target){
                r++;
            }else if(sum>target){
                l++;
            }else{
                int[] mm=new int[r-l+1];
                for(int i=l;i<=r;i++){
                    mm[i-l]=i;
                }
                ans.add(mm);
                r++;
                l++;
            }
        }
        //通过toArray方法将List转化为array
        //注意，这里要一个个数为ans.size()的数组对象，数组的元素类型为数组
//        List<Object> pp = new ArrayList<>();
//        pp.toArray(new Object[pp.size()]);
        return ans.toArray(new int[ans.size()][]);
    }
}
