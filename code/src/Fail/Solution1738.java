package Fail;

import java.util.PriorityQueue;

/**
 * 异或、DP、第k大/小快排,小顶堆/大顶堆
 * a^a=0,a^a^a=a,
 */
public class Solution1738 {
//    public int kthLargestValue(int[][] matrix, int k) {
//        int m=matrix.length,n=matrix[0].length;
//        int[][] dp=new int[m+1][n+1];
//        int[] temp=new int[m*n];
//        int p=0;
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j]=dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i-1][j-1];
//                temp[p++]=dp[i][j];
//            }
//        }
//        return quickSort(temp,0,temp.length-1,temp.length-k);
//    }
//
//    private int quickSort(int[] arr,int start,int end,int k){
//        if(start>end) return Integer.MIN_VALUE;
//        int value=arr[start];
//        int i=start,j=end;
//        while(i<j){
//            while(i<j&&arr[j]>=value) j--;
//            if(i<j) arr[i]=arr[j];
//            while (i<j&&arr[i]<=value) i++;
//            if(i<j) arr[j]=arr[i];
//        }
//        arr[i]=value;
//        if(i>k) return quickSort(arr,start,i-1,k);
//        else if(i<k) return quickSort(arr,i+1,end,k);
//        else return value;
//    }

    /**
     * 比前一种方法时间复杂度更低
     * DP+小顶堆
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int m=matrix.length,n=matrix[0].length;
        int[][] dp=new int[m+1][n+1];
        PriorityQueue<Integer> q=new PriorityQueue<>(k);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i-1][j-1];
                if(q.size()<k) q.add(dp[i][j]);
                else if(q.peek()<dp[i][j]){
                    q.poll();
                    q.add(dp[i][j]);
                }
            }
        }
        return q.peek();
    }
}
