class Solution {
    public boolean stoneGame(int[] piles) {
        int a = 0 , b = 0;
        int n = piles.length;
        for(int i = 0 ; i < n/2; i++){

            int min = piles[i];
            int max = piles[n-1-i];



            a+= Math.max(max,min);
            b+= Math.min(min,max);
        }
        if(a>b){
            return true;
        }else{
            return false;
        }
    }
}
// TC: O(n)
// SC: O(1)
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n+2][n+2];

        for(int size =1; size <= n ; size++){
            for(int i = 0 ; i + size <= n; i++){
                int j = i+size-1;
                int parity = (i+j+n)%2;
                if(parity ==1){
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1],piles[j] + dp[i+1][j]);
                }
                else{
                    dp[i+1][j+1] = Math.min(piles[i]+ dp[i+2][j+1], piles[j]+ dp[i+1][j]);
                }
            }
        }
        return dp[1][n]>0;
    }
}

// TC: O(n^2)
// SC : O(n^2)


class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}