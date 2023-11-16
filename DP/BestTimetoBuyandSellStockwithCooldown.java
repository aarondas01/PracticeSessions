class Solution {
    public int maxProfit(int[] prices) {
        //dp

        if(prices ==  null || prices.length < 2){
            return 0;
        }

        int n = prices.length;

        int[] sell = new int[n];
        int[] cooldown = new int[n];

        sell[1] = prices[1]-prices[0];

        for(int i=2; i < n ; i++){
            cooldown[i] = Math.max(cooldown[i-1], sell[i-1]);
            sell[i] = prices[i] - prices[i-1] + Math.max(sell[i-1],cooldown[i-2]);
        }

        return Math.max(sell[n-1],cooldown[n-1]);
    }
}

// TC: O(n)
// SC: O(n)

class Solution {
    public int maxProfit(int[] prices) {

        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;

        for(int price : prices){
            int prevSold = sold;
            sold = held + price;
            held = Math.max(held, reset-price);
            reset = Math.max(reset, prevSold);
        }

        return Math.max(sold, reset);
    }
}
// TC: O(n)
// SC: O(1)