package Recursion;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        recur(0,0,n-1,n-1,1,ints);
        return ints;
    }

    public void recur(int x1,int y1,int x2,int y2,int count,int[][] ans){
        if(x1==x2&&y1==y2){
            ans[x1][y1]=count;
            return;
        }
        if(x1>x2||y1>y2) return;
        for (int j=y1;j<y2;j++){
            ans[x1][j]=count++;
        }
        for (int i=x1;i<x2;i++){
            ans[i][y2]=count++;
        }
        for (int j=y2;j>y1;j--){
            ans[x2][j]=count++;
        }
        for (int i=x2;i>x1;i--){
            ans[i][y1]=count++;
        }
        recur(x1+1,y1+1,x2-1,y2-1,count,ans);
    }
}
