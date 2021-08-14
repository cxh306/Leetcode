package cracking_the_coding_interview;

public class Interview01_01 {
    public boolean isUnique(String astr) {
        boolean[] ans=new boolean[26];
        for (int i = 0; i < astr.length(); i++) {
            int key=astr.charAt(i)-'a';
            if(ans[key]){
                return false;
            }else{
                ans[key]=true;
            }
        }
        return true;
    }
}
