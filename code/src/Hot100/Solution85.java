package Hot100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] cnt = new int[n + 2];
        cnt[0]=-1;cnt[n+1]=-1;
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    if (matrix[i][j] == '1') cnt[j + 1]++;
                    else cnt[j + 1] = 0;
                }
                while (cnt[stack.peekLast()] > cnt[j + 1]) {
                    int height = cnt[stack.removeLast()];
                    int width = j - stack.peekLast();
                    area = Math.max(area, width * height);
                }
                if (j < n) {
                    stack.addLast(j + 1);
                }
            }
        }
        return area;
    }

    @Test
    public void test() {
//        char[][] a = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}
//                , {'1', '0', '0', '1', '0'}};
        char[][] a = new char[][]{{'1', '0'}, {'1', '0'}};
        System.out.println(maximalRectangle(a));
    }

}
