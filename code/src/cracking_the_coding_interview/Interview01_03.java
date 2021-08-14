package cracking_the_coding_interview;

public class Interview01_03 {
    public String replaceSpaces(String S, int length) {
        char[] ss = S.toCharArray();
        int j=S.length();
        for (int i = length-1; i >=0; i--) {
            if (ss[i]==' '){
                ss[--j]='0';
                ss[--j]='2';
                ss[--j]='%';
            }else{
                ss[--j]=ss[i];
            }
        }
        //String(char[],int start,int length);构造方法
        return new String(ss,j,ss.length-j);
    }
}
