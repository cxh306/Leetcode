package stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("*")||tokens[i].equals("/")||tokens[i].equals("+")||tokens[i].equals("-")){
                switch (tokens[i]){
                    case "*":stack.push(stack.pop()*stack.pop());break;
                    case "/":{
                        int second=stack.pop();
                        stack.push(stack.pop()/second);
                        break;
                    }
                    case "+":stack.push(stack.pop()+stack.pop());break;
                    case "-":stack.push(-stack.pop()+stack.pop());break;
                    default:break;
                }
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
