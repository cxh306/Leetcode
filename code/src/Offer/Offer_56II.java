package Offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Offer_56II {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if(integer==null) map.put(nums[i],1);
            else{
                if(integer==2) map.remove(nums[i]);
                else {
                    map.put(nums[i],integer+1);
                }
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        return iterator.next();
    }
}
