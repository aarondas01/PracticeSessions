class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;

        for(int n : nums){
            if(n!= val){
                nums[i++]= n;
            }
        }
        return i;
    }
}

// TC:O(n)
// SC: O(1)


class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;

        for(int j = 0 ; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

// TC: O(n)
// SC: O(1)