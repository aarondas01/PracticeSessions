class Solution {
    public int singleNumber(int[] nums) {
        int c =0;
        for(int n : nums){
            c ^= n;
        }
        return c;
    }
}

// TC: O(n)
// SC: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1; i+=2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

// TC: O(nlogn)
// SC: O(1)