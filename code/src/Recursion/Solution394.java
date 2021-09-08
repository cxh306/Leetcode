package Recursion;

import org.junit.Test;

public class Solution394 {
    public String decodeString(String s) {
        Integer num=0;
        Integer left=null;
        int len=s.length();
        StringBuffer sb=new StringBuffer();
        int count=0;
        for (int i = 0; i < len; i++) {
            char ch=s.charAt(i);
            if(Character.isLetter(ch)){
                if(left==null) sb.append(ch);//'['没遇到
            }
            else if(Character.isDigit(ch)){
                if(left==null) num=num*10+ch-'0';//'['没遇到
            }else if(s.charAt(i)=='['){
                count++;
                if(left==null) left=i;//记下第一次遇到的'['
            }else{
                count--;
                if(count==0){
                    String sub=decodeString(s.substring(left+1,i));
                    for (int j = 0; j < num; j++) {
                        sb.append(sub);
                    }
                    left=null;
                    num=0;
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
