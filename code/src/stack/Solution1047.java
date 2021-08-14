package stack;

import org.junit.Test;

public class Solution1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length();i++) {
            if(sb.length()==0||s.charAt(i)!=sb.charAt(sb.length()-1)){
                sb.append(s.charAt(i));
            }
            else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String s="aaaaaaaaa";
        System.out.println(removeDuplicates(s));
    }
}
