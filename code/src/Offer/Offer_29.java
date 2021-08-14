package Offer;

public class Offer_29{
    int[] ans = new int[0];
    int p=0;
    public int[] spiralOrder(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return ans;
        int n=matrix[0].length;
        if(n==0) return ans;
        ans = new int[m*n];
        helper(matrix,0,m-1,0,n-1);
        return ans;
    }
    public void helper(int[][] matrix,int up,int down,int left,int right){
        if(left>right||up>down){
            return;
        }
        if(left==right){
            for(int i=up;i<=down;i++){
                ans[p++]=matrix[i][left];
            }
            return;
        }
        if(up==down){
            for(int i=left;i<=right;i++){
                ans[p++]=matrix[up][i];
            }
            return;
        }
        for(int i=left;i<right;i++){
            ans[p++]=(matrix[up][i]);
        }
        for (int i=up;i<down;i++){
            ans[p++]=(matrix[i][right]);
        }
        for(int i=right;i>left;i--){
            ans[p++]=(matrix[down][i]);
        }
        for(int i=down;i>up;i--){
            ans[p++]=(matrix[i][left]);
        }
    }
}
