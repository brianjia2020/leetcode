package leetcode_medium;

public class leetcode_695 {
    static int maxCur = 0;
    public static int maxAreaOfIsland(int[][] grid){
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1') dfs(grid,i,j);
                maxArea = Math.max(maxCur,maxArea);
                maxCur=0;
            }
        }
        return maxArea;
    }

    public static void dfs(int[][] grid, int i, int j){
        if(i<0||i>grid.length||j<0||j>grid[i].length) return;
        if(grid[i][j]=='0') return;
        grid[i][j] = '0';
        maxCur += 1;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
