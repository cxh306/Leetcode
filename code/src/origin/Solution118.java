package origin;

import java.util.LinkedList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new LinkedList<>();
        LinkedList<Integer> first = new LinkedList<>();
        first.add(1);
        ans.add(first);
        List<Integer> pre=first;
        for (int i = 1; i < numRows; i++) {
            LinkedList<Integer> now = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i){
                    now.add(1);
                }else {
                    now.add(pre.get(j-1)+pre.get(j));
                }
            }
            ans.add(now);
            pre=now;
        }
        return ans;
    }
}
