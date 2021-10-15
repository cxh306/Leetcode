package origin;

import java.util.*;

public class Solution210 {
//    /**
//     * DFS
//     * @param numCourses
//     * @param prerequisites
//     * @return
//     */
//    List<List<Integer>> edges;
//    int[] visit;
//    int[] result;
//    boolean flag;
//    int index;
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        edges=new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            edges.add(new ArrayList<>());
//        }
//        visit=new int[numCourses];
//        result=new int[numCourses];
//        flag=true;
//        index=numCourses-1;
//        for (int i = 0; i < prerequisites.length; i++) {
//            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
//        }
//        for (int i = 0; i < numCourses&&flag; i++) {
//            if(visit[i]==0) dfs(i);
//        }
//        if(!flag) return new int[0];
//        else return result;
//    }
//    public void dfs(int u){
//        visit[u]=1;
//        for (int integer : edges.get(u)) {
//            if(visit[integer]==0){
//                dfs(integer);
//                if(!flag) return;
//            }else if(visit[integer]==1){
//                flag=false;
//                return;
//            }
//        }
//        result[index--]=u;
//        visit[u]=2;
//    }

    /**
     * BFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    List<List<Integer>> edges;
    int[] rudu;
    int[] result;
    int index=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        rudu=new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            rudu[prerequisites[i][0]]++;
        }
        result=new int[numCourses];
        Deque<Integer> queue=new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(rudu[i]==0) queue.offer(i);
        }
        while (!queue.isEmpty()){
            Integer u = queue.poll();
            result[index++]=u;
            for (Integer v : edges.get(u)) {
                rudu[v]--;
                if(rudu[v]==0) queue.offer(v);
            }
        }
        if(index < numCourses) return new int[0];
        else return result;
    }
}
