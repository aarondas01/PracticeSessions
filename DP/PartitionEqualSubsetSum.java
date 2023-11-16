class Solution {
    public boolean canPartition(int[] nums) {
        //dp using tabulation

        int sum = 0;

        for(int n : nums ){
            sum += n;
        }

        if(sum %2 !=0){
            return false;
        }

        int half = sum/2;

        boolean[][] dp = new boolean[nums.length+1][half+1];


        for(int i= 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i =1; i < dp.length; i++){
            for(int j=1 ; j < dp[0].length; j++){
                if(nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]  || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][half];
    }
}

// TC: O(sum * nums.length)
// SC: O(sum)


class Solution {
    public boolean canPartition(int[] nums) {
        //dp memoization

        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        if(sum%2 != 0){
            return false;
        }

        int half = sum/2;

        Boolean[][] dp = new Boolean[nums.length+1][half+1];

        //sum of each half should be same
        return subsetSum(nums,0,half,dp);
    }

    private boolean subsetSum(int[] nums, int index, int sum, Boolean[][] dp){
        if(sum ==0){
            return true;
        }
        else if(index >= nums.length || sum < 0){
            return false;
        }
        if(dp[index][sum] != null){
            return dp[index][sum];
        }

        return dp[index][sum] = subsetSum(nums,index+1,sum-nums[index],dp) || subsetSum(nums, index+1,sum,dp);
    }
}

// TC: O(n^2)
// SC: O(n^2)

class Solution {
    public boolean canPartition(int[] nums) {

        //1D Dp
        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        if(sum%2 != 0){
            return false;
        }

        int half = sum/2;

        boolean[] dp = new boolean[half+1];

        dp[0] = true;

        for(int j : nums){
            for(int k = half; k>0; k--){
                if(k>=j){
                    dp[k] = dp[k] || dp[k-j];
                }
            }
        }
        return dp[half];
    }


}

// TC: O(nk)
// SC: O(k)