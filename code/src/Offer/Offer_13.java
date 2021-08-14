package Offer;

public class Offer_13  {
    public int movingCount(int m, int n, int k) {
        boolean[][] flag=new boolean[m][n];
        return dfs(0,0,flag,k,m,n);
    }
    public int[] dx ={1,0,-1,0};
    public int[] dy ={0,1,0,-1};
    public int dfs(int i,int j,boolean[][] flag,int k,int m,int n){
        if(i<0||i>=m||j<0||j>=n||flag[i][j]){
            return 0;
        }
        if(cm(i)+cm(j)>k){
            flag[i][j]=true;
            return 0;
        }
        flag[i][j]=true;
        int ans=0;
        for(int q=0;q<4;q++){
            ans+=dfs(i+dx[q],j+dy[q],flag,k,m,n);
        }
        return ans+1;
    }

    public int cm(int num){
        int ans=0;
        while(num>0){
            ans+=num%10;
            num/=10;
        }
        return ans;
    }
}