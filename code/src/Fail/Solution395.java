package Fail;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution395 {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length(), k);
    }

    public int dfs(String s, int start, int end, int k) {
        int[] count = new int[26];
        Set<Integer> set = new HashSet<>();
        //计数
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        //对当前的[start,end)内的子串,当一个字符出现次数小于k时,加入集合set,表示要以这个字符为分割
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] < k) {
                set.add(i);
            }
        }
        //set为空,说明[start,end)内的子串满足所有字符数都大于k,返回
        if (set.isEmpty()) return end - start;

        //字符串分割
        int p = start;
        int len = 0;
        for (int i = start; i < end; i++) {
            //当s[i]存在于set集合
            if (set.contains(s.charAt(i) - 'a')) {
                if (i - p >= k) {
                    len = Math.max(len, dfs(s, p, i, k));
                }
                p = i + 1;
            }
        }
        //边界处理
        if (end - p >= k) {
            len = Math.max(len, dfs(s, p, end, k));
        }
        return len;
    }

    @Test
    public void test() {
        System.out.println(longestSubstring("bbaaacbd"
                , 3));
    }
}
