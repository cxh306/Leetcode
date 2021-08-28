package binary_search;

import org.junit.Test;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int len = m * n;
        int left=0,right=len-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            int row=mid/n,col=mid%n;
            if(matrix[row][col]>target){
                right=mid-1;
            }else if(matrix[row][col]<target){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }

}
