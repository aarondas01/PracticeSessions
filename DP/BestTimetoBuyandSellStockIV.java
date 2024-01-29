class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if(n < 2){
            return 0;
        }

        int[][] dp = new int[k+1][n];

        for(int i =1 ; i <= k ; i++){
            for(int j = 1 ;  j < n ; j++){
                int max = dp[i][j-1];

                for(int d = 0 ; d < j ; d++){
                    int previousProfit = dp[i-1][d];
                    int currentProfit = prices[j] - prices[d];

                    if(previousProfit + currentProfit > max){
                        max = previousProfit + currentProfit;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[k][n-1];
    }
}

// TC: O(k*n*n) = O(n^3)
// SC: O(k*n)


class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if(n<2){
            return 0;
        }

        int[][] dp = new int[k+1][n];

        for(int i = 1; i <= k; i++){
            int effectiveBuyPrice = prices[0];

            for(int j = 1; j < n; j++){
                //profit by seeling at current price j
                // profit = sp -ebp
                //sp = prices[j]
                //bp = ebp - prices[j] - previous profit dp[i-1][j]
                dp[i][j] = Math.max(dp[i][j-1], prices[j] - effectiveBuyPrice);
                effectiveBuyPrice = Math.min(effectiveBuyPrice,prices[j] - dp[i-1][j]);

            }
        }
        return dp[k][n-1];
    }
}

// TC: O(n*k)
// SC: O(n*k)


