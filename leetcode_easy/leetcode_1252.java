package leetcode_easy;

public class leetcode_1252 {
    public static void main(String[] args) {

    }

    public static int oddCells(int n, int m, int[][] indices) {
        int [] r = new int[n];
        int [] c = new int[m];
        for(int[]d: indices){
            r[d[0]]++;
            c[d[1]]++;
        }

        int oddCount = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j <m; j++){
                if ((r[i] + c[j])%2 != 0) {
                    oddCount++;
                }
            }
        }
        return oddCount;
    }
}
