package leetcode;

import org.junit.Test;

public class leetcode_221 {


    //1. dp solution 1 o(n^2)
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sum = new int[m+1][n+1];
        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                sum[i][j] = matrix[i-1][j-1] - '0' + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        int ans = 0;
        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                for (int k = Math.min(m-i+1,n-j+1);k>0;k--){
                    int total = sum[i+k-1][j+k-1]-sum[i+k-1][j-1]-sum[i-1][j+k-1]+sum[i-1][j-1];
                    if(total == k*k){
                        ans = Math.max(ans,total);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    //2.dp
    public int maximalSquare2(char[][] matrix){
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;

        for(int i =1;i<=rows;i++){
            for (int j=1;j<=cols;j++){
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    maxsqlen = Math.max(maxsqlen,dp[i][j]);
                }
            }
        }

        return maxsqlen*maxsqlen;
    }
}
