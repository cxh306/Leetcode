package origin;

public class Solution38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String before = countAndSay(n - 1);
        char pivot = before.charAt(0);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) == pivot) {
                count++;
            } else {
                sb.append(count);
                sb.append(pivot);
                count = 1;
                pivot = before.charAt(i);
            }
        }
        sb.append(count);
        sb.append(pivot);
        return sb.toString();
    }
}
