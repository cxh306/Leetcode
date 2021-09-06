package rollback;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    List<String> ans = new ArrayList<>();
    List<StringBuilder> sb = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) return ans;
        for (int i = 0; i < 4; i++) {
            sb.add(new StringBuilder());
        }
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int i, int k) {
        if (i == s.length() && k == 4) {
            StringBuilder temp = new StringBuilder();
            for (StringBuilder stringBuilder : sb) {
                temp.append(stringBuilder);
                temp.append('.');
            }
            temp.deleteCharAt(temp.length() - 1);
            ans.add(temp.toString());
            return;
        }
        if (i > s.length() || k == 4) return;

        int j = 1;
        StringBuilder tempsb = sb.get(k);
        while (j <= 3) {
            if (!isVaild(s,i,i+j)) break;
            tempsb.append(s.charAt(i + j - 1));
            dfs(s, i + j, k + 1);
            j++;
        }
        while (--j > 0) {
            tempsb.deleteCharAt(tempsb.length() - 1);
        }
    }

    public boolean isVaild(String s,int i,int j) {
        if(i<0||j>s.length()) return false;
        String subString=s.substring(i,j);
        int num = Integer.parseInt(subString);
        if (subString.charAt(0) == '0') {
            if (subString.length() == 1) return true;
            else return false;
        }
        if (num <= 255 && num >= 1) return true;
        else return false;
    }

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("101023"));
    }
}
