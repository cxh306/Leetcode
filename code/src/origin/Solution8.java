package origin;

import org.junit.Test;

public class Solution8 {
    public int myAtoi(String s) {
        if("".equals(s)) return 0;
        int start=0;
        while (s.charAt(start)==' '){
            start++;
        };
        if(start>=s.length()) return 0;
        int sign=1;
        if(s.charAt(start)=='-'||s.charAt(start)=='+'){
            if(s.charAt(start)=='-') sign=-1;
            start++;
        }
        while (s.charAt(start)=='0') start++;
        int num=0,end=start;
        final int c=214748364;
        while (end<s.length()&&end-start<=9&&Character.isDigit(s.charAt(end))){
            if(end-start==9){
                if(num<c||num==c&&s.charAt(end)<='7') num=num*10+(s.charAt(end)-'0');
                else return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }else {
                num=num*10+(s.charAt(end)-'0');
            }
            end++;
        }
        if(end>=s.length()||!Character.isDigit(s.charAt(end))) return sign*num;
        else return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
    }

    @Test
    public void test(){
        System.out.println(myAtoi("  -42"));
    }
}
