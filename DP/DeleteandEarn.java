class Solution {
    public int deleteAndEarn(int[] nums) {
        //dp
        int maxValue = 0;
        for(int n  : nums){
            maxValue = Math.max(maxValue,n);
        }

        int[] dp = new int[maxValue+1];

        for(int n : nums){
            dp[n] += n;
        }

        dp[1] = Math.max(dp[0],dp[1]);

        for(int i =2; i < maxValue+1 ; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+dp[i]);
        }
        return dp[maxValue];
    }
}

// TC: O(n)
// SC: O(n)


class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];

        for(int n : nums){
            dp[n] += n;
        }

        for(int i =2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+dp[i]);
        }

        return dp[10000];
    }
}
// TC: O(n)
// sc: O(n)

