
class Solution {
    public int maxProfit(int[] prices) {
        //greedy

        int profit = 0;

        for(int i = 1 ; i < prices.length; i++){
            if(prices[i-1] < prices[i]){
                profit += prices[i]- prices[i-1];
            }
        }
        return profit;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public int maxProfit(int[] prices) {
        //dp

        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i =1 ; i < prices.length; i++){
            dp[i] = dp[i-1] + Math.max(0,prices[i]-prices[i-1]);
        }
        return dp[prices.length-1];
    }
}

// TC: O(n)
// SC: O(n)