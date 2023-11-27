class Solution {
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        //dp using memoization

        //similar to knapsack
        int n = piles.size();
        dp = new int[n+1][k+1];
        return  helper(piles, piles.size()-1,k);
    }

    //i is the current pile in consideration
    private int helper(List<List<Integer>> piles,int i, int k)
    {
        if(i < 0 || k < 0){
            return 0;
        }

        if(dp[i][k] != 0){
            return dp[i][k];
        }
        //what level you can consume the current pile
        int n = Math.min(piles.get(i).size(), k);
        //not selecting the current pile
        int exclude =  helper(piles,i-1,k);

        //including the pile
        int include = 0;
        for(int j = 0 , sum = 0 ; j < n ; j++){
            sum += piles.get(i).get(j);
            include = Math.max(sum + helper(piles,i-1,k-j-1),include);
        }

        int res = Math.max(include,exclude);
        dp[i][k] = res;
        return res;


    }

}

//TC: O(m*n)
//        SC: O(m)