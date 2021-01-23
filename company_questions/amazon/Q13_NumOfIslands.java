package company_questions.amazon;

import java.util.Arrays;

public class Q13_NumOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = numOfIslands(grid);
        System.out.println(i);
    }


    public static int numOfIslands(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0') return;
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
