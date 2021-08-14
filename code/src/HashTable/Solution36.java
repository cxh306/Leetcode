package HashTable;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[10][10];
        boolean[][] col=new boolean[10][10];
        boolean[][] block=new boolean[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='.') continue;;
                int num=board[i][j]-'0';
                int idx=i/3*3+j/3;
                if(block[idx][num]||row[i][num]||col[j][num]) return false;
                block[idx][num]=true;
                row[i][num]=true;
                col[j][num]=true;
            }
        }
        return true;
    }
}
