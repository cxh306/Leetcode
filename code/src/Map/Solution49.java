package Map;

import java.util.*;

public class Solution49 {

    /**
     * 排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Integer> map =new HashMap<>();
        List<List<String>> ans =new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str=strs[i].toCharArray();
            Arrays.sort(str);
            String newStr=new String(str);
            if(map.containsKey(newStr)){
                ans.get(map.get(newStr)).add(strs[i]);
            }else{
                ArrayList<String> newArray = new ArrayList<>();
                newArray.add(strs[i]);
                ans.add(newArray);
                map.put(newStr,ans.size()-1);
            }
        }
        return ans;
    }


    /**
     * 计数
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,Integer> map =new HashMap<>();
        List<List<String>> ans =new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int[] count=new int[26];

            //计算各个字符出现的次数
            for (int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j)-'a']++;
            }

            //将出现次数大于0的对应字符和出现次数绑定一起构成一个键
            StringBuilder sb =new StringBuilder();
            for (int j = 0; j < count.length; j++) {
                if(count[j]>0){
                    sb.append((char)('a'+j));
                    sb.append(count[j]);
                }
            }
            String key=sb.toString();


            if(map.containsKey(key)){
                ans.get(map.get(key)).add(strs[i]);
            }else{
                ArrayList<String> newArray = new ArrayList<>();
                newArray.add(strs[i]);
                ans.add(newArray);
                map.put(key,ans.size()-1);
            }
        }
        return ans;
    }

}
