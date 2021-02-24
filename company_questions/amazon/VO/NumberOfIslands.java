package company_questions.amazon.VO;

public class NumberOfIslands {
    int count = 0;
    public int numIslands(char[][] grid){
        //edge cases:
        if(grid==null||grid.length==0) return count;
        //solution:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[0][j]=='1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0') return;
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid, i+1,j);
        dfs(grid, i,j-1);
        dfs(grid, i,j+1);
    }
}
