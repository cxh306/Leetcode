package origin;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution179{
    public String largestNumber(int[] nums) {
        String[] numString=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numString[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(numString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                int len=s1.length();
                for (int i = 0; i < len; i++) {
                    if(s1.charAt(i)==s2.charAt(i)) continue;
                    return s2.charAt(i)-s1.charAt(i);
                }
                return 0;
            }
        });
        if("0".equals(numString[0])) return "0";
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < numString.length; i++) {
            stringBuilder.append(numString[i]);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        int[] a=new int[]{0,0};
        System.out.println(largestNumber(a));
    }

}
