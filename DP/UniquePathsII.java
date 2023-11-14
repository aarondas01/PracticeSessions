class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int in[] : dp ){
            Arrays.fill(in,-1);
        }

        return helper(m-1,n-1,dp,obstacleGrid);
    }

    private int helper(int i , int j , int[][]  dp , int[][] obstacleGrid){
        if( i < 0 || j < 0){
            return 0;
        }
        if( i >= 0 && j >=0 && obstacleGrid[i][j] ==1){
            return 0;
        }
        if( i == 0 && j ==0 ){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int p  = helper(i-1,j,dp,obstacleGrid);
        int q = helper(i,j-1,dp,obstacleGrid);

        return dp[i][j] = p+q;
    }
}

// TC: O(m*n)
// SC: O(m*n)



class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] ==1){
            return 0;
        }

        int[][] dp = new int[m][n];


        for(int i = 0 ; i < n ; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            else{
                dp[0][i] = 1;
            }
        }

        for(int i = 0 ; i < m ; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            else{
                dp[i][0] =1;
            }
        }


        for(int i=1; i < m ; i++){
            for(int j = 1; j < n ; j++){
                if(obstacleGrid[i][j] ==1){
                    dp[i][j] =0;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }
}

// TC: O(m*n)
// SC: O(m*n)