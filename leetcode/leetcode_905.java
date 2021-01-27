package leetcode;

import java.util.Arrays;

public class leetcode_905 {
    public static void main(String[] args) {
        int [] A = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }

    public static int[] sortArrayByParity(int[] A) {
        int [] results = new int[A.length];
        int n = 0;
        int m = A.length -1;
        for (int i =0; i<A.length;i++){
            System.out.println(A[i]);
            if (A[i]%2 == 0){
                results[n] = A[i];
                n++;
            } else{
                results[m] = A[i];
                m--;
            }
        }
        return results;
    }
}
