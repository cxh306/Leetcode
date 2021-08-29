package Map;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        Map<Character,Boolean> visited=new HashMap<>();
        char[] chars = s.toCharArray();
        int len=0;
        for (int k = 0; k < chars.length; k++) {
            if(!visited.containsKey(chars[k])||!visited.get(chars[k])){
                visited.put(chars[k],true);
                len=Math.max(len,k-i+1);
            }
            else{
                while(chars[i]!=chars[k]){
                    visited.put(chars[i],false);
                    i++;
                }
                i++;
            }
        }
        return len;
    }
}
