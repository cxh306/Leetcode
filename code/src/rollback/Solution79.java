package rollback;

public class Solution79 {
    boolean[][] flag;
    int[] dx={1,0,-1,0};
    int[] dy={0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        flag=new boolean[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(dfs(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int i,int j,String word,int p){
        if(p==word.length()) return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length) return false;
        if(flag[i][j]) return false;
        if(word.charAt(p)!=board[i][j]) return false;
        flag[i][j]=true;
        for (int k = 0; k < 4; k++) {
            if(dfs(board,i+dx[k],j+dy[k],word,p+1)) return true;
        }
        flag[i][j]=false;
        return false;
    }
}
