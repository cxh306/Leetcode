package Offer;

import java.util.Arrays;

public class Offer_45 {
    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
            //通过""+nums[i]将int转化为String效率很低
//            arr[i]=""+nums[i];
        }
        //自定义排序规则
        //定义a,b两个字符串的序: 若a+b的字典序小于b+a的字典序,则a"小于"b
        Arrays.sort(arr,(String a,String b)-> (a+b).compareTo(b+a));
        //可变字符串是StringBuilder效率最高，单线程
        //可变字符串是StringBuffer效率次于StringBuilder，多线程
        StringBuilder ans = new StringBuilder();
        for (String s:arr) {
            ans.append(s);
        }
        return ans.toString();
    }
}
