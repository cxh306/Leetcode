package stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution224 {
    public int calculate(String s) {
        Deque<Character> stack1=new LinkedList<>();
        Deque<Integer> stack2=new LinkedList<>();
        for (int i = 0,num = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                num=num*10+(s.charAt(i)-'0');
                if(i>=s.length()-1||!Character.isDigit(s.charAt(i+1))){
                    if(!stack1.isEmpty()&&stack1.peek()=='-') num=-num;
                    stack2.push(num);
                    num=0;
                }
            }else if(s.charAt(i)==')'){
                int temp=0;
                while (stack1.peek()!='('){
                    stack1.pop();
                    temp+=stack2.pop();
                }
                stack1.pop();
                temp+=stack2.pop();
                if(!stack1.isEmpty()&&stack1.peek()=='-') temp=-temp;
                stack2.push(temp);
            }else if(s.charAt(i)!=' '){
                stack1.push(s.charAt(i));
            }
        }
        int ans=0;
        while (!stack2.isEmpty()){
            ans+=stack2.pop();
        }
        return ans;
    }

    @Test
    public void test(){
        String s=" 2-1 + 2 ";
        System.out.println(calculate(s));
    }
}
