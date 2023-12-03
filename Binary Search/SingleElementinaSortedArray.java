class Solution {
    public int singleNonDuplicate(int[] nums) {
        //binary search

        int start = 0 , end = nums.length -1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            boolean evenLength = (end-mid)%2 == 0 ;
            if(nums[mid]== nums[mid-1]){
                if(evenLength){
                    end = mid-2;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(evenLength){
                    start = mid+2;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return nums[start];
    }
}

// TC: O(logn)
// SC: O(1)

