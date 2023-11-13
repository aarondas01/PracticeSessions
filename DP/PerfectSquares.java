class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i =1; i <= n ; i++){
            for(int j =1; j*j <= i; j++){
                int rem = i-j*j;
                dp[i] = Math.min(dp[i], dp[rem]+1);
            }
        }
        return dp[n];
    }
}
// TC: O(n*logk)
// SC: O(n)

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;

            for(int j = 1; j*j <=i ;j++){
                int rem = i-j*j;
                if(dp[rem] < min){
                    min =dp[rem];
                }
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
}

// TC: O(n sqrt(n))
// SC: O(n)