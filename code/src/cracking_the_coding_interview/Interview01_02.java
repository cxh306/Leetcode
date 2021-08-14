package cracking_the_coding_interview;

public class Interview01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        int[] temp=new int[26];
        if(s1.length()!=s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i)-'a']++;
            temp[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]!=0) return false;
        }
        return true;
    }
}
