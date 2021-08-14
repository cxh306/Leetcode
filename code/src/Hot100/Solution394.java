package Hot100;

import java.util.LinkedList;

public class Solution394 {
    public String decodeString(String s) {
        LinkedList<StringBuilder> l=new LinkedList<>();
        char[] chars = s.toCharArray();
        StringBuilder ans=new StringBuilder();
        for (int i=0;i<chars.length;){
            StringBuilder stringBuilder = new StringBuilder();
            if(chars[i]=='['){
                stringBuilder.append('[');
                l.addLast(stringBuilder);
                i++;
            }else if(Character.isDigit(chars[i])){
                while(i<chars.length&&Character.isDigit(chars[i])){
                    stringBuilder.append(chars[i++]);
                }
                l.addLast(stringBuilder);
            }else if(i<chars.length&&Character.isLetter(chars[i])){
                while(i<chars.length&&Character.isLetter(chars[i])){
                    stringBuilder.append(chars[i++]);
                }
                if(l.isEmpty()) ans.append(stringBuilder);
                else l.addLast(stringBuilder);
            }else{
                StringBuilder stringBuilder1 = l.removeLast();
                //StringBuilder/StringBuilder没有重写equals方法
                while(!l.getLast().toString().equals("[")){
                    stringBuilder1=l.getLast().append(stringBuilder1);
                    l.removeLast();
                }
                l.removeLast();
                int num=Integer.parseInt(l.removeLast().toString());
                StringBuilder temp=new StringBuilder();
                for (int j = 0; j < num; j++) {
                    temp.append(stringBuilder1);
                }
                l.addLast(temp);
                i++;
            }
        }
        for (var c:l) {
            ans.append(c);
        }
        return ans.toString();
    }
}
