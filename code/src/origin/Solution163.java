package origin;

import java.util.ArrayList;
import java.util.List;

public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> arrayList = new ArrayList<>();
        int pre = lower;
        for (int num : nums) {
            addToList(pre, num - 1, arrayList);
            pre = num + 1;
        }
        addToList(pre, upper, arrayList);
        return arrayList;
    }

    void addToList(int l1, int l2, List<String> l) {
        if (l1 > l2) return;
        StringBuilder sb = new StringBuilder();
        sb.append(l1);
        if (l1 < l2) {
            sb.append("->");
            sb.append(l2);
        }
        l.add(sb.toString());
    }
}
