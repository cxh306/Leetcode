package Offer;

public class Offer_58I {
    public String reverseWords(String s) {
        /**
         * 双指针
         */
        //去除首尾空格,若没有空格,返回这个字符串
//        s = s.trim();
//        //初始左右指针都为最后一个字符
//        int j=s.length()-1,i=j;
//        //构建StringBuilder动态字符串
//        StringBuilder sb = new StringBuilder();
//        while(i>=0){
//            while(i>=0&&s.charAt(i)==' '){
//                i--;
//                j--;
//            }
//            //遇到非空格
//            while(i>=0&&s.charAt(i)!=' '){
//                i--;
//            }
//            //遇到空格
//            //此时s[i+1,j+1]为一个单词
//            sb.append(s.substring(i+1,j+1));
//            //当i>=0,说明不是最后一个字符,附加一个空格
//            if(i>=0) sb.append(" ");
//            //j=i，搜索下一个单词
//            j=i;
//        }
//        return sb.toString();
        /**
         * 内置split函数
         * 以空格为分割符完成字符串分割后，若两单词间有 x > 1 个空格，则在单词列表 strsstrs 中，此两单词间会多出 x - 1个 “空单词” （即 ""）
         */
        String[] s1 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=s1.length-1;i>=0;i--){
            if(" ".equals(s1[i])) continue;
            sb.append(s1[i]+" ");
        }
        return sb.toString().trim();
    }
}
