class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);

        return result;
    }

    private int findFirst(int[] nums, int target){
        int ans = -1;
        int start = 0, end = nums.length-1;



        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                ans = mid;
                end = mid-1;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

    private int findLast(int[] nums, int target){
        int ans = -1;
        int start = 0, end = nums.length-1;



        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                ans = mid;
                start = mid+1;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
}

// TC: O(logn)
// SC: O(1)