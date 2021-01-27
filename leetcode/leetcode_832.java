package leetcode;

public class leetcode_832 {
    public static void main(String[] args) {

    }

    public int[][] flipAndInvertImage(int[][] A) {
        //flip an image horizontally
        for(int i =0; i < A.length; i++){
            int j = 0, k = A[i].length -1;
            while(j <= k){
                if (A[i][j] == A[i][k]){
                    if (A[i][j] == 1){
                        A[i][j] = 0;
                        A[i][k] = 0;
                    } else{
                        A[i][j] = 1;
                        A[i][k] = 1;
                    }
                }
                j++;
                k--;
            }
        }
        return A;
    }
}
