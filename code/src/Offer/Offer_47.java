package Offer;

public class Offer_47 {
    public int maxValue(int[][] grid) {
//        int[][] dp = new int[grid.length+1][grid[0].length+1];
        //滚动数组优化
        int[][] pre = new int[2][grid[0].length+1];
        int k=0;
        for(int i=0;i<grid.length;i++){
            k=1-k;
            for(int j=0;j<grid[0].length;j++){
                pre[k][j+1]=Math.max(pre[k][j],pre[1-k][j+1])+ grid[i][j];
            }
        }
        return pre[k][grid[0].length];
    }
}
