class Solution {
    public int partitionDisjoint(int[] nums) {
        //move from left to right to find the maximum element at each element
        int n = nums.length;
        int[] leftMax = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;  i < n; i++){
            max = Math.max(max, nums[i]);
            leftMax[i] = max;
        }

        ///move from right to left to find the minimum element at each index
        int[] rightMin = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i = n-1; i >=0; i--){
            min = Math.min(min,nums[i]);
            rightMin[i] = min;
        }

        for(int i =1; i < n ; i++){
            if(leftMax[i-1] <= rightMin[i]){
                return i;
            }
        }
        return nums.length;
    }
}
// TC: O(n)
// SC: O(n)


class Solution {
    public int partitionDisjoint(int[] nums) {
        int maxNum = nums[0];
        int maxInLeftPartition = nums[0];
        int part = 0;
        for(int i = 1 ; i < nums.length; i++){
            maxNum = Math.max(maxNum, nums[i]);
            if(nums[i] < maxInLeftPartition){
                maxInLeftPartition = maxNum;
                part = i;
            }

        }
        return part+1;
    }
}

// TC: O(n)
// SC: O(1)