Largest Plus Sign


class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int[][] inputGrid = new int[n][n];
        for(int[] row: inputGrid){
            Arrays.fill(row, 1);
        }
        for(int[] mine : mines){

            inputGrid[mine[0]][mine[1]] =0;
        }


        int[][] lTR = new int[n][n];

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<n;j++){

                if(inputGrid[i][j] == 0){
                    sum = 0;
                } else {
                    sum = inputGrid[i][j]+sum;
                }

                lTR[i][j]  = sum;
            }
        }



        int[][] rTL = new int[n][n];

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=n-1;j>=0;j--){
                if(inputGrid[i][j] == 0){
                    sum = 0;
                } else {
                    sum = inputGrid[i][j]+sum;
                }
                rTL[i][j] = sum;
            }
        }

        int[][] tTB = new int[n][n];

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                if(inputGrid[j][i] == 0){
                    sum = 0;
                } else {
                    sum = inputGrid[j][i]+sum;
                }

                tTB[j][i]  = sum;
            }
        }



        int[][] bTT = new int[n][n];

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=n-1;j>=0;j--){
                if(inputGrid[j][i] == 0){
                    sum = 0;
                } else {
                    sum = inputGrid[j][i]+sum;
                }

                bTT[j][i]  = sum;
            }
        }
        int ans=0;

        for(int i = 0 ; i < n ; i++){
            for(int j=0 ; j < n ; j++){
                int minLen = Math.min(Math.min(lTR[i][j],rTL[i][j]),Math.min(bTT[i][j],tTB[i][j]));
                ans = Math.max(ans,minLen);
            }
        }
        return ans;
    }

}


class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        int[][] dp = new int[n][n];

        for(int[] mine : mines){
            banned.add(mine[0] * n + mine[1]);
        }
        int ans = 0, count ;

        for(int r = 0 ; r < n ; r++){
            count = 0;
            for(int c = 0 ; c < n ; c++){
                count = banned.contains(r*n+c) ? 0 : count+1;
                dp[r][c] = count;
            }

            count  = 0 ;
            for(int c = n-1; c >=0; c--){
                count = banned.contains(r*n+c) ? 0 : count+1;
                dp[r][c] = Math.min(dp[r][c],count);
            }
        }

        for(int c= 0 ; c < n ; c++){
            count = 0;
            for(int r = 0 ; r < n ; r++){
                count = banned.contains(r*n +c) ? 0 : count+1;
                dp[r][c] = Math.min(dp[r][c],count);
            }

            count  = 0;
            for(int r = n-1; r >=0 ; r--){
                count = banned.contains(r*n+c)? 0 : count+1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans,dp[r][c]);
            }
        }
        return ans;
    }
}

// TC: O(N^2)
// SC: O(N^2)

