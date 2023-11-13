class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp
        int[] dp = new int[amount+1];

        Arrays.fill(dp,amount+1);

        dp[0] = 0;

        for(int c : coins){
            for(int i = c; i<= amount; i++){
                dp[i] = Math.min(dp[i],dp[i-c]+1);
            }
        }
        if(dp[amount] <= amount){
            return dp[amount];
        }
        return -1;
    }
}

// TC: O(m*amount)
//SC : O(n)