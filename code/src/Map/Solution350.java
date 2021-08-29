package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> l=new ArrayList<>();
        if(nums1.length>nums2.length) return intersect(nums2,nums1);
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])){
                l.add(nums2[i]);
                int value=map.get(nums2[i]);
                if(value-1>0){
                    map.put(nums2[i],value-1);
                }
                else{
                    map.remove(nums2[i]);
                }
            }
        }
        int ans[] =new int[l.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=l.get(i);
        }
        return ans;
    }
}
