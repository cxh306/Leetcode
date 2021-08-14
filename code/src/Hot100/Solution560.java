package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
//        int[] sum=new int[nums.length+1];
//        Map<Integer, List<Integer>> map=new HashMap<>();
//        for (int i = 0; i < sum.length; i++) {
//            if(i==0){
//                map.put(0,new ArrayList());
//                continue;
//            }
//            sum[i]=sum[i-1]+nums[i-1];
//            if(map.containsKey(sum[i])){
//                map.get(sum[i]).add(i);
//            }else{
//                List temp=new ArrayList<>();
//                temp.add(i);
//                map.put(sum[i],temp);
//            }
//        }
//        int cnt=0;
//        for (int i = 0; i < sum.length; i++) {
//            if(map.containsKey(k+sum[i])){
//                List<Integer> integers = map.get(k + sum[i]);
//                int j=0;
//                while(j<integers.size()&&integers.get(j)<=i) j++;
//                cnt+=integers.size()-j;
//            }
//        }
//        return cnt;

        /**
         * sum[i]=sum[i-1]+nums[i];
         * sum[i]-sum[j-1]=k ([j...i])
         * 前缀和和哈希表
         */
        int pre=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);//边界条件
        int ans=0;
        for (int i = 0; i < nums.length; i++) {

            //访问nums[i]时得到的前缀和
            pre+=nums[i];

            //查看pre-k是否存在map中，其value就是以nums[i]为结尾的和为k的连续子数组个数
            if(map.containsKey(pre-k)){
                ans+=map.get(pre-k);
            }

            //将此前缀和记录在map中
            if(map.containsKey(pre)){
                map.put(pre,map.get(pre)+1);
            }else{
                map.put(pre,1);
            }
        }
        return ans;
    }
}
