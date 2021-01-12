package company_questions.quora;

import org.junit.Test;

import java.util.Arrays;

public class Q18_rotateSquareMatrix {
    @Test
    public void test(){
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        arr = rotateSquareMatrix(arr, 1);
        for (int[] ints : arr) System.out.println(Arrays.toString(ints));
    }

    public int[][] rotateSquareMatrix(int[][] arr, int K){
        K = K%4;
        if (K==0) return arr;
        int row = arr.length;
        for(int i =0;i<row;i++){
            for(int j=0;j<row;j++){
                if(i==j||i+j==row) continue;
                int temp = arr[i][j];
                if(K==1){
                    arr[i][j] = arr[row-1-j][row-1-i];
                    arr[row-1-j][row-1-i] = temp;
                } else if(K==2){
                    arr[i][j]= arr[row-1-i][row-1-j];
                    arr[row-1-i][row-1-j] = temp;
                } else {
                    arr[i][j]=arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        return arr;
    }
}
