
class Solution {
    public int uniquePaths(int m, int n) {
        //dp solution

        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m; i++){
            Arrays.fill(dp[i], 1);
        }

        for(int i = 1 ; i < m ; i++){
            for(int j =1 ; j < n ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}

// TC: O(m*n)
// SC: O(m*n)


class Solution {
    public int uniquePaths(int m, int n) {
        //using 1D dp
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1; i < m ; i++){
            for(int j = 1; j < n ; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];

    }
}

// TC: O(m*n)
// SC: O(n)


class Solution {
    public int uniquePaths(int m, int n) {
        int total = m+n-2;
        int rows =m-1;
        double count =1;
        for(int i =1 ; i<= rows;i++){
            count = count * (total-rows+i)/i;
        }
        return (int) count;
    }
}

// TC: O(m)
// SC: O(1)