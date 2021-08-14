package HashTable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public StringBuilder word=new StringBuilder();
    List<String> ans = new ArrayList<>();
    String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        dfs(digits.toCharArray(),0);
        return ans;
    }

    public void dfs(char[] digits,int i){
        if(digits.length==0) return;
        if(i==digits.length){
            ans.add(word.toString());
            return;
        }
        for(int j=0;j<map[digits[i]-'0'-2].length();j++){
            word.append(map[digits[i]-'0'-2].charAt(j));
            dfs(digits,i+1);
            word.deleteCharAt(i);
        }
    }

}
