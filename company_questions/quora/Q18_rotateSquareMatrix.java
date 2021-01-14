package company_questions.quora;

import org.junit.Test;

import java.util.Arrays;

public class Q18_rotateSquareMatrix {
    @Test
    public void test(){
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for (int[] ints : arr) System.out.println(Arrays.toString(ints));
        System.out.println();
        arr = rotateSquareMatrix(arr, 1);
        for (int[] ints : arr) System.out.println(Arrays.toString(ints));
    }

    public int[][] rotateSquareMatrix(int[][] arr, int K){
        K = K%4;
        if (K==0) return arr;
        int row = arr.length;
        int[][] arr2 = new int[row][row];
        for(int i =0;i<row;i++){
            for(int j=0;j<row;j++){
                if (i==j||i+j==row) arr2[i][j]=arr[i][j];
                if(K==1){
                    arr2[i][j] = arr[j][i];
                    arr2[j][i] = arr[row-1-i][row-1-j];
                    arr2[row-1-i][row-1-j] = arr[j][row-1-i];
                    arr2[j][row-1-i] =arr[i][j];
                }
            }
        }
        return arr2;
    }
}
