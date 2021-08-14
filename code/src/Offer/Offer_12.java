package Offer;

public class Offer_12 {

    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] arr = word.toCharArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
//                if(helper(board,arr,0,visited,i,j)){
//                    return true;
//                }
                if(dfs(board,arr,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board
     * @param word
     * @param index:当前搜索的word索引
     * @param visited:visited[i][j]代表board[i][j]是否搜索过
     * @param i
     * @param j
     * @return
     */
    public boolean helper(char[][] board,char[] word,int index,boolean[][] visited,int i,int j){
        //当index=word.length 找到
        if(index == word.length){
            return true;
        }
        //越界判断
        if(i<0||i>board[0].length||j<0||j>board.length){
            return false;
        }
        //当前board[i][j]已经被搜索过,则false
        if(visited[i][j]){
            return false;
        }
        //当前board[i][j]=word[index]
        if(word[index] == board[i][j]){
            visited[i][j]=true;//
            index++;
            boolean flag = helper(board,word,index,visited,i+1,j)||helper(board,word,index,visited,i-1,j)
                    ||helper(board,word,index,visited,i,j+1)||helper(board,word,index,visited,i,j-1);
            if(!flag){
                visited[i][j]=false;
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }



    /**************优化*******************/

    /*方向数组*/
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;//字符串存在
        board[i][j] = '\0';//将board[i][j]标记为'\0'代表访问过(当目标字符串存在'\0'时无效，应该取其他字符),节省了visited数组开销

        for(int q=0;q<4;q++){//上下左右
            if(dfs(board,word,i+dx[q],j+dy[q],k+1)){
                return true;
            }
        }
        board[i][j] = word[k];
        return false;
    }

}