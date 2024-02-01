class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int minSubarraySum = Integer.MAX_VALUE, minSum = 0;
        int maxSubarraySum = Integer.MIN_VALUE, maxSum = 0;

        for(int n : nums){
            totalSum += n;

            maxSum += n;
            maxSubarraySum = Math.max(maxSubarraySum, maxSum);
            if(maxSum < 0){
                maxSum = 0;
            }

            minSum += n;
            minSubarraySum = Math.min(minSubarraySum, minSum);
            if(minSum > 0){
                minSum = 0;
            }
        }

        if(totalSum == minSubarraySum){
            return maxSubarraySum;
        }

        int maxCircularSubarraySum = totalSum - minSubarraySum;
        return Math.max(maxSubarraySum,maxCircularSubarraySum);
    }
}

// TC: O(N)
// SC: O(1)