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

