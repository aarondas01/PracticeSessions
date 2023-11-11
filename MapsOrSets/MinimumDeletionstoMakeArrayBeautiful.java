class Solution {
    public int minDeletion(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i = 0 ; i < n-1; i++){
            int index = i-count;
            if(index %2 == 0 && nums[i] == nums[i+1]){
                count++;
            }
        }
        return  (n-count) %2 == 0 ? count : count+1;
    }
}
// TC: O(n)
// SC: O(1)