package leetcode_easy;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_121 {
    @Test
    public void test(){
        int[] inputs = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(inputs));
    }

    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : prices) {
            if (price < min_price) {
                min_price = price;
            } else if (price - min_price > max_profit) {
                max_profit = price - min_price;
            }
        }
        return max_profit;
    }
}
