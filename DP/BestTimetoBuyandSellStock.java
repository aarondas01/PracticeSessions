class Solution {
    public int maxProfit(int[] prices) {
        //dp
        int[] dp = new int[prices.length];
        int sell = 0;

        dp[0] = prices[0];
        for(int i =1; i < prices.length; i++){
            dp[i] = Math.min(dp[i-1],prices[i]);
        }
        for(int i=0; i < prices.length; i++){
            sell = Math.max(sell,prices[i] -dp[i]);
        }
        return sell;
    }
}

// TC: O(n)
// sC: O(n)

class Solution {
    public int maxProfit(int[] prices) {
        // greedy

        int buy = Integer.MAX_VALUE, sell = 0;
        for(int price : prices){
            buy = Math.min(buy,price);
            sell = Math.max(sell, price-buy);
        }
        return sell;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = 0 , maxProfit = 0;

        for(int price : prices){
            buy = Math.min(buy,price);
            profit = price-buy;
            maxProfit = Math.max(maxProfit,profit);
        }
        return  maxProfit;
    }
}

// TC: O(n)
// SC: O(1)