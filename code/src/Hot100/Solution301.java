package Hot100;

import org.junit.Test;

import java.util.*;

public class Solution301 {
    Set<String> set=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftRemove=0,rightRemove=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') leftRemove++;
            else if(s.charAt(i)==')'){
                if(leftRemove==0) rightRemove++;
                else leftRemove--;
            }
        }
        dfs(s,0,0,0,leftRemove,rightRemove,new StringBuilder());
        return new ArrayList<>(set);
    }

    private void dfs(String s,int index,int leftCount,int rightCount,int leftRemove,int rightRemove,StringBuilder path){
        if(index==s.length()){
            if(leftRemove==0&&rightRemove==0){
                set.add(path.toString());
            }
            return;
        }
        if(s.charAt(index)=='('&&leftRemove>0){
            dfs(s,index+1,leftCount,rightCount,leftRemove-1,rightRemove,path);
        }
        if(s.charAt(index)==')'&&rightRemove>0){
            dfs(s,index+1,leftCount,rightCount,leftRemove,rightRemove-1,path);
        }

        path.append(s.charAt(index));
        if(s.charAt(index)!='('&&s.charAt(index)!=')'){
            dfs(s,index+1,leftCount,rightCount,leftRemove,rightRemove,path);
        }else if(s.charAt(index)=='('){
            dfs(s,index+1,leftCount+1,rightCount,leftRemove,rightRemove,path);
        }else if(leftCount>rightCount){
            dfs(s,index+1,leftCount,rightCount+1,leftRemove,rightRemove,path);
        }
        path.deleteCharAt(path.length()-1);
    }

    @Test
    public void test(){
        String s="()())()";
        System.out.println(removeInvalidParentheses(s));
    }
}
