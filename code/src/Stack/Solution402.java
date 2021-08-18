package Stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution402 {
    public String removeKdigits(String num, int k) {
        int len=num.length();
        StringBuilder l = new StringBuilder();
        for (int i=0;i<len;i++){
            while (k>0&&l.length()!=0&&l.charAt(l.length()-1)>num.charAt(i)){
                l.deleteCharAt(l.length()-1);
                k--;
            }
            if(l.length()>0||num.charAt(i)!='0') l.append(num.charAt(i));
        }
        while (k>0&&l.length()>0){
            l.deleteCharAt(l.length()-1);
            k--;
        }
        if(l.length()==0) return "0";
        else return l.toString();
    }

    @Test
    public void test(){
        System.out.println(removeKdigits("112",1));
    }
}
