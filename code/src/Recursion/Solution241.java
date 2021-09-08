package Recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans=new ArrayList<>();
        int len = expression.length();
        int start = 0;
        for (start = 0; start < len; start++) {
            if(Character.isDigit(expression.charAt(start))) continue;
            else break;
        }
        if(start==len) ans.add(Integer.parseInt(expression));
        for(int i=start;i<len;i++){
            if(Character.isDigit(expression.charAt(i))) continue;
            char op = expression.charAt(i);
            List<Integer> left=diffWaysToCompute(expression.substring(0,i));
            List<Integer> right=diffWaysToCompute(expression.substring(i+1,expression.length()));
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    switch (op){
                        case '+':ans.add(left.get(j)+right.get(k));break;
                        case '-':ans.add(left.get(j)-right.get(k));break;
                        case '*':ans.add(left.get(j)*right.get(k));break;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(diffWaysToCompute("2*3-4*5+7*9-10"));
    }
}