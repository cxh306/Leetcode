package origin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row=new HashSet<>();
        Set<Integer> col=new HashSet<>();
        int m=matrix.length,n=matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Iterator<Integer> iterator = row.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            for (int i = 0; i < n; i++) {
                matrix[next][i]=0;
            }
        }
        iterator=col.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            for (int i = 0; i < n; i++) {
                matrix[i][next]=0;
            }
        }
    }
}
