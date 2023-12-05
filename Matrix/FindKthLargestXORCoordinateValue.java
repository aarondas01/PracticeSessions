class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i+1][j+1] = matrix[i][j] ^ dp[i+1][j] ^ dp[i][j+1] ^ dp[i][j];

                pq.offer(dp[i+1][j+1]);

                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}

// TC: O(m*n)
// SC: O(m*n)