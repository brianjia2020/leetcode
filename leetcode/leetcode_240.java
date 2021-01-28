package leetcode;

public class leetcode_240 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,4,7,11,15};
        matrix[1] = new int[]{2,5,8,12,19};
        matrix[2] = new int[]{3,6,9,16,22};
        matrix[3] = new int[]{10,13,14,17,24};
        matrix[4] = new int[]{18,21,23,26,30};

        System.out.println(searchMatrix2(matrix,5));
    }

    //1. first method - iterative
    public static boolean searchMatrix2(int[][] matrix, int target){
        if(matrix==null||matrix.length==0) return false;
        int minDim = Math.min(matrix.length,matrix[0].length);
        for(int i=0;i<minDim;i++){
            boolean vertical = searchMatrix2(matrix, target, i, true);
            boolean horizontal = searchMatrix2(matrix, target, i, false);
            if(vertical||horizontal) return true;
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target, int start, boolean vertical){
        int l = start;
        int h = vertical?matrix[0].length-1:matrix.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(vertical){
                if(matrix[start][mid]<target){
                    l = mid +1;
                } else if (matrix[start][mid]==target) {
                    return true;
                } else {
                    h = mid -1;
                }
            } else {
                if(matrix[mid][start]<target){
                    l = mid + 1;
                } else if(matrix[mid][start]==target){
                    return true;
                } else {
                    h = mid - 1;
                }
            }
        }
        return false;
    }

    //2. recursive approach
    int[][] matrix;
    int target;

    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix==null||matrix.length==0) return false;
        this.matrix=matrix;
        this.target=target;
        return searchBySquare(0,0,matrix[0].length-1,matrix.length-1);
    }

    public boolean searchBySquare(int left,int up,int right, int down){
        if(up>down||left>right) return false;
        if(matrix[up][left]>target||matrix[down][right]<target) return false;
        int mid = left + (right-left)/2;
        int row = up;
        while(row<=down&&matrix[row][mid]<=target){
            if(matrix[row][mid]==target) return true;
            row++;
        }
        return searchBySquare(left,up,mid-1,down) || searchBySquare(mid+1,up,right,row-1);
    }
}
