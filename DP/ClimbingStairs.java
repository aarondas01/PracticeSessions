class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1 ){
            return 1;
        }

        int prev =1, curr =1;

        for(int i =2; i<= n ; i++){
            int temp = curr;
            curr = curr+prev;
            prev = temp;
        }
        return curr;
    }
}

// TC: O(n)
// SC; O(1)

class Solution {
    public int climbStairs(int n) {
        //using dp

        if(n==0 || n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i =2 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
// TC: O(n)
// SC: O(n)