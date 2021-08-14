package stack;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        boolean[] ifexist = new boolean[26];
        int[] nums = new int[26];
        int len = chars.length;
        StringBuffer ans = new StringBuffer();
        for(int i=0;i<len;i++){
            nums[chars[i]-'a']++;
        }
        for(int i=0;i<len;i++){
            int lens = ans.length();
            if(!ifexist[chars[i]-'a']){
                while(lens>0){
                    char top = ans.charAt(lens-1);
                    if(top>=chars[i]&&nums[top-'a']>0){
                        ans.deleteCharAt(lens-1);
                        ifexist[top-'a']=false;
                    }else{
                        break;
                    }
                    lens--;
                }
                ans.append(chars[i]);
                ifexist[chars[i]-'a']=true;
            }
            nums[chars[i]-'a']--;
        }
        return ans.toString();
    }
}
