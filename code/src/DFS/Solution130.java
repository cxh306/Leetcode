package DFS;

public class Solution130 {
    public boolean[][] flag;
    int[] dx={1,0,-1,0};
    int[] dy={0,1,0,-1};
    public void solve(char[][] board) {
        int n=board.length,m=board[0].length;
        flag=new boolean[n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O') dfs(board,0,i);
        }
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O') dfs(board,n-1,i);
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(board,i,0);
        }
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O') dfs(board,i,m-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!flag[i][j]) board[i][j]='X';
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length) return;
        if(board[i][j]=='X'||flag[i][j]) return;
        flag[i][j]=true;
        for (int k = 0; k < 4; k++) {
            dfs(board,i+dx[k],j+dy[k]);
        }
    }
}
