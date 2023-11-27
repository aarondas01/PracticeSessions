
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n==0){
            return 0;
        }

        //bidrectional dp

        int[] left = new int[n];
        int[] right = new int[n];

        //left to right
        int min = prices[0];
        for(int i=1; i < n ; i++){
            //update the buy price
            if(prices[i] < min){
                min = prices[i];
            }
            //calculate current profit
            int profit = prices[i]-min;
            //fill the left array
            left[i] = Math.max(left[i-1],profit);
        }

        //right to left
        int max = prices[n-1];
        for(int i = n-2; i >=0 ; i--){
            // update the sell price
            if(prices[i] > max){
                max = prices[i];
            }
            //calculate the current profit
            int profit = max- prices[i];
            //fill the right array
            right[i] = Math.max(right[i+1],profit);
        }

        int maxProfit = 0;
        for(int i = 0 ; i < n ; i++){
            maxProfit = Math.max(maxProfit,left[i]+right[i]);
        }

        return maxProfit;
    }
}

// TC: O(n)
// SC: O(N)

class Solution {
    public int maxProfit(int[] prices) {
        //one pass simulation

        int minPrice1 = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;

        //profit p2 is the cummulative profit

        int profit1 = 0, profit2 = 0;
        for(int price : prices){
            minPrice1 = Math.min(minPrice1, price);
            profit1  = Math.max(profit1,price-minPrice1);

            minPrice2 = Math.min(minPrice2,price-profit1);
            profit2 = Math.max(profit2, price-minPrice2);
        }
        return profit2;

    }
}

// TC: O(n)
// SC: O(1)