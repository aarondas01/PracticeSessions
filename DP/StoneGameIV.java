class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];

        dp[1] = true;
        for(int i=2; i< n+1; i++){

            //check the perfect squares
            for(int k =1 ; k*k <=i ; k++){
                if(!dp[i-k*k]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

// TC: O(N* Sqrt(n))
// SC: O(N)