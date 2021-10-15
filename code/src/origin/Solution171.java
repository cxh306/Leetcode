package origin;

public class Solution171 {
    public int titleToNumber(String columnTitle) {
        return dfs(columnTitle,0);
    }

    int dfs(String columnTitle,int i){
        if(i==columnTitle.length()) return 0;
        int len=columnTitle.length()-i;
        return (columnTitle.charAt(i)-'A'+1)*(int) Math.pow(26,len-1)+dfs(columnTitle,i+1);
    }
}
