package Hot100;

import java.util.*;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> queue=new LinkedList<>();
        int[] map=new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)-'a']++;
        }
        List<Integer> ans =new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(map[s.charAt(i)-'a']==0){
                while(!queue.isEmpty()&&s.charAt(i)!=s.charAt(queue.getFirst())){
                    map[s.charAt(queue.removeFirst())-'a']++;
                }
                if(!queue.isEmpty()){
                    queue.removeFirst();
                    queue.addLast(i);
                }
            }
            else{
                map[s.charAt(i)-'a']--;
                queue.addLast(i);
            }
            if(queue.size()==p.length()) ans.add(queue.getFirst());
        }
        return ans;
    }
    public List<Integer> findAnagrams1(String s, String p) {
        int[] map=new int[26];//哈希表，'a'->0->map[0],'b'->1->map[1],...
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)-'a']++;
        }

        List<Integer> ans =new LinkedList<>();

        int left=0;//左指针left
        for (int right = 0; right < s.length(); right++) {
            int key=s.charAt(right)-'a';
            if(map[key]==0){//当右指针对应的值不在哈希表中
                while(s.charAt(right)!=s.charAt(left)){//更新左指针为与右指针相同的下一个index
                    map[s.charAt(left++)-'a']++;//左指针对应字符要放回哈希表
                }
                //此时s.charAt(right)==s.charAt(left)
                //1.right对应的值存在于给定p字符串，则left为第一个与right对应值相同,跳过
                //2.right对应的值不存在于给定p字符串，此时right==left,自然left也不是左边界,跳过
                left++;
            }
            else{
                map[key]--;//右指针对应的哈希表的值要减1
            }
            if(right-left+1==p.length()){//当【left,right】之内的个数与p字符串相等
                ans.add(left);//把left加入答案数组
            }
        }
        return ans;
    }

}
