package leetcode_medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class leetcode_322 {
    @Test
    public void test(){
        int a = coinChange2(new int[]{474,83,404,3},264);
        System.out.println(a);
    }

    public int coinChange2(int[] coins, int amount){
        if (amount <= 0 || coins.length == 0) return 0;
        int[] dp = new int [amount+1];
        Arrays.fill(dp,amount+1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++){
            for ( int coin: coins){
                if (coin > i){
                    break;
                }

                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount] > amount ? -1: dp[amount];
    }




    //DFS
//    public int coinChange2(int[] coins, int amount){
//        Arrays.sort(coins, Collections.reverseOrder());
//    }
}
