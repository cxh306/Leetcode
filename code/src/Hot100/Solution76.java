package Hot100;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution76 {
    public String minWindow(String s, String t) {
        //记录可能的s的下标
        Deque<Integer> queue = new LinkedList<>();
        //哈希表
        int[] map = new int[58];
        int len1 = s.length();
        int len2 = t.length();
        for (int i = 0; i < len2; i++) {
            int index = t.charAt(i) - 'A';
            map[index]++;
        }
        for (int i = 0; i < map.length; i++) {
            //不在t中的字符记为最小int
            if(map[i]==0) map[i]=Integer.MIN_VALUE;
        }
        //答案的最小长度
        int min_len = Integer.MAX_VALUE;
        //答案的左右边界（s的）
        int[] ansIndex = {0, 0};
        //遍历s
        for (int i = 0; i < len1; i++) {
            //获得s[i]在map中的key
            int index = s.charAt(i) - 'A';
            //若s[i]在t中存在
            if (map[index]!=Integer.MIN_VALUE) {
                //当s[i]映射在count中的值减完一后依然非负,总长度len2减一,否则就说明该值"用完了",不用减一
                if(--map[index]>=0) len2--;
                //该值为可能答案的一个元素
                queue.addLast(i);
                //如果len2==0,说明有了一个可能答案
                if (len2 == 0) {
                    //如果queue的前端的s坐标对应的字符映射在count中的值小于0，该坐标是可以被抛弃的，因为去掉该字符不会影响len2
                    while (map[s.charAt(queue.getFirst())-'A']<0){
                        map[s.charAt(queue.getFirst())-'A']++;
                        queue.removeFirst();
                    }
                    
                    //更新答案字符串的最小长度以及对应的s中的边界
                    int len = queue.getLast() - queue.getFirst() + 1;
                    if (len < min_len) {
                        min_len = len;
                        ansIndex[0] = queue.getFirst();
                        ansIndex[1] = i + 1;
                    }
                }
            }
        }
        //获得最小边界ansIndex,取s中的子串就为答案
        return s.substring(ansIndex[0], ansIndex[1]);
    }

    @Test
    public void test() {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t =  "abcdd";
        System.out.println(minWindow(s, t));

    }
}
