package company_questions.amazon.VO;

public class BestTimeToBuyOrSellStocks {


    //121. one time trade
    public int maxProfit(int[] prices){
        //edge cases:
        if(prices==null||prices.length<2) return 0;
        //solution:
        //[3,4,1,6,3]
        // 3,3,1,1,1
        // 0,1,1,5,5
        int curMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<curMin){
                curMin = prices[i];
            } else {
                if(prices[i]-curMin>maxProfit){
                    maxProfit = prices[i]-curMin;
                }
            }
        }
        return maxProfit;
    }

    //122. unlimited times
    public int maxProfit2(int[] prices){
        //edge cases:
        if(prices==null||prices.length<2) return 0;
        //solution:
        int maxProfit = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]) maxProfit += prices[i+1]-prices[i];
        }
        return maxProfit;
    }

    //123. two transactions
    public int maxProfit3(int[] prices){
        //edge cases:
        if(prices==null||prices.length<2) return 0;
        //solution:
        int[] leftMax = new int[prices.length];
        int curLow = prices[0];
        for(int i=1;i<prices.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],prices[i]-curLow);
            curLow = Math.min(curLow, prices[i]);
        }

        int curHigh = prices[prices.length-1];
        int[] rightMax = new int[prices.length];
        for(int i=prices.length-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],curHigh-prices[i]);
            curHigh = Math.max(curHigh,prices[i]);
        }

        int maxProfit =0;
        for(int i=0;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,leftMax[i]+rightMax[i]);
        }
        return maxProfit;
    }

    //714. unlimited times with fees
    public int maxProfit3(int[] prices, int fee){
        int hold = Integer.MIN_VALUE, sold = 0;
        for(int i=0;i<prices.length;i++){
            hold = Math.max(hold, sold-prices[i]);
            sold = Math.max(sold, hold+prices[i]-fee);
        }
        return sold;
    }

}
