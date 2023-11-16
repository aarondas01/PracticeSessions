class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //i = row index for both robots
        //j1 = col index for first robot
        //j2 = col index for second robot
        Integer[][][] dp = new Integer[m][n][n];

        return dfs(grid,m,n ,0, 0, n-1,dp);

    }

    private int dfs(int[][] grid , int m , int n , int r, int col1, int col2, Integer[][][] dp){
        if(r<0 || r >= m || col1 < 0 || col1 >=n || col2 <0 || col2 >= n){
            return 0;
        }

        if(dp[r][col1][col2] != null){
            return dp[r][col1][col2];
        }

        int maxCherries = 0;

        //moves for left, centre and right
        for(int i=-1; i <=1;i++){
            for(int j = -1 ; j <= 1 ; j++ ){
                int newCol1 = col1 +i;
                int newCol2 = col2 +j;
                maxCherries = Math.max(maxCherries,dfs(grid,m,n,r+1,newCol1,newCol2,dp));
            }
        }

        int currCherry = 0;
        if(col1 == col2){
            currCherry = grid[r][col1];
        }
        else{
            currCherry = grid[r][col1] + grid[r][col2];
        }

        dp[r][col1][col2] = currCherry + maxCherries;
        return dp[r][col1][col2];
    }
}

// TC: O(m*n*n)
// SC: O(m*n*n)

