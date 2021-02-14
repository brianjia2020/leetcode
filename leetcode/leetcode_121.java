package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_121 {
    @Test
    public void test(){
        int[] inputs = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit2(inputs));
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

    public int maxProfit2(int[] prices){
        int[] gains = new int[prices.length];
        gains[0] = 0;
        for(int i=1;i<prices.length;i++){
            gains[i] = (prices[i]-prices[i-1]);
        }

        int[] trackProfit = new int[prices.length];
        int max = 0;
        for(int i=1;i<gains.length;i++){
            trackProfit[i] = Math.max(gains[i], trackProfit[i-1]+gains[i]);
            if(trackProfit[i]>max){
                max = trackProfit[i];
            }
        }
        return max;
    }
}
