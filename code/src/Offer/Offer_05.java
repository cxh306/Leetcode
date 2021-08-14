package Offer;

public class Offer_05 {
    public String replaceSpace(String s) {
        StringBuffer ans = new StringBuffer();
        char[]  ss = s.toCharArray();
        for(int i=0;i<ss.length;i++){
            if(ss[i]==' '){
                ans.append('%');
                ans.append('2');
                ans.append('0');
            }else{
                ans.append(ss[i]);
            }
        }
        return ans.toString();
    }
}
