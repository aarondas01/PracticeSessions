class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        //dp
        //move from destination to source


        //if val  < 0 we need 1 health more than the negative val
        //else if it is positive then 1 health is enough

        //fill the last row and last column of the dp
        //find the minimum of right and down from dp



        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        // fill the bottomm right corner of the dp
        dp[m-1][n-1] = Math.max(1 - dungeon[m-1][n-1],1);

        //fill the last row
        for(int i = n-2; i>=0; i--){
            int val = dungeon[m-1][i];
            dp[m-1][i] = Math.max(dp[m-1][i+1]-val,1);
        }

        //fill the last column
        for(int i = m-2; i >=0 ; i--){
            int val = dungeon[i][n-1];
            dp[i][n-1] = Math.max(dp[i+1][n-1]-val ,1);
        }

        //fill the remaining cells of the dp
        for(int i = m-2; i >= 0 ; i--){
            for(int j = n-2; j>=0; j--){
                int val = dungeon[i][j];
                int min = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.max(min-val,1);
            }
        }

        return dp[0][0];


    }
}

// TC: O(m*n)
// SC: O(m*n)