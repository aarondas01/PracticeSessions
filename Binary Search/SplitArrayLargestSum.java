class Solution {
    public int splitArray(int[] nums, int k) {
        //range based binary search
        // // choose a max allowed subset sum and find the no of subset than can be formed
        // if no of subset formed is > k
        //     increase the max allowed subset sum update low pointer
        //     decrease the max allowed subset sum update the high pointer

        int start  = 0 , end  = 0;

        // find the lower bound (left) and upper bound(totalSum)
        for(int n : nums){
            start = Math.max(start,n);
            end += n;
        }

        int ans = start;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(splitCheck(nums, mid,k)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;

    }

    private boolean splitCheck(int[] nums, int mid, int k){
        int sum = 0;
        int splits = 1;
        for(int n : nums){
            sum += n;
            if(sum > mid){
                sum = n;
                splits++;
            }
        }
        return splits <= k;
    }
}

// TC: O(logn)
// SC: O(1)