package origin;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution172 {
    public int trailingZeroes(int n) {
        int[][] record=new int[n+1][2];
        int fiveCnt=0;
        int twoCnt=0;
        for (int i = 2; i <= n; i++) {
            if(i%2==0) record[i][0]=record[i/2][0]+1;
            if(i%5==0) record[i][1]=record[i/5][1]+1;
            twoCnt+=record[i][0];
            fiveCnt+=record[i][1];
        }
        return Math.min(fiveCnt,twoCnt);
    }


    @Test
    public void test(){
        System.out.println(trailingZeroes(1027));
    }
}
