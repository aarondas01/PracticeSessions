class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum =Integer.MIN_VALUE;

        int sum = 0;

        for(int n : nums){
            sum +=n;
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum =0;
            }
        }

        //for Printing the maxSum Subarray
        // int currentIndex = 0;
        // int currentSum = 0, globalMax= Integer.MIN_VALUE;
        // int currentStart = 0;
        // int startIndex = 0, endIndex = 0;

        // for(int i = 0 ; i < nums.length; i++){
        //     currentSum += nums[i];
        //     if(currentSum < 0){
        //         currentSum = 0;
        //         currentStart = i+1;
        //     }
        //     else if( currentSum > globalMax){
        //         globalMax = currentSum;
        //         startIndex = currentStart;
        //         endIndex = i+1;
        //     }
        // }
        // for(int j = startIndex; j < endIndex; j++){
        //     System.out.print(nums[j]+",");
        // }


        return maxSum;
    }
}

// TC: O(n)
// SC: O(1)


class Solution {
    public int maxSubArray(int[] nums) {
        //using dp

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int max = dp[0];
        for(int i =1; i < n ; i++){
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}

// TC: O(n)
// SC: O(n)