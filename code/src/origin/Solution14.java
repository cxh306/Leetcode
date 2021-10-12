package origin;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int i=0;
        while (true){
            if(i>=strs[0].length()) return strs[0].substring(0,i);
            char duizhao=strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i>=strs[j].length()||strs[j].charAt(i)!=duizhao) return strs[0].substring(0,i);
                i++;
            }
        }
    }
}
