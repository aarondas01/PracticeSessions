class Solution {
    public int minPathSum(int[][] grid) {
        //using dp;

        if(grid ==  null || grid.length == 0){
            return 0;
        }


        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = grid[i][j];

                if(i >0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                }

                else if(i > 0){
                    dp[i][j] += dp[i-1][j];
                }
                else if( j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// TC: O(mn)
// SC: O(mn)


class Solution {
    public int minPathSum(int[][] grid) {
        //dp
        //changes the original array

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i > 0 && j > 0){
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
                else if(i > 0){
                    grid[i][0] += grid[i-1][0];
                }
                else if(j > 0){
                    grid[0][j] += grid[0][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}

// TC: O(m*n)
// SC: O(1)