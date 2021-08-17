package Stack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution227 {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        char[] ss= s.toCharArray();
        int n = ss.length;
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(ss[i])) {
                num = num * 10 + ss[i] - '0';
            }
            if (!Character.isDigit(ss[i]) && ss[i] != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = ss[i];
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(calculate( "1-1+1"));
    }
}
