package origin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution13 {
    public int romanToInt(String s) {
        int len=s.length();
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char pre='\0';
        int ans=0;
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(pre=='\0'){
                if(!judge(c)){
                    ans+=map.get(c);
                }else{
                    pre=c;
                }
            }else{
                if(judge1(pre,c)){
                    ans+=map.get(c)-map.get(pre);
                    pre='\0';
                }else{
                    ans+=map.get(pre);
                    pre=c;
                }
            }
        }
        if(pre!='\0') ans+=map.get(pre);
        return ans;
    }

    public boolean judge(char c){
        if(c=='I'||c=='X'||c=='C') return true;
        else return false;
    }

    public boolean judge1(char pre,char c){
        if(pre=='I'&&(c=='V'||c=='X') || pre=='X'&&(c=='L'||c=='C')||pre=='C'&&(c=='D'||c=='M')) return true;
        else  return false;
    }
}
