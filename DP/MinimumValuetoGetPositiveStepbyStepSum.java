
class Solution {
    public int minStartValue(int[] nums) {
        int prefixSum = 0;
        int min  =0;
        for(int n : nums){
            prefixSum += n;
            min = Math.min(min,prefixSum);
        }
        return (min<0) ? Math.abs(min)+1 : 1;
    }
}

// TC: O(n)
// SC: O(1)