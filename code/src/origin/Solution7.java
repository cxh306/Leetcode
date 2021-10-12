package origin;

public class Solution7 {
    public int reverse(int x) {
        final int c = 214748364;
        int sign = 1;
        if (x < 0 && x > Integer.MIN_VALUE) {
            x = -x;
            sign = -1;
        }
        if (x == Integer.MIN_VALUE) return 0;
        int ans = 0;
        while (x > 0) {
            if (ans > c || (ans == c && (x % 10 > 8 || sign == 1 && x % 10 == 8))) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return sign * ans;
    }
}
