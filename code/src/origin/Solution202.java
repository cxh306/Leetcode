package origin;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (set.contains(n)) return false;
        set.add(n);
        int ans = 0;
        while (n > 0) {
            int i = n % 10;
            ans += i * i;
            n /= 10;
        }
        return isHappy(ans);
    }
}
