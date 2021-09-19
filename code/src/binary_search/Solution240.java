package binary_search;

public class Solution240 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        return helper(matrix,target,0,0,matrix[0].length-1,matrix.length-1);
//    }
//    public boolean helper(int[][] matrix,int target,int x1,int y1,int x2,int y2){
//        if(x1>x2||y1>y2) return false;
//        x2=binarySearch(matrix,x1,x2,y1,target,true);
//        if(matrix[y1][x2]==target) return true;
//        y2=binarySearch(matrix,y1,y2,x1,target,false);
//        if(matrix[y2][x1]==target) return true;
//        x1++;
//        y1++;
//        return helper(matrix,target,x1,y1,x2,y2);
//    }
//    public int binarySearch(int[][] matrix,int left,int right,int now,int target,boolean flag){
//        if(flag){
//            while(left<right){
//                int mid=(left+right+1)/2;
//                if(matrix[now][mid]>target){
//                    right=mid-1;
//                }
//                else if(matrix[now][mid]<target){
//                    left=mid;
//                }else{
//                    return mid;
//                }
//            }
//            return left;
//        }else{
//            while(left<right){
//                int mid=(left+right+1)/2;
//                if(matrix[mid][now]>target){
//                    right=mid-1;
//                }
//                else if(matrix[mid][now]<target){
//                    left=mid;
//                }else{
//                    return mid;
//                }
//            }
//            return left;
//        }
//    }

    //O(m+n)时间复杂度
    //从左下角开始看,则这一列与这一行结合是一个单调的集合，当左下角这个数小于target，就向右移动一格，否则向上移动一格
    public boolean searchMatrix(int[][] matrix, int target) {
        int x1=0,y1=matrix.length-1;
        while(x1<matrix[0].length&&y1>=0){
            if(matrix[x1][y1]<target) x1++;
            else if(matrix[x1][y1]>target) y1--;
            else return true;
        }
        return false;
    }
}
