class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m+1][n+1];

        int max =0;

        for(int i=1; i <= m ;i++){
            for(int j =1 ; j<= n ;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max,dp[i][j]);
                }

            }
        }
        return max;
    }
}

// TC: O(m*n)
// SC: O(m*n)

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m][n];
        int res = 0;

        for(int i =0 ;i <m ; i++){
            for(int j = 0;j<n ;j++){
                if(nums1[i] != nums2[j]){
                    dp[i][j] = 0;
                }
                else{
                    if(i-1>=0 && j-1>=0){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = 1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }
}

// TC: O(m*n)
// SC: O(m*n)