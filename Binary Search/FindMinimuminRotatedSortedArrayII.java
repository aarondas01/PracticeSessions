class Solution {
    public int findMin(int[] nums) {
        //contains duplicates
        //binary search

        int start = 0 , end = nums.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] < nums[end]){
                end = mid;
            }
            else if(nums[mid] == nums[end]){
                end = end-1;
            }
            else{
                start = mid+1;
            }
        }
        return nums[start];
    }
}

// TC: O(logn)
// SC: O(1)