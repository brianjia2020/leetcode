package company_questions.amazon;

import java.util.Arrays;

public class Q4_StorageOptimization {
    public static void main(String[] args) {
        int[][] arr = new int[4][3];
        System.out.println(storageOptimize(6,6,new int[]{4},new int[]{2}));
    }

    public static int storageOptimize(int n, int m, int[] h, int[] v){
        int[][] arr = new int[n+1][m+1];
        for(int i=0;i<arr.length;i++) Arrays.fill(arr[i],1);
        for(int num: h) updateValueH(arr,num);
        for(int num: v) updateValueV(arr,num);
        int res = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]>res) res = arr[i][j];
            }
        }
        return res;
    }

    public static void updateValueH(int[][] arr, int h){
        for(int i=0;i<arr.length;i++){
            if (i != h) continue;
            for(int j=0;j<arr[i].length;j++){
                    int temp = arr[i][j] + arr[i-1][j];
                    arr[i][j] = temp;
                    arr[i-1][j] = temp;
                }
            }
        }

    public static void updateValueV(int[][] arr, int v){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(j!=v) continue;
                int temp = arr[i][j] + arr[i][j-1];
                arr[i][j] = temp;
                arr[i][j-1] = temp;
            }
        }
    }


}
