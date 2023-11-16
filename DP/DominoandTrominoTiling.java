class Solution {
    public int numTilings(int n) {
        if(n==0 || n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 5;
        }

        long res1 = 1;
        long res2 = 2;
        long res3 = 5;

        long mod =1000000007;

        for(int i=4; i<=n; i++){
            long ans = (res3*2 + res1)%mod;
            res1 = res2;
            res2 = res3;
            res3 = ans;
        }
        return (int) res3;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public int numTilings(int n) {
        //using dp

        if(n==0 || n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 5;
        }

        int mod = 1000000007;

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for(int i =4; i<=n ;i++){
            dp[i] = ((2*dp[i-1])%mod) + dp[i-3];
            dp[i] %= mod;
        }
        return (int)dp[n];
    }
}

// TC: O(n)
// SC: O(n)