package Offer;

public class Offer_67 {
    public int strToInt(String str) {
        /**
         * 又臭又长
         */
//        char[] chars = str.toCharArray();
//        int i=0;
//        while(i<chars.length&&chars[i]==' '){
//            i++;
//        }
//        if(i==chars.length) return 0;
//        int temp=0;
//        boolean flag=true;
//        if(chars[i]=='-'){
//            flag=false;
//        }else if(chars[i]>='0'&&chars[i]<='9'){
//            temp+=chars[i]-'0';
//        }else if(chars[i]!='+'){
//            return 0;
//        }
//        while(++i<chars.length&&Character.isDigit(chars[i])&&temp<=214748364){
//            if(chars[i]<='7'||temp<214748364){
//                temp=temp*10+chars[i]-'0';
//            }else{
//                return flag==false?Integer.MIN_VALUE:Integer.MIN_VALUE;
//            }
//        }
//        return temp;

        /**
         * 空间复杂度O(n),时间复杂度O(n)
         */
//        char[] chars = str.trim().toCharArray();
//        if(chars.length==0) return 0;
//        int res=0,i=1,sign=1,bndry=Integer.MAX_VALUE/10;
//        if(chars[0]=='-') sign=-1;
//        else if(chars[0]!='+') i=0;
//        for (int j = i; j < chars.length; j++) {
//            if(chars[j]<'0'||chars[j]>'9') break;
//            if (res>bndry||res==bndry&&chars[j]>'7') return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
//            res=res*10+chars[j]-'0';
//        }
//        return res*sign;

        /**
         * 空间复杂度O(1),时间复杂度O(n)
         */
        int i=0;
        while(i<str.length()&&str.charAt(i)==' '){
            i++;
        }
        if(i==str.length()) return 0;
        int res=0,sign=1,bndry=Integer.MAX_VALUE/10;
        if(str.charAt(i)=='-') sign=-1;
        if(str.charAt(i)=='+'||str.charAt(i)=='-') i++;
        for (int j = i; j < str.length(); j++) {
            if(str.charAt(j)<'0'||str.charAt(j)>'9') break;
            if (res>bndry||res==bndry&&str.charAt(j) > '7') return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res=res*10+(str.charAt(j)-'0');
        }
        return res*sign;
    }
}
