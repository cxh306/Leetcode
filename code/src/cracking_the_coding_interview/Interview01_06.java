package cracking_the_coding_interview;

public class Interview01_06 {
    public String compressString(String S) {
        if(S.length()==0) return S;
        StringBuilder sb=new StringBuilder();
        int count=0;
        char pre=S.charAt(0);
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)!=pre){
                sb.append(pre);
                sb.append(count);
                pre=S.charAt(i);
                count=1;
            }else{
                count++;
            }
        }
        sb.append(pre);
        sb.append(count);
        return sb.length()<S.length()?sb.toString():S;
    }
}
