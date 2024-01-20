class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans = Long.MAX_VALUE;

        long left = Long.MAX_VALUE;
        long right = Long.MIN_VALUE;

        for(int n : nums){
            left = Math.min(left,n);
            right = Math.max(right,n);
        }


        while(left <= right){
            long mid = left + (right-left)/2;

            long cost1 = findCost(nums,cost,mid);
            long cost2 = findCost(nums,cost,mid+1);

            ans = Math.min(cost1,cost2);

            if(cost2 > cost1){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return (ans == Long.MAX_VALUE ? 0 : ans);

    }

    private long findCost(int[] nums, int[] cost, long target){

        long res =0;

        for(int i = 0 ; i < nums.length ; i++){
            res += Math.abs(nums[i]-target)*cost[i];
        }
        return res;
    }
}
// TC: O(n*logn)
// SC: O(1)