package DFS;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution547 {
//    boolean[] flag;
//    public int findCircleNum(int[][] isConnected) {
//        flag=new boolean[isConnected.length];
//        int cnt=0;
//        for (int i = 0; i < isConnected.length; i++) {
//            if(flag[i]) continue;
//            cnt++;
//            Deque<Integer> q=new LinkedList<>();
//            q.push(i);
//            flag[i]=true;
//            while (!q.isEmpty()){
//                int k=q.pop();
//                for (int j = 0; j < isConnected.length; j++) {
//                    if(!flag[j]&&isConnected[k][j]==1){
//                        flag[j]=true;
//                        q.push(j);
//                    }
//                }
//            }
//        }
//        return cnt;
//    }

    /**
     * dfs
     * @param isConnected
     * @return
     */
    boolean[] flag;
    public int findCircleNum(int[][] isConnected) {
        flag=new boolean[isConnected.length];
        int ans=0;
        for (int i = 0; i < isConnected.length; i++) {
            if(flag[i]) continue;
            ans++;
            dfs(isConnected,i);
        }
        return ans;
    }

    void dfs(int[][] isConnected,int i){
        for (int j = 0; j < isConnected.length; j++) {
            if (!flag[j]&&isConnected[i][j]==1){
                flag[j]=true;
                dfs(isConnected,j);
            }
        }
    }
}
