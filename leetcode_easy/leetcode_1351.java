package leetcode_easy;

public class leetcode_1351 {
    public static void main(String[] args) {

    }

    public static int countNegativeNumber1(int [][] grid){
        int count = 0;
        for (int i =0;i<grid.length;i++){
            for (int j=0;j<grid.length;j++){
                if (grid[i][j] < 0){
                    count++;
                }
            }
        }
        return count;
    }
}
