package Offer;

import java.util.LinkedList;

public class Offer_50 {
    public char firstUniqChar(String s) {
        int len=s.length();
        //数组充当小写字符的哈希表,key:'?'-'a',value:exist['?'-'a']
        int[] exist = new int[26];
        //统计对应字符出现的个数
        for (int i = 0; i < len; i++) {
            exist[s.charAt(i)-'a']++;
        }
        //答案预设为' '
        char ans=' ';
        //寻找第一个出现一次的字符
        int i=0;
        while(i<len){
            if(exist[s.charAt(i)-'a']==1){
                ans=s.charAt(i);
                break;
            }
            i++;
        }
        //返回结果
        return ans;
    }
}
