Unique Binary Search Trees

class Solution {
    private int[] dp = new int[20];
    public int numTrees(int n) {

        //dp top down
        if(n<=1){
            return 1;
        }
        if(dp[n]> 0){
            return dp[n];
        }
        for(int i =1 ; i <= n ; i++){
            dp[n] += numTrees(i-1)* numTrees(n-i);
        }
        return dp[n];
    }
}

// TC: O(n^2)
// SC: O(n)