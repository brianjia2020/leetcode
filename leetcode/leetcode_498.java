package leetcode;

public class leetcode_498{
    private static void main() {
        
    }

    public int[] findDiagnalOrder(int[][] mat){
        if (mat==null || mat.length==0) return new int[]{};
        int m = mat.length, n = mat[0].length, r = 0, c = 0;
        int[] result = new int[m*n];
        for(int i =0; i<result.length; i++){
            result[i] = mat[r][c];
            if((r+c)%2==0){
                if(c == n-1) {
                    r ++;
                } else if (r==0){
                    c ++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if(r==m-1){
                    c++;
                } else if (c==0){
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}