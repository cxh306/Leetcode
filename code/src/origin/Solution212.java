package origin;

import java.util.*;

/**
 * 前缀树(字典树) + dfs
 */
public class Solution212 {
    int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    class Trie {
        String word;
        Map<Character, Trie> child;

        Trie() {
            word = "";
            child = new HashMap<>();
        }

        void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char ch=word.charAt(i);
                if(!cur.child.containsKey(ch)){
                    cur.child.put(ch,new Trie());
                }
                cur=cur.child.get(ch);
            }
            cur.word=word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        HashSet<String> strings = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        int m=board.length,n=board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j=0;j<n;j++){
                dfs(board,trie,i,j,strings);
            }
        }
        return new ArrayList<>(strings);
    }

    public void dfs(char[][] board, Trie now, int i, int j, Set<String> set){
        if(!now.child.containsKey(board[i][j])) return;
        char ch=board[i][j];
        now = now.child.get(ch);
        if(!"".equals(now.word)) set.add(now.word);
        board[i][j]='#';
        for (int k = 0; k < dir.length; k++) {
            int i1=i+dir[k][0];
            int j1=j+dir[k][1];
            if(i1>=0&&i1<board.length&&j1>=0&&j1<board[0].length) {
                dfs(board, now, i1 , j1 , set);
            }
        }
        board[i][j]=ch;
    }
}
